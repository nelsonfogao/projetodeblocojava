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
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container fixed-top">

		<h4>Cadastramento de vagas:</h4>

		<form action="/vaga" method="get">
			<button type="submit">Nova Vaga</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty vagaLista}">
			<p>Quantidade de vagas cadastradas: ${vagaLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Cargo</th>
						<th>Cidade</th>
						<th>Forma de Contratação</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="v" items="${vagaLista}">
						<tr>
							<td>${v.id}</td>
							<td>${v.cargo}</td>
							<td>${v.cidade}</td>
							<td>${v.formaContratacao}</td>
							<td><a href="/vaga/${v.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty vagaLista}">
			<p>Não existem vagas cadastradas!!!</p>
		</c:if>
	</div>
</body>
</html>