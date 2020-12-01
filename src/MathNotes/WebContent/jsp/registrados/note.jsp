<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@
page import="java.util.Iterator"%>
<%@
page import="org.jmarquezs.model.*"%>

<%@
page import="org.jmarquezs.DAO.*"%>
<%@
  page import="java.util.List"%>
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

			<section id="pageNotes" class="mb-5 d-none d-md-block">

				<h3 id="h3notes" class="mx-5 mb-5">
					<c:out value="${note.getTitle()}" />
				</h3>
				<div class="row mt-5">

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
						<div class="row py-4" onclick="location='/MathNotes/AllNotes'" id="botonNav">
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
					<section class="col-7">




						<label class="mr-5"> <c:choose>
								<c:when test="${note.getVisibility() eq 1}">
									Esta fórmula es pública.
								</c:when>
								<c:otherwise>
								Esta fórmula es privada.
								</c:otherwise>

						</c:choose>


						</label> <label>Este apunte ha sido guardado por <c:out value="${num}" /> usuarios.</label>


						<hr class="mb-5">

						<!--<div class="form-group">
   
                     </div>-->


						<div class="row  mb-5">
							<label class=" col-5"><u>Asignatura</u></label> <label
								class="col-7" id="textNote"><c:out
									value="${note.getSubject()}" /></label>
						</div>

						<div class="row  mb-5">
							<label class=" col-5"><u>Tema</u></label> <label class="col-7"
								id="textNote"><c:out value="${note.getTemary()}" /></label>
						</div>

						<div class="row  mb-5">
							<label class=" col-5"><u>Descripción</u></label> <label
								class="col-7" id="textNote"><c:out
									value="${note.getDescription()}" /></label>
						</div>
						<c:forEach var="content" items="${listContent}">
							<c:choose>
								<c:when test="${content.getType() eq 'formula'}">

									<hr class="mb-5">
									<div class="row  mb-5">
										<label class=" col-5"><u>Contenido</u></label> <label
											class="col-7" id="textNote">${content.getEssence()}</label>
									</div>


								</c:when>
								<c:when test="${content.getType() eq 'link'}">
									<hr class="mb-5">
									<div class="row  mb-5">
										<label class=" col-4"><u>Enlace de interes</u></label> <label
											class="col-5" id="textNote"><a href="${content.getEssence()}">${content.getEssence()}</a></label>
									</div>
								</c:when>
								<c:when test="${content.getType() eq 'img'}">
									<hr>
									<div class="form-group  mt-3 mb-5">
										<div class="row">
											<label class="col-12" for="description">Imagen:</label> <img
												width="400px" height="240px" class="ml-5 mt-3"
												src=/MathNotes/img/notesImage/${content.getEssence()} alt="imagenNota">
										</div>
									</div>
								</c:when>
							</c:choose>
						</c:forEach>
						<br> <br>

						<button id="submitCreate" onclick="location='/MathNotes/Edit?id=<c:out value="${note.getId()}" />'"
							class="btn mb-4" type="button">Editar</button>


					</section>

				</div>




			</section>
			<section class="d-block d-md-none">

				<div class="row">
					<h3 id="h3notes" class="mx-5 mb-0">
						<c:out value="${note.getTitle()}" />
						<button type="button" class="  btn btn-outline-dark   "
							data-toggle="collapse" href="#multiCollapseExample1"
							role="button" aria-expanded="false"
							aria-controls="multiCollapseExample1">
							<img src="img/icon/menu.png" id="menuimg" alt="">
						</button>
					</h3>

					<div class="collapse multi-collapse ml-5"
						id="multiCollapseExample1">
						<div class="card card-body">
							<div class="row">
								<button type="button"
									class="col-5 btn btn-outline-dark ml-4  mb-3 mr-2" onclick="location='/MathNotes/Notes'"> Apuntes
									Guardados</button>
								<button type="button"
									class="col-5 btn btn-outline-dark ml-2 mb-3 " onclick="location='/MathNotes/AllNotes'">Apuntes
									Públicos</button>
								<button type="button"
									class="col-5 btn btn-outline-dark ml-4 mr-2" onclick="location='/MathNotes/Create'">Nuevo
									Apunte</button>
								<button type="button" class="col-5 btn btn-outline-dark ml-2" onclick="location='/MathNotes/NewPassword'">Cambiar
									Contraseña</button>

							</div>
						</div>
					</div>


				</div>
				<hr>


				<div id="groupPublic">

					<label class="mr-5"> <c:choose>
								<c:when test="${note.getVisibility() eq 1}">
									Esta fórmula es pública.
								</c:when>
								<c:otherwise>
								Esta fórmula es privada.
								</c:otherwise>

						</c:choose>


						</label> <label>Este apunte ha sido guardado por <c:out value="${num}" /> usuarios.</label>


				</div>

				<hr class="mb-5">

				<!--<div class="form-group">
                       
                                         </div>-->



				<div class="row mb-5">
					<label class=" col-5" for="subject"><b><u>Asignatura</u></b></label>
					<label type="text" class="col-7" id="inputWrite"><c:out
									value="${note.getSubject()}" /></label>
				</div>

				<div class="row mb-5">
					<label class=" col-5" for="subject"><b><u>Tema</u></b></label> <label
						type="text" class="col-7" id="inputWrite"><c:out value="${note.getTemary()}" /></label>
				</div>

				<div class="row mb-5">
					<label class=" col-5" for="subject"><b><u>Descripción</u></b></label>
					<label type="text" class="col-7" id="inputWrite"><c:out
									value="${note.getDescription()}" /></label>
				</div>
				
				
				<c:forEach var="content" items="${listContent}">
							<c:choose>
								<c:when test="${content.getType() eq 'formula'}">
								<hr class="mb-5">
				<div class="row mb-5">
					<label class=" col-5" for="subject"><b><u>Contenido</u></b></label>
					<label type="text" class="col-7" id="inputWrite">${content.getEssence()}</label>
				</div>
				</c:when>
								<c:when test="${content.getType() eq 'link'}">
									<hr class="mb-5">
				<div class="row mb-5">
					<label class=" col-5" for="subject"><b><u>Enlace de
								interes</u></b></label> <label type="text" class="col-7" id="inputWrite"><a
						href="${content.getEssence()}">${content.getEssence()}</a></label>
				</div>
				</c:when>
								<c:when test="${content.getType() eq 'img'}">
									<hr>
				<div class="row mb-5">
					<label class=" col-5" for="subject"><b><u>Imagenes:</u></b></label>
					<img src=/MathNotes/img/notesImage/${content.getEssence()} alt="">
				</div>

</c:when>
							</c:choose>
						</c:forEach>


				<br> <br>

				<button id="submitCreate" class="btn mb-4" type="button">Editar</button>


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