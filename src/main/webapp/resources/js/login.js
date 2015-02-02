//INITIALIZE GOOGLE MAP
function initialize() {

	//AUTOCOMPLETE FIELDS
	var db = document.getElementById('desde-buscar');
	var hb = document.getElementById('hasta-buscar');
	var autocomplete = new google.maps.places.Autocomplete(db);
	var autocomplete = new google.maps.places.Autocomplete(hb);

}

google.maps.event.addDomListener(window, 'load', initialize);