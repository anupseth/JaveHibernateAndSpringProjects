<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>HEllo welcome to spring MVC</h1>
	<br>
	<form action="sayName" method="post">
		Enter Name : <input type="text" name="fname"> <br>
		<input type="submit" value="Click Me">
	</form>
	
	<br>
	
	<h2>Try Logging in</h2>
	
	<form action="login" method="post">
		User name: <input type="text" name="username" value="tom">
		Password:  <input type="password" name="password" value="jerry">
		<input type="submit" value="login">
	</form>
	
	<span style="color: red;"> ${errorMessage} </span>
	<a href="register"> Click here to register </a>
</body>
</html>