<?php 

include 'connect.php';
if (! $conn){
	die('could not connect' . mysql_error());
}

$email = $_POST['email'];
$pass = $_POST['password'];
$db = mysql_select_db("mydb");

$query = mysql_query("SELECT Password, Email FROM Student WHERE Email='$email' AND Password='$pass';");
$rows = mysql_num_rows($query);

if($rows >= 1){

echo "1";
}else{
echo "0";
$query = mysql_query("INSERT INTO Student(Email, Password) VALUES ('$email', '$pass');");
$rows = mysql_num_rows($query);
}


?>
