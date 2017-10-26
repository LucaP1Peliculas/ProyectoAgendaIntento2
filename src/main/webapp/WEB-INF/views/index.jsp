<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">

<head>
    <title>Inicio</title>
   	
   <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
  	
   	   

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
                    <a href="inicio">Añadir</a>
                </li>
                <li>
                    <a href="#">Ejemplo</a>
                </li>
                <li id="options">
                	<!-- <spring:url value="/resources/images" var="images" />
   					<a href="#">Categoría<img src="${images}/triangle.png"/></a>  -->
                
                    <a href="#">Categoría</a> 
                    <!-- (../images/triangle.png); -->
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
                </li>
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
           
           <section>
           </section>
           
           <!-- Cada section pertenece a un contacto. Se generará uno por cada contacto cargado. 
                Tras pulsar en el section correspondiente o (h3) se realizará la llamada para 
                completar el div de la derecha con la información correspondiente rellena. -->
             
             <c:forEach var="persona" items="${personList}" varStatus="status">
	            
	             	<section>
	             	
	             		<spring:url value="/resources/images" var="images" />
	   					<a><img src="${images}/person.png"/></a>
	             		<!-- <a><img src="/images/person.png"/></a> -->
	             		 <a href="detalles?id=${persona.idpersonas}"><h3>${persona.nombre}</h3></a>
	             		
	             	</section>
	             
             	
			</c:forEach>
             
 
            
            
            
        </article>
        <aside>
      	 	<spring:url value="/resources/images" var="images" />
   			<a><img src="${images}/person.png"/></a>
            <!-- <a><img src="/images/person.png"/></a> -->
            <div id="information">
                <form id="formContacto" action="guardar" method="post">  
                    <input type="text" name="nombre" id="titElement" placeholder="Nombre" value= "${nombre}"/>
                    <input type="text" name="apellido1" id="titElement" placeholder="Apellido1" value= "${apellido1}"/>
                    <input type="text" name="apellido2" id="titElement" placeholder="Apellido2" value= "${apellido2}"/>                   
                    <input type="date" name="fechaNacimiento" id="elements"/ value="${fecha}">
                    <input type="text" name="dni" id="elements" placeholder="DNI" value="${dni}"/>
                    <input type="text" name="fechaNacimiento" id="elements" placeholder="Provincia" value="${provincia}"/>
                    <input type="text" name="localidad" id="elements" placeholder="Localidad" value="${localidad}"/>
                    <input type="text" name="direccion" id="elements" placeholder="Dirección" value= "${direccion}"/>
                    <input type="text" name="codpostal" id="elements" placeholder="Código postal" value="${cp}"/>
                    <input type="text" name="telefono1" id="elements" placeholder="Teléfono" value="${telefono1.telefono}"/>
                    <input type="text" name="telefono2" id="elements" placeholder="Móvil" value="${telefono2.telefono}"/>
                    <input type="submit" name="send_button" id="send_button" value="Guardar"/>
                </form>
            </div>
        </aside>
    </div>

</body>

</html>
