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
		
		<title>Buscar por Cédula | Examen</title>
	</head>
	
	<body>
	
		<section class="container" style="margin-top: 50px">
			<h1>Listado por Cédula</h1>
			
			<div class="row justify-content-center">
				<form class="form-group row" onsubmit="searchByDNI();" method="get">
					<div class="col-10">
						<label for="searchKey">Ingrese una cédula:</label>
						<input type="text" name="searchKey" id="searchKey" class="form-control" />
					</div>
					<div class="col-1">
						<label for=""></label>
						<button type="submit" class="btn btn-primary">Buscar</button>
					</div>
				</form>
			</div>
			
			<div class="row table-responsive">
				<table class="table table-bordered" id="up-list">
					<thead class="bg-dark text-light">
		      			<tr>
		      				<th scope="col">Cédula</th>
		      				<th scope="col">Nombres</th>
					        <th scope="col">Apellidos</th>
					        <th scope="col">E-mail</th>
					        <th scope="col">Teléfono</th>
					        <th scope="col">Operadora</th>
					        <th scope="col">Tipo</th>
		      			</tr>
		      		</thead>
	      			
	      			<tbody>
	      			<c:forEach var="user" items="${users}">
		      			<tr>
		      				<td>${user.dni}</td>
		      				<td>${user.name}</td>
		      				<td>${user.lastname}</td>
		      				<td>${user.email}</td>
		      				<c:set var="phoneSize" value="${user.phoneList.size()}"/>
		      				<c:set var="count" scope="request" value="${0}" />
							<c:forEach var="phone" items="${user.phoneList}">
								<c:choose>
									<c:when test="${count == 0}">
				      					<td>${phone.number}</td>
				      					<td>${phone.provider.name}</td>
				      					<td>${phone.phoneType.name}</td>
					      			</c:when>
					      			<c:otherwise>
					      				<tr>
					      					<td colspan="4"></td>
						      				<td>${phone.number}</td>
					      					<td>${phone.provider.name}</td>
					      					<td>${phone.phoneType.name}</td>
				      					</tr>
					      			</c:otherwise>
				      			</c:choose>
				      			<c:set var="count" scope="request" value="${i+1}" />
							</c:forEach>
						</tr>
						<tr><td colspan="7"></td></tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
		</section>
	
	</body>
</html>