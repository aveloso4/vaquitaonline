package com.proyecto.cero.vaquita;

import java.security.Principal;
import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.cero.account.dao.VaquitaDao;
import com.proyecto.cero.model.Vaquita;
import com.proyecto.cero.service.UserService;
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
	public ModelAndView search(@Valid VaquitaForm form, BindingResult formBinding, WebRequest request, 
			@RequestParam(value = "nombre", required=false) String nombre, 
			@RequestParam(value = "creador", required=false) String creador, 
			@RequestParam(value = "organizador", required=false) String organizador,
			@RequestParam(value = "imagen", required=false) String imagen, 
			@RequestParam(value = "descripcion", required=false) String descripcion, 
			@RequestParam(value = "cancelReason", required=false) String cancelReason, 
			@RequestParam(value = "fechaInicio", required=false) Date fechaInicio, 
			@RequestParam(value = "fechaFin", required=false) Date fechaFin,
	    @RequestParam(value = "VaquitaPublica", required=false) boolean VaquitaPublica,
	    @RequestParam(value = "contributionField", required=false) boolean contributionField,
	    @RequestParam(value = "mostrarNombreParticipantes", required=false) boolean mostrarNombreParticipantes,
	    @RequestParam(value = "mostrarPlataParticipante", required=false) boolean mostrarPlataParticipante,
	    @RequestParam(value = "mostrarPlataTotalRecaudada", required=false) boolean mostrarPlataTotalRecaudada,
	    @RequestParam(value = "mensajeAbierto", required=false) boolean mensajeAbierto,
	    @RequestParam(value = "invitacionAbierta", required=false) boolean invitacionAbierta,
	    @RequestParam(value = "mostrarMuroMensajes", required=false) boolean mostrarMuroMensajes,
	    @RequestParam(value = "emailNotifications", required=false) boolean emailNotifications,
	    @RequestParam(value = "contribucionDefinida", required=false) int contribucionDefinida,
	    @RequestParam(value = "contribucionSugerida", required=false) int contribucionSugerida,
	    @RequestParam(value = "objetivoDeDinero", required=false) int objetivoDeDinero) {
		ModelAndView model = new ModelAndView();
		
//		Vaquita vaquitaABuscar = new Vaquita("Eugenio Valeiras",creador, organizador, imagen, descripcion, cancelReason, fechaInicio, fechaFin, vaquitaPublica, contributionField, mostrarNombreParticipantes, mostrarPlataParticipante, mostrarPlataTotalRecaudada, mensajeAbierto, invitacionAbierta, mostrarMuroMensajes, emailNotifications, contribucionDefinida, contribucionSugerida, objetivoDeDinero);
		Vaquita vaquita = vaquitaService.findVaquitaById(1);
//		for (Vaquita vaquita : vaquitas) {
			System.out.print(vaquita);
//		}
		model.addObject("vaquita", vaquita);
		model.setViewName("search");
		return model;
	}

  
  // Internal Helpers
  private Vaquita crearVaquita(VaquitaPrimerPasoForm form, BindingResult formBinding) {
		Vaquita vaquita = new Vaquita(form.getNombre(), form.getDescripcion(), form.getImagen());
    vaquitaService.createVaquita(vaquita);
    return vaquita;
	}

}
