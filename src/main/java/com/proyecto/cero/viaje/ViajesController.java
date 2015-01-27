package com.proyecto.cero.viaje;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.cero.account.AccountRepository;

@Controller
public class ViajesController {

	private final ViajeRepository viajeRepository;
	
	@Inject
	public ViajesController(ViajeRepository viajeRepository, AccountRepository accountRepository) {
		this.viajeRepository = viajeRepository;
	}

	@RequestMapping(value = "/crearVIaje", method = RequestMethod.POST)
	public ModelAndView buscarViaje(@Valid ViajesForm form, BindingResult formBinding, WebRequest request) {
		ModelAndView model = new ModelAndView();
		if (formBinding.hasErrors()) {
			model.setViewName("redirect:/");
			return model;
		}
		Viaje viaje = crearViaje(form, formBinding);
		model.addObject("viaje",viaje);
		model.setViewName("viajeCreado");
		return model;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@Valid ViajesForm form, BindingResult formBinding, WebRequest request, 
			@RequestParam(value = "desde", required=false) String desde, 
			@RequestParam(value = "hasta", required=false) String hasta, 
			@RequestParam(value = "costo", required=false) String costo,
		@RequestParam(value = "creador", required=false) String creador, 
		@RequestParam(value = "fecha", required=false) String fecha, 
		@RequestParam(value = "cupos", required=false, defaultValue="1") int cupos, 
		@RequestParam(value = "acompaniantes", required=false) String acompaniantes) {
		ModelAndView model = new ModelAndView();
		
		Viaje viajeABuscar = new Viaje(creador, desde, hasta, cupos, acompaniantes, costo, fecha);
		List<Viaje> viajes = getViajeRepository().findViajes(viajeABuscar);
		for (Viaje viaje : viajes) {
			System.out.print("Desde: " + viaje.getDesde());
			System.out.print(" - Hasta: " + viaje.getHasta());
			System.out.println(" - Costo: " + viaje.getCosto());
		}
		model.addObject("viajes", viajes);
		model.setViewName("search");
		return model;
	}

	// Internal Helpers
	private Viaje crearViaje(ViajesForm form, BindingResult formBinding) {
		try {
			Viaje viaje = new Viaje("Eugenio Valeiras",form.getDesde(), form.getHasta(), form.getCupos(), "", form.getCosto(), form.getFecha());
			getViajeRepository().createViaje(viaje);
			return viaje;
		} catch (ViajeInvalidoException e) {
			formBinding.rejectValue("EXCEPCION A EJECUTAR", "exe", "error");
			return null;
		}
	}

	private ViajeRepository getViajeRepository() {
		return viajeRepository;
	}

}
