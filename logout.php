<?php
 header('Content-Type: application/json');


require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);


error_reporting(-1);
ini_set('display_errors', 'On');


if ( isset($_POST['mobile'])){

    $mobile=$_POST['mobile'];
   
  
    $mobile=test_input($mobile);
   

   
        $user = $db->logout($mobile);
        if ($user) {
               $response["error"] = FALSE;
            echo json_encode($response);
        }else{
              $response["error"] = true;
            echo json_encode($response);
        }

} else {
    $response["error"] = true;
    echo json_encode($response);
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}

function test_c($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  $data=strtoupper($data);
  return $data;
}
?>