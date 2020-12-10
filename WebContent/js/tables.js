/**
 * Se crean las funciones que permiten crear los datos de las tablas:
 * PROVIDERS
 * PHONE_TYPES
 */

function registerProviders(){
	var servlet = "CreateProvider"
	$.get(servlet, function(res){
		document.getElementById("notice").innerHTML = res;
	});
}

function registerPhoneTypes(){
	var servlet = "CreatePhoneType"
	$.get(servlet, function(res){
		document.getElementById("notice").innerHTML = res;
	});
}
