function pulsar(e) {
	tecla = (document.all) ? e.keyCode : e.which;
	return (tecla != 13);
}

var indexID = 1;
var flagPrimeraParada = false;
function crearParada() {

	var paradas = document.getElementById('paradas');

	if (!flagPrimeraParada) {
		flagPrimeraParada = true;
		var br = document.createElement("br");
		var checkbox = document.createElement("input");
		paradas.innerHTML = "Mantener Orden";
		checkbox.type = "checkbox";
		checkbox.name = "mantener_orden";
		checkbox.id = "mantener_orden";
		checkbox.onclick = function() {
			calcRoute();
		};
		paradas.appendChild(checkbox);
		paradas.appendChild(br);
	}

	var divParada = document.createElement("div");
	divParada.id = "divParada_" + indexID;
	paradas.appendChild(divParada);

	var label = document.createElement("label");
	label.innerHTML = "Parada: ";
	label.id = "label_" + indexID;
	divParada.appendChild(label);

	var input = document.createElement("input");
	input.type = "text";
	input.id = 'input_parada_' + indexID;
	input.className = input.className + "input_parada";
	input.onblur = function() {
		calcRoute();
	};

	var autocomplete = new google.maps.places.Autocomplete(input);
	divParada.appendChild(input);

	var boton = document.createElement("input");
	boton.type = "button";
	boton.value = "Borrar";
	boton.id = "boton_" + indexID;
	boton.addEventListener("click", function() {
		removeParada(this.id);
	});
	divParada.appendChild(boton);

	indexID++;
}

function removeParada(id) {
	id = id.replace("boton_", "divParada_");
	document.getElementById(id).remove();
	calcRoute();
}

