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

    $address= $_POST['address'];
    $address=test_input($address);
    
    $latitude = $_POST['latitude'];
    $latitude=test_input($latitude);

    $longitude = $_POST['longitude'];
    $longitude=test_input($longitude);

    $date= $_POST['date'];
    $date=test_input($date);

    

          if (!empty($_FILES['image']['name'])) {
  
    $target_path = "Dashboard/orders/";
    $target_path2 = $target_path . basename($_FILES['image']['name']);

       $filepath = "http://139.59.38.160/sendit/Dashboard/orders/". basename($_FILES['image']['name']);

        try {
        // Throws exception incase file is not being moved
        if (!move_uploaded_file($_FILES['image']['tmp_name'], $target_path2)) {
            // make error flag true
            $response['error'] = true;
            $response['message'] = 'Could not move the file!';
        }else{

            $user = $db->addreview($mobile,$filepath,$message,$address,$latitude,$longitude,$date);

        if ($user) {   
        $response["error"] = false;

    } else  {
       
        $response["error"] = true;

    }
        }
 
       
    }
      catch (Exception $e) {
        // Exception occurred. Make error flag true
        $response['error'] = true;
        $response['message'] = $e->getMessage();
    }
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