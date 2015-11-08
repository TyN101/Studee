<?php 

include 'connect.php';
if (! $conn){
	die('could not connect' . mysql_error());
}

$db = mysql_select_db("mydb");

$query = mysql_query("SELECT Fname FROM Student LIMIT 1,6;");

while ($row = mysql_fetch_array($query, MYSQL_NUM)) {
	echo $row[0];
	echo ",";
}

?>
