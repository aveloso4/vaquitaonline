package com.proyecto.cero.viaje;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViajesController {

	private final ViajeRepository viajeRepository;

	// private final ProviderSignInUtils providerSignInUtils;

	@Inject
	public ViajesController(ViajeRepository viajeRepository) {
		this.viajeRepository = viajeRepository;
		// this.providerSignInUtils = new ProviderSignInUtils();
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView buscarViaje(@Valid ViajesForm form, BindingResult formBinding, WebRequest request) {
		ModelAndView model = new ModelAndView();

		Viaje viaje = crearViaje(form, formBinding);
		if (viaje != null) {
			model.addObject("viajes", viaje);
		}
		model.setViewName("search");
		return model;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@Valid ViajesForm form, BindingResult formBinding, WebRequest request, 
			@RequestParam(value = "desde", required=false) String desde, 
			@RequestParam(value = "hasta", required=false) String hasta, 
			@RequestParam(value = "costo", required=false) String costo) {
		ModelAndView model = new ModelAndView();
		Viaje viajeABuscar = new Viaje(desde, hasta, costo);
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
			Viaje viaje = new Viaje(form.getDesde(), form.getHasta(), form.getCosto());
			getViajeRepository().createViaje(viaje);
			return viaje;
		} catch (ViajeInvalidoException e) {
			formBinding.rejectValue("exception", "exe", "error");
			return null;
		}
	}

	private ViajeRepository getViajeRepository() {
		return viajeRepository;
	}

}
