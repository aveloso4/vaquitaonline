package com.proyecto.cero.vaquita;

import java.security.Principal;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PostData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.cero.model.Vaquita;
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

  @RequestMapping(value = "/vaquitaCreada", method = RequestMethod.POST)
  public ModelAndView crearVaquita(@Valid VaquitaPrimerPasoForm form, BindingResult formBinding, WebRequest request) {
    ModelAndView model = new ModelAndView();
//    if (formBinding.hasErrors()) {
//      model.setViewName("redirect:/");
//      return model;
//    }
    Vaquita vaquita = crearVaquita(form, formBinding);
    model.addObject("vaquita", vaquita);
    model.setViewName("vaquitaCreada");
    return model;
  }
  
  @RequestMapping(value = "/crearVaquita", method = RequestMethod.GET)
  public ModelAndView crearVaquita(Principal user) {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("crearVaquita-1");
	  return model;
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Principal user,	@RequestParam(value = "id", required=true) int id) {
		ModelAndView model = new ModelAndView();

		Vaquita vaquita = vaquitaService.findVaquitaById(id);
		model.addObject("vaquita", vaquita);
		model.setViewName("vaquitaCreada");
		return model;
	}
  
  @RequestMapping(value = "/postInWall", method = RequestMethod.GET)
  public ModelAndView compartirVaquita(Principal user){
//  		FacebookLink fl = new FacebookLink("vaquita-project.herokuapp.com", null, "Vaquita Online", "Slogan de Vaquita", "Una descripcion Para Vaquita");
  		facebook.feedOperations().post((new PostData("me")).message("Hey! Vaquita Online! Compartan").link("vaquita-project.herokuapp.com", null, "Vaquita Online", "Slogan de Vaquita", "Una descripcion Para Vaquita"));
  		ModelAndView model = new ModelAndView();
  		model.setViewName("home");
  		return model;
  }

  
  // Internal Helpers
  private Vaquita crearVaquita(VaquitaPrimerPasoForm form, BindingResult formBinding) {
		Vaquita vaquita = new Vaquita(form.getNombre(), form.getDescripcion(), form.getImagen());
    vaquitaService.createVaquita(vaquita);
    return vaquita;
	}
}
