<?php
include("connection.php");
?>
<!DOCTYPE html>
<html lang="pl">

<head>
<meta name="viewport" content="width=devide-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Project_Web_Admin</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div id="form">
	<h1>Logowanie</h1>
	<table>
	<form name="form" action="send.php" method="POST">

		<td><label>Nazwa użytkownika: </label></td>
	    <td><input type="text" id="user" name="user"><br></td>
		<tr></tr>
		<td><label>Hasło:</label></td>
	    <td><input type="password" id="pass" name="pass"><br></td>
		</table>
		<input type="submit" id="log" value="Login" name="zaloguj">
     </form>
	 </div>
</body>
</html>