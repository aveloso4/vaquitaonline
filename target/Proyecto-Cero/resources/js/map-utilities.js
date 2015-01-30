var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
var ViajeEncontrado = false;
var service = new google.maps.DistanceMatrixService();

function validateForm() {
	if (viajeEncontrado) {
		return true;
	} else {
		alert("No encontramos una ruta valida entre esas 2 ciudades");
		return false;
	}
}

//OBTENER LA RUTA
function calcRoute() {
	var start = document.getElementById("desde-crear").value;
	var end = document.getElementById("hasta-crear").value;
	var waypointsInput = document.getElementsByClassName("input_parada");
	var waypoints = [];
	for ( i = 0; i < waypointsInput.length; i++) {
		waypoints.push({
			location : waypointsInput[i].value,
			stopover : true
		});
	}

	var request = {
		origin : start,
		destination : end,
		travelMode : google.maps.TravelMode.DRIVING,
		unitSystem : google.maps.UnitSystem.IMPERIAL,
		provideRouteAlternatives : true,
		waypoints: waypoints,
		optimizeWaypoints: true
	};
	directionsService.route(request, function(result, status) {
		if (status == google.maps.DirectionsStatus.OK) {
			viajeEncontrado = true;
			directionsDisplay.setDirections(result);
		} else {
			//TODO MANEJO DE EXEPCIONES https://developers.google.com/maps/documentation/javascript/directions?hl=es
			viajeEncontrado = false;
		}
	});
}

//INITIALIZE GOOGLE MAP
function initialize() {
	var center = new google.maps.LatLng(-37.5961848, -43.8441229);
	var myOptions = {
		zoom : 1,
		center : center,
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		mapTypeControl : true
	};

	map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			map.setCenter(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
			map.setZoom(12);
		}, function() {
			//SI FALLA NO HACER NADA
		});
	} else {
		alert("NO GEOLOCATIN IN YOUR BROWSER");
	}

	var rendererOptions = {
		draggable : false,
		map : map
	};
	directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);

	//AUTOCOMPLETE FIELDS
	var dc = document.getElementById('desde-crear');
	var hc = document.getElementById('hasta-crear');
	var db = document.getElementById('desde-buscar');
	var hb = document.getElementById('hasta-buscar');
	var autocomplete = new google.maps.places.Autocomplete(dc);
	var autocomplete = new google.maps.places.Autocomplete(hc);
	var autocomplete = new google.maps.places.Autocomplete(db);
	var autocomplete = new google.maps.places.Autocomplete(hb);

}

google.maps.event.addDomListener(window, 'load', initialize);
