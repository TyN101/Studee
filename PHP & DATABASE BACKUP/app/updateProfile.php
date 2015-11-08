<?php 

include 'connect.php';
if (! $conn){
	die('could not connect' . mysql_error());
}

$Fname = $_POST['firstname'];
$Lname = $_POST['lastname'];
$phone = $_POST['phonenum'];
$email = $_POST['emailaddr'];

$db = mysql_select_db("mydb");


$query = mysql_query("UPDATE Student SET Phone='$phone', Lname='$Lname', email='$email' WHERE Fname='$Fname';");




?>
