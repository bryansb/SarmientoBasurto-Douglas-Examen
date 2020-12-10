/**
 * Funciones que permiten listar y buscar usuarios por 
 * determinados criterios
 */

function searchByDNI(){
	var servlet = "/SarmientoBasurto-Bryan-Examen/ListByDNI"
	var searchKey = document.getElementById("searchKey").value;

	//$.get(servlet+"?searchKey="+searchKey);
	location.href = servlet+searchKey;
}

function searchByNumber(){
	var servlet = "/SarmientoBasurto-Bryan-Examen/ListByPhone"
	var searchKey = document.getElementById("searchKey").value;

	//$.get(servlet+"?searchKey="+searchKey);
	location.href = servlet+searchKey;
}