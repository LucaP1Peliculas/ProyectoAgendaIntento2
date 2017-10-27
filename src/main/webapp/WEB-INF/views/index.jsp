<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">

<head>
    <title>Inicio</title>
   	
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"></link>
    <script src="<c:url value="/js/js.js" />"></script>
    
</head>

<body>
    <header>
        <nav>
            <ul>
                <li id="settings">
                	<spring:url value="/resources/images" var="images" />
   					<a href="#"><img src="${images}/logo1.png"/></a>
                
                   <!-- <a href="#"><img src="/images/logo1.png" /></a>  -->
                </li>
                <li>
                    <a onClick="newC()">Nuevo contacto</a>
                </li>
                <li id="options">
                	<!-- <spring:url value="/resources/images" var="images" />
   					<a href="#">Categoría<img src="${images}/triangle.png"/></a>  -->
                
                    <a href="#">Categoría</a> 
                    <!-- (../images/triangle.png); -->
                    <ul class="subnav">
                        <li><a href="#">Programador</a></li>
                        <li><a href="#">Analísta</a></li>
                          <li><a href="#">Técnico Recursos Humanos</a></li>
                            <li><a href="#">Secretaria</a></li>
                              <li><a href="#">Recepcionista</a></li>
                                <li><a href="#">Master del Universo</a></li>
                                
                    </ul>
                </li>
                <li id="options">
                    <a href="#">Departamentos</a>
                    <ul class="subnav">
                        <li><a href="#">RRHH</a></li>
                        <li><a href="#">Informática</a></li>
                        <li><a href="#">Logística</a></li>
                         <li><a href="#">Dirección</a></li>
                          <li><a href="#">Ventas</a></li>
                    </ul>
                </li>
                <!--  
                
                <li id="options">
   					
                    <ul class="subnav">
                        <li><a href="#">Fijo</a></li>
                        <li><a href="#">Móvil</a></li>
                    </ul>
                </li>
                <li id="options">
                    <a href="#">Departamentos</a>
                    <ul class="subnav">
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                    </ul>
                </li> -->
                
                <li id="search">
                    <form action="" method="get">
                        <input type="text" name="search_text" id="search_text" placeholder="Búsqueda" />
                        <input type="button" name="search_button" id="search_button" />
                    </form>
                </li>
            </ul>
        </nav>
    </header>

    <div class="contenedor">
        <article class="scroll" id="scroll-style">
           
           <section></section>
           
           <!-- Cada section pertenece a un contacto. Se generará uno por cada contacto cargado. 
                Tras pulsar en el section correspondiente o (h3) se realizará la llamada para 
                completar el div de la derecha con la información correspondiente rellena. -->
             
            <c:forEach var="persona" items="${personList}" varStatus="status">
	            
	             	<section>
	             	
	             		<spring:url value="/resources/images" var="images" />
	   					<a><img src="${images}/person.png"/></a>
	             		<!-- <a><img src="/images/person.png"/></a> -->
	             		 <a href="detalles?id=${persona.idpersonas}"><h3>${persona.nombre}, ${persona.apellido1} ${persona.apellido2}</h3></a>
	             		
	             	</section>
	                   	
			</c:forEach>
       
       
       
       
        </article>
        <aside id="detalles">
      	 	<spring:url value="/resources/images" var="images" />
   			<a><img src="${images}/person.png"/></a>
            
            <div id="information">
                <form id="formContacto" action="" method="get">
                    <input type="text" readonly="readonly" name="nombre" id="titElement" placeholder="Nombre" value= "${nombre}"/>
                    <input type="text" readonly="readonly" name="apellido1" id="titElement" placeholder="Apellido 1" value= "${apellido1}"/>
                    <input type="text" readonly="readonly" name="apellido2" id="titElement" placeholder="Apellido 2" value= "${apellido2}"/>
                    <input type="date" readonly="readonly" name="fechaNacimiento" id="elements"/ value="${fecha}">
                    <input type="text" readonly="readonly" name="dni" id="elements" placeholder="DNI" value="${dni}"/>
                    <input type="text" readonly="readonly" name="provincia" id="elements" placeholder="Provincia" value="${provincia}"/>
                    <input type="text" readonly="readonly" name="localidad" id="elements" placeholder="Localidad" value="${localidad}"/>
                    <input type="text" readonly="readonly" name="direccion" id="elements" placeholder="Dirección" value= "${direccion}"/>
                    <input type="text" readonly="readonly" name="codpostal" id="elements" placeholder="Código postal" value="${cp}"/>
                    <input type="text" readonly="readonly" name="telefono1" id="elements" placeholder="Teléfono 1" value="${telefono1.telefono}"/>
                    <input type="text" readonly="readonly" name="telefono2" id="elements" placeholder="Teléfono 2" value="${telefono2.telefono}"/>
                    <select name="categoria" onchange="">
						<option value="1">Programador Senior</option> 
					    <option value="2">Programador Junior</option> 
					    <option value="3">Jefe de proyecto</option>
					    <option value="4">Manager de proyecto</option> 
					    <option value="5">Gerente</option> 
					    <option value="6">Director</option> 
					</select>
                    <input type="checkbox" readonly="readonly" name="empleado" id="empleado" placeholder= "Eres empleado?"/><p>Empleado</p> 
                    <input type="button" onClick="edit()" name="edit_button" id="edit_button" value="Editar"/>
					<input type="button" onClick="save()" name="save_button" id="save_button" value="Guardar"/>
					<input type="button" onClick="delete()" name="delete_button" id="delete_button" value="Eliminar"/>
                </form>
            </div>
        </aside>
    </div>

</body>

</html>