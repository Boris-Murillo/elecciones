<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Giro de Italia</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style=" background-color: pink ">
			<div>
                <a href="#" class="navbar-brand"> Gestión Ciclistas </a>
            </div>
            
            <ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Ciclistas</a></li>
            </ul>
		
		</nav>
	</header>
	<br/>
	
	<div class="row">
           
                <div class="container">
                    <h3 class="text-center">Listado de Ciclistas</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Ciclista</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Pais</th>
                                <th>Team</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="cyclist" items="${listCyclists}">

                                <tr>
                                    <td>
                                        <c:out value="${cyclist.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${cyclist.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${cyclist.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${cyclist.pais}" />
                                    </td>
                                    <td>
                                        <c:out value="${cyclist.team}" />
                                    </td>
                                   <%--  <td>
                                        <c:out value="${cyclist.fecha}" />
                                    </td> --%>
                                    <td><a href="edit?id=<c:out value='${cyclist.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${cyclist.id}' />">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
	
</body>
</html>