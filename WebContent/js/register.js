/**
 * Funciones que sirven para insertar nuevos usuarios y telefonos
 */

function registerUser(){
	var servlet = "/SarmientoBasurto-Bryan-Examen/CreateUser"
	var form = $("#user-form");

	$.post(servlet, form.serialize(), function(res){
		document.getElementById("notice").innerHTML = res;
	});
	//$.post(servlet, form.serialize(), function(){});
}

function registerPhone(){
	var servlet = "/SarmientoBasurto-Bryan-Examen/CreatePhone"
	var providerID = document.getElementById("provider_id").value;
	var phoneTypeID = document.getElementById("phoneType_id").value;
	var dni = document.getElementById("dni").value;
	var number = document.getElementById("number").value;
	
	$.get(servlet+"?dni="+dni+"&providerID="+providerID+"&phoneTypeID="+phoneTypeID+"&number="+number, function(res){
		document.getElementById("notice").innerHTML = res;
	});
	
	//var form = $("#phone-form");
	//$.post(servlet, form.serialize(), function(){	
	//});
}

