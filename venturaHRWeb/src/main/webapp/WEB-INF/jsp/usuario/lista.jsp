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

		<h4>Cadastramento de usu?rios:</h4>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirma??o!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty usuarioLista}">
			<p>Quantidade de usu?rios cadastrados: ${usuarioLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Cpf</th>
						<th>Endereco</th>
						<th>Telefone</th>
						<th>Tipo</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${usuarioLista}">
						<tr>
							<td>${u.nome}</td>
							<td>${u.email}</td>
							<td>${u.cpf}</td>
							<td>${u.endereco}</td>
							<td>${u.telefone}</td>
							<td>${u.tipo}</td>
							<td><a href="/usuario/${u.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty usuarioLista}">
			<p>N?o existem usu?rios cadastrados!!!</p>
		</c:if>
	</div>
</body>
</html>