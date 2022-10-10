<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h2>
Add
</h2>
<form action="addAlien">
<input type="text" name="aname" /> <br>
<input type="text" name="aid"><br>

<br>
<input type="submit">
</form>
<br>
<br>
<h2>
Find
</h2>
<form action="getAlien">
<input type="text" name="aid"><br>

<br>
<input type="submit">

</form>

<form action="DeleteAlien">
<input type="text" name="aid"><br>

<br>
<input type="submit">

</form>

</body>
</html>