<?php
 header('Content-Type: application/json');


require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response arra
$response = array("error" => FALSE);
if (isset($_POST['OTP'])){
   
    $mobile = $_POST['mobile'];
     
    $OTP = $_POST['OTP'];

               
    $mobile=test_input($mobile);
 
    $OTP=test_input($OTP);
  
                  $IP=test_input($IP);
   


            $user = $db->start_ride_driver($mobile,$OTP);

         if ($user) {
       
        $response["error"] = false;
       $response["user"]["unique_id"]=$user["Unique_Ride_Code"];
              $response["user"]["OTP"]=$user["OTP"];
                   $response["user"]["ID"]=$user["ID"];
    
    } else  {
        $response["error"] = true;
    
    }
 echo json_encode($response);
} else {
    // File parameter is missing
    $response['error'] = true;
    $response['message'] = 'Not received any file!';
}
     echo json_encode($response); 
       


function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>