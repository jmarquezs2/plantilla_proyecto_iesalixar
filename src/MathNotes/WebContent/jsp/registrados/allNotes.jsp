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
<script type="text/javascript" src="/MathNotes/js/script.js"></script>
</head>
<body class="container-fluid">
	<div class="row">
		<header class="col-12">
			<div class="row">
				<h1 class="col-md-3 col-sm-7  col-6">Math Notes</h1>
				<button id="botonUp" onclick="location='/MathNotes/Logout'"
					class="col-md-2 offset-md-6 col-sm-4 col-4  bg-white  my-auto">Salir</button>
			</div>

		</header>
		<section class="col-12" id="fondoNotes">

			<section id="pageNotes" class=" d-none d-md-block">

				<h3 id="h3notes" class="mx-5 mb-5">Apuntes Públicos</h3>
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
					<section class="col-7">
						<div class="row mt-5" id="textSearch">
							<p class="col-4">¿Demasiados Apuntes? Buscalos</p>

							<!-- Search form -->
							<form action="" class="col-6 mt-2">
								<div class="row">
									<input class=" col-10 form-control" type="text"
										placeholder="    Título, Tema, Asigntura..."
										aria-label="Search"> <img class="ml-1"
										src="/MathNotes/img/icon/u64.svg" alt="">
								</div>
							</form>


						</div>
						<hr class="mb-3">

						<c:forEach var="subject" items="${allSubjects}">
							<c:forEach var="note" items="${allNotes}">

								<c:set var="note" value="${note}" />
								<c:set var="subject" value="${subject}" />
								<c:set var="userOwner" value="${userOwner}" />
								<c:if test="${note.getSubject() eq subject}">


									<div id="asignatura" class="mt-5">
										<p class="my-auto">
											<c:out value="${subject}" />
										</p>


									</div>
									<div class="row ml-5">
										<c:set var="userList" value="${userList}" />



										<div
											class="col-md-5 col-lg-3  col-sm-10 col-12 mx-md-3 mt-5 mr-5 mr-sm-0 mx-0"
											id="note"
											onclick="location='/MathNotes/View?id=<c:out value="${note.getId()}" />'">

											<div id="tituloNote">
												<label><c:out value="${note.getTitle()}" /></label>

											</div>


											<c:choose>
												<c:when test="${userOwner eq note.getOwner()}">
													
												</c:when>

												<c:otherwise>

													<a
														href="/MathNotes/AllNotes?id=<c:out value="${note.getId()}" />">
														<img src="/MathNotes/img/icon/guardar2.png"
														onmouseover="change2(this)" onmouseout="change(this)"
														title="Guardar" alt="Guardar">
													</a>
												</c:otherwise>
											</c:choose>
										</div>



									</div>

								</c:if>
							</c:forEach>
						</c:forEach>


					</section>

				</div>




			</section>
			<section class="d-block d-md-none">

				<div class="row">
					<h3 id="h3notes" class="mx-5 mb-0">
						Apuntes Guardados
						<button type="button" class="  btn btn-outline-dark   "
							data-toggle="collapse" href="#multiCollapseExample1"
							role="button" aria-expanded="false"
							aria-controls="multiCollapseExample1">
							<img src="/MathNotes/img/icon/menu.png" id="menuimg" alt="">
						</button>
					</h3>

					<div class="collapse multi-collapse" id="multiCollapseExample1">
						<div class="card card-body">
							<div class="row">
								<button type="button" onclick="location='/MathNotes/Notes'"
									class="col-5 btn btn-outline-dark ml-4  mb-3 mr-2">Apuntes
									Guardados</button>
								<button type="button" onclick="location='/MathNotes/AllNotes'"
									class="col-5 btn btn-outline-dark ml-2 mb-3 ">Apuntes
									Públicos</button>
								<button type="button" onclick="location='/MathNotes/Create'"
									class="col-5 btn btn-outline-dark ml-4 mr-2">Nuevo
									Apunte</button>
								<button type="button"
									onclick="location='/MathNotes/NewPassword'"
									class="col-5 btn btn-outline-dark ml-2">Cambiar
									Contraseña</button>

							</div>
						</div>
					</div>

					<form id="formMovil" action="" class="col-12 mt-4 ml-0">
						<div class="row">
							<input class=" col-10 form-control" type="text"
								placeholder="    Título, Tema, Asigntura..." aria-label="Search">
							<img class="ml-1" src="/MathNotes/img/icon/u64.svg" alt="">
						</div>
					</form>
				</div>
				<hr>

				<c:forEach var="subject" items="${allSubjects}">
				<div id="asignaturaMovil" class="mt-5">
									<p class="my-auto">
										<c:out value="${subject}" />
									</p>


								</div>
					<div class="row ml-5">

						<c:forEach var="note" items="${allNotes}">

							<c:set var="note" value="${note}" />
							<c:set var="subject" value="${subject}" />

							<c:if test="${note.getSubject() eq subject}">
								


								<div class="col-4 mx-md-3 mt-5 mr-5 " id="note"
									onclick="saveId(${note.getId()}); location='/MathNotes/View'">
									<div id="tituloNote">
										<label><c:out value="${note.getTitle()}" /></label>

									</div>
									<img src="/MathNotes/img/icon/engranaje.png" alt="">
								</div>
							</c:if>
						</c:forEach>
					</div>


				</c:forEach>


			</section>
	</div>




	</section>


	</section>
	</div>

<script
src="https://cdn.cai.tools.sap/webchat/webchat.js"
channelId="8c657416-a85d-4dd3-8a93-d16edfb60274"
token="911d74323f0e85f55bed13443ce7b677"
id="cai-webchat">
</script>
	<script type="text/javascript">
function saveId(id) {
	var noteId;
	sessionStorage.setItem(noteId,id);
	console.log(sessionStorage.getItem(noteId))
	}
</script>
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