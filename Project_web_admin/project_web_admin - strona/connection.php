<?php
$serverName="localhost";
$user='root';
$pass ='';
$db='project_web_admin';
$con = mysqli_connect($serverName, $user, $pass, $db);
if(mysqli_connect_errno()){
	echo"blad";
	exit();
}

echo"";
?>