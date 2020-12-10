<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">

	<head>
		<meta charset="UTF-8">
		
		<link rel="stylesheet" href="/SarmientoBasurto-Bryan-Examen/css/bootstrap/bootstrap.min.css">
	    
		<script src="/SarmientoBasurto-Bryan-Examen/js/bootstrap/jquery-3.5.1.min.js"></script>
	    <script src="/SarmientoBasurto-Bryan-Examen/js/bootstrap/popper.min.js"></script>
	    <script src="/SarmientoBasurto-Bryan-Examen/js/bootstrap/bootstrap.min.js"></script>
	    
	    <script src="/SarmientoBasurto-Bryan-Examen/js/list.js"></script>
	    <script src="/SarmientoBasurto-Bryan-Examen/js/register.js"></script>
	    <script src="/SarmientoBasurto-Bryan-Examen/js/tables.js"></script>
		
		<title>Registro de Usuarios | Examen</title>
	</head>
	
	<body>
	
		<section class="container" style="margin-top: 75px">
		<div id="notice" class="row bg-dark text-light col-6" style="border-radius: 50px;"></div>
		
			<div class="row">
			
				<div class="col-6">
					<h1>Información Personal</h1>
				    <form id="user-form">
				    	<div class="form-group">
						    <label for="dni">Cédula:</label>
						    <input type="text" name="dni" id="dni"  class="form-control"/>
					    </div>
				    	<div class="form-group">
						    <label for="names">Nombres:</label>
						    <input type="text" name="names" id="names" class="form-control"/>
					    </div>
					    <div class="form-group">
						    <label for="lastnames">Apellidos:</label>
						    <input type="text" name="lastnames" id="lastnames"  class="form-control"/>
					    </div>
					    <div class="form-group">
						    <label for="email">E-mail:</label>
						    <input type="email" name="email" id="email"  class="form-control"/>
					    </div>
					    <div class="form-group">
						    <label for="password">Contraseña:</label>
						    <input type="password" name="password" id="password"  class="form-control"/>
					    </div>
					    <div class="form-group">
					    	<input type="button" class="btn btn-primary" value="Registrar Usuario" onclick="registerUser();"/>
					    </div>
				    </form>
			    </div>
			    
			    <div class="col-6">
					<h1>Datos del Teléfono</h1>
				    <form id="phone-form">
				    	<div class="form-group">
						    <label for="number">Número:</label>
						    <input type="text" name="number" id="number"  class="form-control"/>
					    </div>
				    	<div class="form-group">
						    <label for="provider_id" class="">Operadora:</label>
							<select name="provider_id" id="provider_id" class="form-control">
								<!-- Codigo tranfugo -->
								<c:forEach var="provider" items="${providers}">
					  				<option value="${provider.id}">${provider.name}</option>
					  			</c:forEach>
							</select>
					    </div>
					    <div class="form-group">
						    <label for="phoneType_id" class="">Tipo:</label>
							<select name="phoneType_id" id="phoneType_id" class="form-control">
								<!-- Codigo tranfugo -->
								<c:forEach var="phoneType" items="${phoneTypes}">
					  				<option value="${phoneType.id}">${phoneType.name}</option>
					  			</c:forEach>
							</select>
					    </div>
					    <div class="form-group">
					    	<input type="button" class="btn btn-primary" value="Registrar Teléfono" onclick="registerPhone();"/>
					    </div>
				    </form>
			    </div>
			    
		    </div>
		    
	    </section>
	
	</body>
</html>