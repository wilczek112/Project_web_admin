<?php
include('connection.php');
if(isset($_POST['submit'])){
	$username = $_POST['user'];
	$passsword = $_POST['pass'];

	$sql = "select * from login where username = '$username' and password ='$password'";
	$result = mysqli_querry($conn, $sql);
	$row = mysqli_fetch_array($result, MYSQLI_ASSOC);
	$count = mysqli_num_rows($result);
	if($count==1){

		header("Location:lobby.php");
	}
	else{
		echo'<script>
		window.location.href = "index.php";
		alert("Logowanie niepowiodło się. Błedny login lub hasło");
		</script>';
	}
}
?>