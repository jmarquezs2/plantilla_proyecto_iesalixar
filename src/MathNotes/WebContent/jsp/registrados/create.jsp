<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="utf-8">
<title>Math Notes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
	<link rel="icon" type="image/png" href="/MathNotes/img/icon/logonav.png" />
<link rel="stylesheet" type="text/css" href="/MathNotes/css/styles.css">

</head>
<body class="container-fluid">
	<div class="row ">
		<header class="col-12">
			<div class="row">
				<h1 class="col-md-3 col-sm-7  col-6">Math Notes</h1>
				<button id="botonUp" onclick="location='/MathNotes/Logout'"
					class="col-md-2 offset-md-6 col-sm-4 col-4  bg-white  my-auto">Salir</button>
			</div>

		</header>
		<section class="col-12 " id="fondoNotes">
	<c:set var="owner" value="${userOwner}" />
			<section id="pageNotes" class="mb-5 d-none d-md-block">

				<h3 id="h3notes" class="mx-5 mb-5">Nuevo Apunte</h3>
				<div class="row mt-5">

					<c:choose>
							<c:when test="${owner.getRol() eq 'user'}">
									<nav class="col-4">
						<div class="row py-4" onclick="location='/MathNotes/Notes'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/misApuntesIcon.png"
								class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Apuntes Guardados</b>
							</div>
						</div>
						<hr>
						<div class="row py-4" onclick="location='/MathNotes/AllNotes'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/todos.png" class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Apuntes Públicos</b>
							</div>
						</div>
						<hr>
						<div class="row py-4" onclick="location='/MathNotes/Create'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/crear.png" class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Nuevo Apunte</b>
							</div>
						</div>
						<hr>
						<div class="row py-4" onclick="location='/MathNotes/NewPassword'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/contraseña.png"
								class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Cambiar Contraseña</b>
							</div>
						</div>
						<hr>


					</nav>
							</c:when>

							<c:otherwise>
	<nav class="col-4">
						<div class="row py-4" onclick="location='/MathNotes/Usuarios'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/user.png"
								class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Usuarios</b>
							</div>
						</div>
						<hr>
						<div class="row py-4" onclick="location='/MathNotes/AllNotes'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/todos.png" class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Apuntes Públicos</b>
							</div>
						</div>
						<hr>
						<div class="row py-4" onclick="location='/MathNotes/Create'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/crear.png" class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Nuevo Apunte</b>
							</div>
						</div>
						<hr>
						<div class="row py-4" onclick="location='/MathNotes/Moderacion'"
							id="botonNav">
							<img id="icon" src="/MathNotes/img/icon/guarda.svg"
								class="ml-4"></img>
							<div class="ml-4 mt-2">
								<b>Moderación</b>
							</div>
						</div>
						<hr>


					</nav>
						
							</c:otherwise>
						</c:choose>
					<section class="col-7">
						<form action="/MathNotes/Create" id="formCreate" method="post"
							enctype="multipart/form-data">

							<div id="groupPublic">

								<label class="mr-5">¿Hacer público?</label>
								<input type="radio" id="yes" name="visibility" value="y">
								<label for="">Si</label>
								<input type="radio" id="no" name="visibility" value="n">
								<label for="">No</label> <label id="info">Con esto los
									demas podran ver y guardar tu apunte.</label>
							</div>

							<hr class="mb-5">

							<!--<div class="form-group">
   
                     </div>-->
							<div class="form-group mb-5">
								<div class="row">


									<label class="col-5" for="title">Título</label> <input
										class="col-7" type="text" id="inputWrite" name="title"
										placeholder="Velocidad de escape, ley de Newton...">
								</div>
							</div>
							<div class="form-group mb-5">
								<div class="row">
									<label class=" col-5" for="subject">Asignatura</label> <select
										class="col-7" id="inputWrite" name="subject">
										<option value="Matemáticas">Matemáticas</option>
										<option value="Física" selected>Física</option>
										<option value="Química">Química</option>
										<option value="Tecnología">Tecnología</option>
										<option value="Economía">Economía</option>
										<option value="Otra">Otra</option>
									</select>
								</div>
							</div>
							<div class="form-group mb-5">
								<div class="row">


									<label class="col-5" for="temary">Tema</label> <input
										class="col-7" type="text" id="inputWrite" name="temary"
										placeholder="Trigonometría, Fuerzas...">
								</div>
							</div>

							<div class="form-group mb-5">
								<div class="row">


									<label class="col-5" for="description">Descripción</label>
									<textarea class="col-7" name="description" rows="5" " cols="50"></textarea>
								</div>
							</div>

							<div class="form-group mb-5">
								<div class="row">


									<label class="col-5" for="content">Contenido</label>
									<textarea class="col-7" name="content" rows="5" " cols="50">Escribe aquí tu formula...</textarea>
								</div>
							</div>

							<div class="form-group mb-5">
								<div class="row">


									<label class="col-5" for="temary">Enlace De Interes</label> <input
										class="col-7" type="url" id="inputWrite" name="link"
										placeholder="">
								</div>
							</div>
							<hr>
							<div class="form-group  mt-3 mb-5">
								<div class="row">


									<label class="col-12" for="description">Sube una
										imagen:</label> <input id="fileInput" type="file" class="col-12"
										accept="image/png, .jpeg, .jpg, image/gif"
										name="archivossubidos" multiple>
								</div>
							</div>




							<br> <br>

							<button id="submitCreate" class="btn mb-4" type="submit">Crear</button>

						</form>
					</section>

				</div>




			</section>
			<section class="d-block d-md-none">

				<div class="row">
					<h3 id="h3notes" class="mx-5 mb-0">
						Nuevo Apunte
						<button type="button" class="  btn btn-outline-dark   "
							data-toggle="collapse" href="#multiCollapseExample1"
							role="button" aria-expanded="false"
							aria-controls="multiCollapseExample1">
							<img src="img/icon/menu.png" id="menuimg" alt="">
						</button>
					</h3>

					<div class="collapse multi-collapse" id="multiCollapseExample1">
						<div class="card card-body">
							<div class="row">
								<button type="button"
									class="col-5 btn btn-outline-dark ml-4  mb-3 mr-2"  onclick="location='/MathNotes/Notes'">Apuntes
									Guardados</button>
								<button type="button"
									class="col-5 btn btn-outline-dark ml-2 mb-3 "  onclick="location='/MathNotes/AllNotes'">Apuntes
									Públicos</button>
								<button type="button"
									class="col-5 btn btn-outline-dark ml-4 mr-2"  onclick="location='/MathNotes/Create'">Nuevo
									Apunte</button>
								<button type="button" class="col-5 btn btn-outline-dark ml-2"  onclick="location='/MathNotes/NewPassword'">Cambiar
									Contraseña</button>
									

							</div>
							
							
						</div>
					</div>


				</div>
				<hr>
				<form action="/MathNotes/Create" id="formCreate" method="post"
					enctype="multipart/form-data">

					<div id="groupPublic">

						<label class="mr-5">¿Hacer público?</label>
								<input type="radio" id="yes" name="visibility" value="y">
								<label for="">Si</label>
								<input type="radio" id="no" name="visibility" value="n">
								<label for="">No</label> <label id="info">Con esto los
									demas podran ver y guardar tu apunte.</label>
					</div>

					<hr class="mb-5">

					<!--<div class="form-group">
                       
                                         </div>-->
					<div class="form-group mb-5">
						<div class="row">


							<label class="col-5" for="title">Título</label> <input
								class="col-7" type="text" id="inputWrite" name="title"
								placeholder="Velocidad de escape, ley de Newton...">
						</div>
					</div>
					<div class="form-group mb-5">
						<div class="row">
							<label class=" col-5" for="subject">Asignatura</label> <select
										class="col-7" id="inputWrite" name="subject">
										<option value="Matemáticas">Matemáticas</option>
										<option value="Física" selected>Física</option>
										<option value="Química">Química</option>
										<option value="Tecnología">Tecnología</option>
										<option value="Economía">Economía</option>
										<option value="Otra">Otra</option>
									</select>
						</div>
					</div>
					<div class="form-group mb-5">
						<div class="row">


							<label class="col-5" for="temary">Tema</label> <input
								class="col-7" type="text" id="inputWrite" name="temary"
								placeholder="Trigonometría, Fuerzas...">
						</div>
					</div>

					<div class="form-group mb-5">
						<div class="row">


							<label class="col-5" for="description">Descripción</label>
							<textarea class="col-7" name="textarea" rows="5" " cols="50"></textarea>
						</div>
					</div>

					<div class="form-group mb-5">
						<div class="row">


							<label class="col-5" for="content">Contenido</label>
							<textarea class="col-7" name="content" rows="5" " cols="50">Escribe aquí tu formula...</textarea>
						</div>
					</div>

					<div class="form-group mb-5">
						<div class="row">


							<label class="col-5" for="temary">Enlace De Interes</label> <input
								class="col-7" type="url" id="inputWrite" name="link"
								placeholder="">
						</div>
					</div>
					<hr>
					<div class="form-group  mt-3 mb-5">
						<div class="row">


							<label class="col-12" for="description">Sube una imagen:</label>
							<input id="fileInput" type="file" class="col-12"
								accept="image/png, .jpeg, .jpg, image/gif"
								name="archivossubidos" multiple>
						</div>
					</div>




					<br> <br>

					<button id="submitCreate" class="btn mb-4" type="submit">Crear</button>

				</form>
			</section>
	</div>




	</section>


	</section>
	</div>



	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>