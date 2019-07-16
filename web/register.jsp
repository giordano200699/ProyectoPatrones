<%-- 
    Document   : register
    Created on : 16-jul-2019, 2:35:51
    Author     : Giordano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	  <title>Registro</title>
	  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	  <link rel="stylesheet"  href="public/css/c.css">

</head>
<body id="body">
	<div  id="fondo" class="global-container">
  <div  class="card login-form-fluid" >
  <div id="caja" class="card-body w3-amber" >
    
  	<div class="w3-container w3-indigo  w3-round-large" >
    	<h3 class="card-title text-center " >Regístrate y se parte de este evento.!</h3>
    </div>
    <div class="card-text">
      <form action="RegisterController" method="POST">

    <div class="form-group "> 
        <label for="full_name_id" class="control-label " style="text-shadow:1px 1px 0 #444">Nombres</label>
        <input type="text" class="form-control w3-container w3-light-grey" id="name_id" name="nombre" placeholder="Name">
    </div>    

    <div class="form-group">
        <label for="street1_id" class="control-label" style="text-shadow:1px 1px 0 #444">Apellidos</label>
        <input type="text" class="form-control w3-container w3-light-grey" id="last_name" name="apellidos" placeholder="Last name">
    </div>         

    <div class="form-group">
        <label for="street1_id" class="control-label" style="text-shadow:1px 1px 0 #444">Edad</label>
        <input type="text" class="form-control w3-container w3-light-grey" id="age" name="edad" placeholder="Age">
    </div>           
                            
    <div class="form-group"> 
        <label for="street2_id" class="control-label" style="text-shadow:1px 1px 0 #444">Dirección</label>
        <input type="text" class="form-control w3-container w3-light-grey" id="address_id" name="direccion"  placeholder="Address">
    </div>    

    <div class="form-group"> 
        <label for="correo" class="control-label" style="text-shadow:1px 1px 0 #444">Correo</label>
        <input type="text" class="form-control w3-container w3-light-grey" id="correo" name="correo" placeholder="Correo">
    </div>  
          
    <div class="form-group"> 
        <label for="contrasenia" class="control-label" style="text-shadow:1px 1px 0 #444">Contraseña</label>
        <input type="password" class="form-control w3-container w3-light-grey" id="contrasenia" name="contrasenia"  placeholder="Contraseña">
    </div>  
    
    <div align="center" class="form-group"> 
        <button type="submit" class="btn  w3-deep-purple">Registrar.!</button>
        <a class="btn btn-info" href="index.jsp">Volver</a>
    </div>  
        
    
</form>
    </div>
  </div>
</div>
</div>

<style type="text/css">
	#caja {
 		background-image: url("public/css/Milco-1.png"),url("public/css/logo4.png");
 		background-position:  0% 0%,0%    100%;
 		background-repeat: no-repeat;


	}
	#fondo {
 		background-image: url("public/css/fondoreg.png");
 		
 		/*                  iz-dr  arr-ab   */
		background-position: 0%    0%;
		background-repeat:no-repeat;/*que no se repita el fondo*/
		background-attachment: fixed;/*para que sea estático*/
		background-color: #483a8b;
		background-size: cover;
        -moz-background-size: cover;
        -webkit-background-size: cover;
        -o-background-size: cover;
	}
</style>
	
</body>
</html>