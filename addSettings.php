<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
 header('Content-Type: application/json');
 session_start();

require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);

var_dump($_POST);

 
$endtime=$_POST["endtime"];
$endtime=test_input($endtime);

 
$monimumorders=$_POST["monimumorders"];
$monimumorders=test_input($monimumorders);
 
$minimumweight=$_POST["minimumweight"];
$minimumweight=test_input($minimumweight);



 
$minimumdistance=$_POST["minimumdistance"];
$minimumdistance=test_input($minimumdistance);

 
$maximumdistance=$_POST["maximumdistance"];
$maximumdistance=test_input($maximumdistance);
 

 
$freedeldistance=$_POST["freedeldistance"];
$freedeldistance=test_input($freedeldistance);



 
$price=$_POST["price"];
$price=test_input($price);
 
$starttime=$_POST["starttime"];
$starttime=test_input($starttime);

 
$discount=$_POST["discount"];
$discount=test_input($discount);
 



$User= $_SESSION["email"];
$IP= $_SERVER['REMOTE_ADDR'];
$User= test_input($User);
$IP= test_input($IP);



  $user = $db->addSettings($discount,$monimumorders,$minimumweight,$minimumdistance,$maximumdistance,$freedeldistance,$price,$starttime,$endtime,$User,$IP);
             if ($user) {  
          $_SESSION["error"]=1;
        $response["error"] = false;
      header('Location: http://139.59.38.160/GGKITCHEN/Dashboard/DefaultSettings.php');
    } else  {
            $_SESSION["error"]=2;
        $response["error"] = true;
          header('Location: http://139.59.38.160/GGKITCHEN/Dashboard/DefaultSettings.php');
    }

 
 

    



     echo json_encode($response); 
       


function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>