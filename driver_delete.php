<?php
 header('Content-Type: application/json');


require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);
 
if (isset($_POST['mobile']) && isset($_POST['driver']) ) {
 
    // receiving the post params
    $mobile = $_POST['mobile'];
     $driver = $_POST['driver'];
   
    

    $mobile=test_input($mobile);
    $driver=test_input($driver);
   
 
 
        // create a new user
        $user = $db->delete_driver($mobile,$driver);
        if ($user) {
            // user stored successfully
            $response["error"] = FALSE;
            echo json_encode($response);
        } else {
            // user failed to store
            $response["error"] = TRUE;
            echo json_encode($response);
        }
    }
 else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters is missing!";
    echo json_encode($response);
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>