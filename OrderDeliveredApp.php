<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
 header('Content-Type: application/json');
 session_start();

require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);



if (isset($_GET['id'])){



 
 
$id=$_GET["id"];
$id=test_input($id);

$User= $_SESSION["email"];
$IP= $_SERVER['REMOTE_ADDR'];
$User= test_input($User);
$IP= test_input($IP);



     $user = $db->deliveredOrder($id,$User,$IP);
             if ($user) {  
          $_SESSION["error"]=1;
        $response["error"] = false;
  
    } else  {
            $_SESSION["error"]=2;
        $response["error"] = true;
    
    }

 
 

    



} else {
     $_SESSION["error"]=2;
    $response['error'] = true;
  
}
     echo json_encode($response); 
       


function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>