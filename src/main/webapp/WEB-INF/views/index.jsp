<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                    <a href="#"><img src="images/logo1.png" /></a>
                </li>
                <li>
                    <a href="#">Añadir</a>
                </li>
                <li>
                    <a href="#">Ejemplo</a>
                </li>
                <li id="options">
                    <a href="#">Categoría</a>
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
           
           
           
           <!-- Cada section pertenece a un contacto. Se generará uno por cada contacto cargado. 
                Tras pulsar en el section correspondiente o (h3) se realizará la llamada para 
                completar el div de la derecha con la información correspondiente rellena. -->
             
             <c:forEach var="persona" items="${personList}" varStatus="status">
             	<section>
             		<a><img src="images/person.png"/></a>
             		<h3>${persona.nombre}</h3>
             	</section>
			</c:forEach>
             
            
            
            
        </article>
        <aside>
            <a><img src="images/person.png"/></a>
            <div id="information">
                <form id="formContacto" action="" method="get">
                    <input type="text" name="nombre" id="titElement" placeholder="Nombre, Apellido1 Apellido2"/>
                    <input type="date" name="fechaNacimiento" id="elements"/>
                    <input type="text" name="dni" id="elements" placeholder="DNI"/>
                    <input type="text" name="fechaNacimiento" id="elements" placeholder="Provincia"/>
                    <input type="text" name="localidad" id="elements" placeholder="Localidad"/>
                    <input type="text" name="direccion" id="elements" placeholder="Dirección"/>
                    <input type="text" name="codpostal" id="elements" placeholder="Código postal"/>
                    <input type="text" name="telefono" id="elements" placeholder="Teléfono"/>
                    <input type="text" name="movil" id="elements" placeholder="Móvil"/>
                    <input type="button" name="send_button" id="send_button" value="Guardar"/>
                </form>
            </div>
        </aside>
    </div>

</body>

</html>
