<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prodotti</title>
</head>
<body>
<table>
		<tr>
			<th>Nome</th>
			<th>Quantita</th>
			<th>Categoria</th>
			<th></th>
		</tr>
		<c:forEach items="${lista}" var="prodotto">
		<tr>
			<td>${prodotto.nome}</td>
			<td>${prodotto.quantita}</td>
			<td>${prodotto.categoria}</td>
			<td>
				<a href="modifica?id=${prodotto.id}">Modifica</a>
				<a href="elimina?id=${prodotto.id}">Elimina</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<form action="home">
	<input type="submit" value="Torna Alla Home">
	</form>
</body>
</html>