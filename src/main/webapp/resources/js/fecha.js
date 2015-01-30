function dateValidate(inputField) {
	var pickeddate = new Date(inputField.value);
	var todayDate = new Date();
	var maxDate = new Date(todayDate.getFullYear() + 2, todayDate.getMonth(), todayDate.getDate());

	if (pickeddate >= todayDate && pickeddate <= maxDate) {
		return true;
	} else {
		inputField.valueAsDate = new Date()
	}
}

//COLOCAR MINIMO Y MAXIMO
$(function() {
	var dtToday = new Date();
	var month = dtToday.getMonth() + 1;
	var day = dtToday.getDate();
	var year = dtToday.getFullYear();
	if (month < 10)
		month = '0' + month.toString();
	if (day < 10)
		day = '0' + day.toString();
	var minDate = year + '-' + month + '-' + day;
	var maxDate = year + 2 + '-' + month + '-' + day;

	$('#fecha-Crear').attr('min', minDate);
	$('#fecha-Crear').attr('max', maxDate);
	$('#fecha-Buscar').attr('max', maxDate);
	$('#fecha-Crear').val(minDate);
}); 