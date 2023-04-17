<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo paciente</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			  <a class="navbar-brand" href="<%=request.getContextPath()%>/PacienteList">
			    <img src="https://cdn-icons-png.flaticon.com/512/1430/1430402.png" width="30" height="30" class="d-inline-block align-top" alt="">
			    Pacientes</a>
	</nav>
	<br>
		<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${p != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${p == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${p != null}">
                                    Editar Paciente
                                </c:if>
                                <c:if test="${p == null}">
                                    Agregar Nuevo Paciente
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${p != null}">
                            <input type="hidden" name="id" value="<c:out value='${p.id}' />" />
                        </c:if>
						
						 <fieldset class="form-group">
                            <label>Documento del paciente</label> <input type="text" value="<c:out value='${p.documento}' />" class="form-control" name="documento" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Nombre del paciente</label> <input type="text" value="<c:out value='${p.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Apellido del paciente</label> <input type="text" value="<c:out value='${p.apellido}' />" class="form-control" name="apellido">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>email</label> <input type="text" value="<c:out value='${p.email}' />" class="form-control" name="email">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>genero</label> <input type="text" value="<c:out value='${p.genero}' />" class="form-control" name="genero">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Fecha de nacimiento del paciente</label> <input type="date" value="<c:out value='${p.fechanacimiento}' />" class="form-control" name="fechanacimiento">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>telefono</label> <input type="text" value="<c:out value='${p.telefono}' />" class="form-control" name="telefono">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>direccion</label> <input type="text" value="<c:out value='${p.direccion}' />" class="form-control" name="direccion">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>peso</label> <input type="number" value="<c:out value='${p.peso}' />" class="form-control" name="peso">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>estatura</label> <input type="number" value="<c:out value='${p.estatura}' />" class="form-control" name="estatura">
                        </fieldset>
                        

                        <button type="submit" class="btn btn-success" style="background-color:#343a40; border:none">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>