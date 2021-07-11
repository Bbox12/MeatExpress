<?php
 header('Content-Type: application/json');


require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);

$target_path = "Menu/";

error_reporting(-1);
ini_set('display_errors', 'On');


$server_ip="139.59.38.160";
 var_dump($_POST);
if ( isset($_POST['_mId']) && isset($_POST['canteen'])){



 

    $mobile=$_POST['_mId'];
    $canteen=($_POST['canteen']);
  
    $mobile=test_input($mobile);
    $canteen=test_input($canteen);

        $orderid=($_POST['orderid']);
        $orderid=test_input($orderid);

   if (empty($_FILES['image_1']['name'])) {
       $user = $db->updateontheway($mobile,$canteen,$orderid);
          }else{
      $image_1 = $_FILES['image_1']['name'];
            
               $message=($_POST['message']);
        $message=test_input($message);
  
    $target_path = "Dashboard/orders/";
    $target_path2 = $target_path . basename($_FILES['image_1']['name']);

        try {
        // Throws exception incase file is not being moved
        if (!move_uploaded_file($_FILES['image_1']['tmp_name'], $target_path2)) {
            // make error flag true
            $response['error'] = true;
            $response['message'] = 'Could not move the file!';
        }else{
 $response['message'] = ' move the file!';
          $user = $db->updateonthewayImage($mobile,$canteen,$orderid,$image_1,$message);
        }
 
       
    }
      catch (Exception $e) {
        // Exception occurred. Make error flag true
        $response['error'] = true;
        $response['message'] = $e->getMessage();
    }

  }
       
        if ($user) {
            // user stored successfully
            $response["error"] = FALSE;
            $response["user"]["Unique_Ride_Code"]=$user["Unique_Ride_Code"];
            echo json_encode($response);
        } else {
            // user failed to store
            $response["error"] = TRUE;
            $response["error_msg"] = "Failed!";
            echo json_encode($response);
        }

} else {
    $response["error"] = 0;
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