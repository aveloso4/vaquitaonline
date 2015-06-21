package com.proyecto.cero.vaquita;

import java.security.Principal;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PostData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.cero.controller.ModelManager;
import com.proyecto.cero.model.Vaquita;
import com.proyecto.cero.model.Vaquita.ContributionType;
import com.proyecto.cero.model.Vaquita.Status;
import com.proyecto.cero.service.VaquitaService;

@Controller
public class VaquitaController {

	private final Facebook facebook;
	private final ProviderSignInUtils providerSignInUtils;
	private final VaquitaService vaquitaService;
	
	@Inject
	public VaquitaController(VaquitaService vs, Facebook facebook) {
		this.vaquitaService = vs;
		this.providerSignInUtils = new ProviderSignInUtils();
		this.facebook = facebook;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView crearVaquita(Principal user, Model modelo) {
		ModelAndView model = new ModelAndView();
		ModelManager.initializeModel(model, facebook);
		model.setViewName("newVaquita1");
		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
  public ModelAndView crearVaquita(@Valid VaquitaFirstStepForm form, BindingResult result, WebRequest request, Principal user, Model modelo) {
  	ModelAndView model = new ModelAndView();
  	ModelManager.initializeModel(model, facebook);
  	if (result.hasErrors()) {
  		model.setViewName("newVaquita1");
  		model.addObject("error","Ups! Algo a salido mal. Por favor asegurate de completar los campos requeridos (*)");
  		return model;
  	}
    	Vaquita vaquita = crearVaquita(form, result, user.getName());
    	request.setAttribute("ID", vaquita.getId(), RequestAttributes.SCOPE_GLOBAL_SESSION);
    	model.setViewName("newVaquita2");
    return model;
  }
	
	@RequestMapping(value = "/create_second", method = RequestMethod.POST)
	public ModelAndView createVaquitaSecondStep(@Valid VaquitaSecondStepForm form, BindingResult result, WebRequest request, Principal user, Model modelo) {
		ModelAndView model = new ModelAndView();
		ModelManager.initializeModel(model, facebook);
		
		if (result.hasErrors()) {
			System.out.println("@@@@@@@@@@@@@@@@@Start ERROR@@@@@@@@@@@@@@@@@@@");
			System.out.println(result);
			System.out.println("@@@@@@@@@@@@@@@@@End ERROR@@@@@@@@@@@@@@@@@");
			model.setViewName("newVaquita2");
			model.addObject("error","Ups! Algo a salido mal. Por favor asegurate de completar los campos requeridos (*)");
			return model;
		}
		
		int ID = (Integer) request.getAttribute("ID", RequestAttributes.SCOPE_GLOBAL_SESSION);
		Vaquita vaquita = vaquitaService.findVaquitaById(ID);
		updateVaquita(form, result, vaquita, request);
//    	model.addObject("vaquita", vaquita);
		model.setViewName("newVaquita3");
		return model;
	}
	 
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Principal user,	@RequestParam(value = "id", required=true) int id) {
		ModelAndView model = new ModelAndView();
		ModelManager.initializeModel(model, facebook);

		Vaquita vaquita = vaquitaService.findVaquitaById(id);
		model.addObject("vaquita", vaquita);
		model.setViewName("verVaquita");
		return model;
	}
	
	@RequestMapping(value = "/vaquitaCreada", method = RequestMethod.GET)
	public ModelAndView vaquitaCreada(Principal user,	@RequestParam(value = "id", required=true) int id) {
		ModelAndView model = new ModelAndView();
		ModelManager.initializeModel(model, facebook);

		Vaquita vaquita = vaquitaService.findVaquitaById(id);
		model.addObject("vaquita", vaquita);
		model.setViewName("vaquitaCreada");
		return model;
	}
  
  // Internal Helpers
  private Vaquita crearVaquita(VaquitaFirstStepForm form, BindingResult formBinding, String userName) {
		Vaquita vaquita = new Vaquita(form.getTitle(), form.getDescription(), form.getImage(), userName);
		vaquita.setStatus(Status.ACTIVE);;
    vaquitaService.createVaquita(vaquita);
    return vaquita;
	}
   
  private void updateVaquita(VaquitaSecondStepForm form, BindingResult formBinding, Vaquita vaquita, WebRequest request) {
  	vaquita.setContributionField(Boolean.parseBoolean(form.getContributionField()));
  	vaquita.setEndDate(Boolean.parseBoolean(request.getParameter("endDateCheck")) ? null : null);
  	vaquita.setContributionType(ContributionType.valueOf(request.getParameter("contributionType")));
  	vaquita.setContributionAmmount(ContributionType.valueOf(request.getParameter("contributionType")) == ContributionType.OPEN ? null : Integer.parseInt(request.getParameter("contributionAmmount")));

  	vaquita.setShowParicipantName(Boolean.parseBoolean(request.getParameter("showParicipantName")));
  	vaquita.setShowParticipantContribution(Boolean.parseBoolean(request.getParameter("showParticipantContribution")));
  	vaquita.setShowTotalAmmount(Boolean.parseBoolean(request.getParameter("showTotalAmmount")));
  	
  	boolean isPublic = Boolean.parseBoolean(request.getParameter("IsPublic"));
  	vaquita.setPublic(isPublic);
  	vaquita.setOpenInvitation(!isPublic ? false : Boolean.parseBoolean(request.getParameter("spenInvitation")));
  	vaquita.setMoneyTarget(Boolean.parseBoolean(request.getParameter("moneytargetCheck")) ? Integer.parseInt((request.getParameter("moneyTarget"))) : null);
  	vaquita.setOpenMessage(Boolean.parseBoolean(request.getParameter("openMessage")));
  	vaquita.setShowMessageWall(Boolean.parseBoolean(request.getParameter("showMessageWall")));
  	vaquita.setNotifyEmail(Boolean.parseBoolean(request.getParameter("notifyEmail")));
  	
  	vaquitaService.updateVaquita(vaquita);
	}
  
  @RequestMapping(value = "/postInWall", method = RequestMethod.GET)
  public ModelAndView compartirVaquita(Principal user){
//  		FacebookLink fl = new FacebookLink("vaquita-project.herokuapp.com", null, "Vaquita Online", "Slogan de Vaquita", "Una descripcion Para Vaquita");
  		facebook.feedOperations().post((new PostData("me")).message("Hey! Vaquita Online! Compartan").link("vaquita-project.herokuapp.com", null, "Vaquita Online", "Slogan de Vaquita", "Una descripcion Para Vaquita"));
  		ModelAndView model = new ModelAndView();
  		model.setViewName("home");
  		return model;
  }
}
