<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
 header('Content-Type: application/json');


require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);

if (isset($_POST['mobile'])){
 

    


    $mobile= $_POST['mobile'];
    $mobile=test_input($mobile);

    $message = $_POST['message'];
    $message=test_input($message);

    $pick= $_POST['pick'];
    $pick=test_input($pick);
    
    $latitude = $_POST['latitude'];
    $latitude=test_input($latitude);

    $longitude = $_POST['longitude'];
    $longitude=test_input($longitude);

    $drop= $_POST['drop'];
    $drop=test_input($drop);
    
    $latitude2 = $_POST['latitude2'];
    $latitude2=test_input($latitude2);

    $longitude2 = $_POST['longitude2'];
    $longitude2=test_input($longitude2);

    $date = $_POST['date'];
    $date=test_input($date);

  
    $type= $_POST['type'];
    $type=test_input($type);

    $weight= $_POST['weight'];
    $weight=test_input($weight);

    
    $user = $db->addcourier($date,$mobile,$message,$pick,$latitude,$longitude,$drop,$latitude2,$longitude2,$type,$weight);

        if ($user) {   
        $response["error"] = false;

    } else  {
       
        $response["error"] = true;

    }
    



} else {
    // File parameter is missing
    $response['error'] = true;
    $response['message'] = 'Not received any file!';
}
     echo json_encode($response); 
       


function test_input($data) {
  $data = trim($data);

  $data = htmlspecialchars($data);
  return $data;
}
?>