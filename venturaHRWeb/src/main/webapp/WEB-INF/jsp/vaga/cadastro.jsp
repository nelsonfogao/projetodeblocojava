<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>App - Java</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<header class="masthead">
		<div class="container px-4 px-lg-5 h-100">
			<c:import url="/WEB-INF/jsp/menu.jsp" />
		</div>
	</header>

	<div class="container">

		<form action="/vaga/incluir" method="post">
			<h2>Cadastramento de Vagas</h2>

			<div class="form-group">
				<label>Cargo:</label> <input type="text" class="form-control"
					name="cargo" >
			</div>

			<div class="form-group">
				<label>Cidade:</label> <input type="text" class="form-control"
					name="cidade">
			</div>

			<div class="form-group">
				<label>Forma de Contratação:</label> <input type="text" class="form-control"
					name="formaContratacao">
			</div>
			
			<div class="form-group">
				<label>Critérios:</label>

				<div class="form-group">
					<label>Descrição:</label> <input type="text" class="form-control"
						name="criterioList[0].descricao">
				</div>
				<div class="form-group">
					<label>Perfil:</label> <input type="text" class="form-control"
						name="criterioList[0].perfil">
				</div>
				<div class="form-group">
					<label>Peso:</label> <input type="text" class="form-control"
						name="criterioList[0].peso">
				</div>
			</div>
			

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>