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
<input type="text" placeholder="Alien Name" name="aname" /> <br>
<input type="text" placeholder="aid" name="aid"><br>
<input type="text" placeholder="tech" name="tech"><br>

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
<h2>
Delete
</h2>

<form action="DeleteAlien">
<input type="text" name="aid"><br>

<br>
<input type="submit">

</form>
<br>
<br>
<h2>
Update
</h2>
<form action="updateAlien">
<input type="text" placeholder="Alien Name" name="aname" /> <br>
<input type="text" placeholder="aid" name="aid"><br>
<input type="text" placeholder="tech" name="tech"><br>

<br>
<input type="submit">
</form>
<br>
<br>

<h2>
find by Tech

</h2>
<form action="getTech">
<input type="text" name="tech">
<input type="submit">
</form>
</body>
</html>