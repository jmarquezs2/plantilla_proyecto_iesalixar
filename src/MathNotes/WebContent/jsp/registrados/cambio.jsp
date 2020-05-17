<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta charset="utf-8">
    <title>Math Notes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" href="/MathNotes/css/styles.css">

</head>
<body class="container-fluid">
	<div class="row">
        <header class="col-12">
            <div class="row">
                <h1 class="col-md-3 col-sm-7  col-6">Math Notes</h1>
                <button id="botonUp" class="col-md-2 offset-md-6 col-sm-4 col-4  bg-white  my-auto" onclick="location='/MathNotes/Notes'">Volver</button>
            </div>

        </header>
        <section class="col-12 d-md-block d-none">
            <div class="row">
                <section class="col-7 pr-5 " id="profesor">
                    <div class="row">
                    <h3 class="col-12 mx-5 mt-5" id="h3index1">
                        Procura escribir una buena esta vez
                    </h3>
                    <p class="col-12 mx-5 my-3" id="parrafoIndex">

                        
                        Nosotros guardamos tus formulas, tú limítate a usarlas.
                    </p>
                    <img id="imagenLG" src="img/pngocean.com.png"  class="d-none d-lg-block" alt="profesor">
                    <img id="imagenMD" src="img/pngocean.com.png"  class="d-none d-md-block d-lg-none" alt="profesor" >
                </div>
                </section>

                <section class="col-5 mt-5">
                    <div class="row"></div>
                    <h3 class="col-12 mt-5 ml-md-5 ml-lg-0" id="h3index2">Cambio de contraseña</h3>
                    <form action="/MathNotes/NewPassword" method="post" class="col-12">
                      
                            <input  type="email" name="email" class="form-control my-5 " id="email" placeholder="Email">
                            <input type="password" name="newPassword"  class="form-control my-5 " id="newPassword" placeholder="Nueva Contraseña">
                            <input type="password" name="newPassword2" class="form-control my-5 " id="newPassword2" placeholder="Confirmar Contraseña">
                        
                        
                            <button type="submit" id="botonDown" class="col-6 bg-white  my-auto">Cambiar contraseña</button>


                    </form>
                </section>

            </div>


        </section>

       <section id="movilFondo" class="col-12 d-md-none d-block">
           <div class="row">
        <h3 class="col-12 my-5" id="h3index1">
            Procura escribir una buena esta vez
        </h3>
        <p class="col-12 " id="parrafoIndex">

            Nosotros guardamos tus formulas, tú limítate a usarlas.
        </p>
        <h3 class="col-12 mt-5" id="h3index2">Empieza por aqui!</h3>
                    <form action="/MathNotes/NewPassword" method="post" class="col-12">
                      <div class="row">
                            <input type="email" name="email" class="form-control my-3 col-12 " id="email" placeholder="Email">
                            <input type="password" name="newPassword" class="form-control my-3 " id="newPassword" placeholder="Nueva Contraseña">
                            <input type="password" name="newPassword2" class="form-control my-3 col-12" id="newPassword2" placeholder="Confirmar Contraseña">
                        
                        
                            <button type="submit" id="botonDown" class="col-12 bg-white  my-auto">Cambiar contraseña</button>
                        </div>

                    </form>
    </div>
       </section>


    </div>


    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>