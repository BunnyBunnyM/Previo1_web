<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			  <a class="navbar-brand" href="<%=request.getContextPath()%>/PacienteList">
			    <img src="https://cdn-icons-png.flaticon.com/512/1430/1430402.png" width="30" height="30" class="d-inline-block align-top" alt="">
			    Pacientes</a>
	</nav>
<br>
		<div class="row">
	                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
	
	                <div class="container">
	                    <h3 class="text-center">Listado de Pacientes</h3>
	                    <hr>
	                    <div class="container text-left">
							
	                        <a href="<%=request.getContextPath()%>/NuevoPaciente" class="btn btn-success" style="background-color:#343a40; border:none">Inscribir Paciente</a>
	                    </div>
	                    <br>
	                    <table class="table table-bordered">
	                        <thead>
	                            <tr>
	                                <th>Id</th>
	                                <th>Documento</th>
	                                <th>Nombre</th>
	                                <th>Apellido</th>
	                                <th>Email</th>
	                                <th>Genero</th>
	                                <th>Fecha de nacimiento</th>
	                                <th>Telefono</th>
	                                <th>Direccion</th>
	                                <th>Peso</th>
	                                <th>Estatura</th>
	                                <th>Acciones</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <!--   for (Todo todo: todos) {  -->
	                            <c:forEach var="p" items="${listPaciente}">
	
	                                <tr>
	                                    <td>
	                                        <c:out value="${p.id}" />
	                                    </td>
	                                     <td>
	                                       <c:out value="${p.documento}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.nombre}" />
	                                    </td>
	                                    <td>
	                                        <c:out value="${p.apellido}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.email}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.genero}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.fechanacimiento}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.telefono}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.direccion}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.peso}" />
	                                    </td>
	                                    <td>
	                                       <c:out value="${p.estatura}" />
	                                    </td>
	                                    <td><a href="edit?id=<c:out value='${p.id}' />" style="color:#343a40; text-decoration:underline">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${p.id}' />" style="color:#343a40; text-decoration:underline">Eliminar</a></td>
	                                </tr>
	                            </c:forEach>
		                	</tbody>
		    	        </table>
		        	</div>
		    </div>
</body>
</html>