<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiunta Prodotto</title>
</head>
<body>
<form:form action="salva" method="post" modelAttribute="prodotto">
<label>Id</label>
<form:input path="id"/>
<label>Nome</label>
<form:input path="nome"/>
<label>Quantita</label>
<form:input path="quantita"/>
<label>Categoria</label>
<form:input path="categoria"/>
<input type="submit" value="Aggiungi">
</form:form>
</body>
</html>