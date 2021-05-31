<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidatos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style=" background-color: pink ">
			<div>
                <a href="#" class="navbar-brand"> Gestión Candidatos </a>
            </div>
            
            <ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Candidatos</a></li>
            </ul>
		
		</nav>
	</header>
	<br/>
	
	<div class="row">
           
                <div class="container">
                    <h3 class="text-center">Listado de Candidatos</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Candidato</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Documento</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Eleccion</th>
                                <th>Numero</th>
                                <th>Editar o Eliminar </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="candidato" items="${listCandidatos}">

                                <tr>
                                    <td>
                                        <c:out value="${candidato.id}" />
                                    </td>
                                     <td>
                                        <c:out value="${candidato.documento}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.apellido}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.eleccion}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.numero}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${candidato.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${candidato.id}' />">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
	
</body>
</html>