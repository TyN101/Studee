<?php 

include 'connect.php';
if (! $conn){
	die('could not connect' . mysql_error());
}

$Fname = $_POST['name'];
$db = mysql_select_db("mydb");

$query = mysql_query("SELECT Phone, email FROM Student WHERE Fname='$Fname';");
$rows = mysql_num_rows($query);

echo $Fname;
echo ",";
while ($row = mysql_fetch_array($query, MYSQL_NUM)) {
        echo $row[0];
        echo ",";
	echo $row[1];
}



?>
