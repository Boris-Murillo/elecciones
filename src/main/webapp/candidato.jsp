<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Candidatos</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	 <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: pink">
                    <div>
                        <a href="#" class="navbar-brand"> Gestion Candidatos </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Candidatos</a></li>
                    </ul>
                </nav>
     </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${candidato != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${candidato == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${candidato != null}">
                                    Editar Candidato
                                </c:if>
                                <c:if test="${usuario == null}">
                                    Agregar Nuevo Candidato
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${candidato != null}">
                            <input type="hidden" name="id" value="<c:out value='${candidato.id}' />" />
                        </c:if>

						<fieldset class="form-group">
                            <label>Documento </label> <input type="text" value="<c:out value='${candidato.documento}' />" class="form-control" name="documento" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Nombre </label> <input type="text" value="<c:out value='${candidato.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Apellido </label> <input type="text" value="<c:out value='${candidato.apellido}' />" class="form-control" name="apellido"  >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Eleccion </label> <input type="number" value="<c:out value='${candidato.eleccion}' />" class="form-control" name="eleccion" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Numero</label> <input type="number" value="<c:out value='${candidato.numero}' />" class="form-control" name="numero" required="required">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>