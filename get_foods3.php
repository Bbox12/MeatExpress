<?php


header('Content-Type: application/json');
        require_once 'DB_Connect.php';
        // connecting to database
        $db = new Db_Connect();
        $conn = $db->connect();

 
if(!$conn){
   echo "Could not connect to DBMS"; 
    }else { 


   $mID=0;
      $sID=0;

      if (isset($_POST['_mId'])){
 
    $uID= $_POST['_mId'];
   
    $uID=test_input($uID);



}else{
     $uID="";
}


if (isset($_POST['menu'])){
 
    $menu= $_POST['menu'];
   
    $menu=test_input($menu);

   $result =$conn->query("SELECT ID FROM  menu_type WHERE Name=$menu");
          
         if ($result->num_rows > 0) {
          while($row = $result->fetch_assoc()) {
          $mID=$row["ID"];
        }
         }

}else{
     $menu="";
}



if (isset($_POST['submenu'])){
 
    $submenu= $_POST['submenu'];
   
    $submenu=test_input($submenu);
      $result =$conn->query("SELECT ID FROM  subsubmenu WHERE Name=$submenu");
          
         if ($result->num_rows > 0) {
          while($row = $result->fetch_assoc()) {
          $sID=$row["ID"];
        }
         }

}else{
     $submenu="";
}



try{
$server_ip="139.59.38.160";
  $response = array("foods"=>array());


          

            $eats=mysqli_query($conn, "SELECT f.Name,s.Unit,s.Date,s.Time FROM `foods` f  INNER JOIN stock s ON s.IDFood=f.ID  WHERE f.Available=1  AND (f.IDMenu='$mID' OR f.IDSubsubmenu='$sID') AND s.IDStockies='$uID' ");

while ($user1 = mysqli_fetch_assoc($eats)) {

$jsonRow_201=array(
  "ID"=>$user1['ID'],
    
               
                         "Name"=>$user1['Name'],
                         
                          "Unit"=>$user1['Unit'],

                                   "Date"=>$user1['Date'],
                         
                          "Time"=>$user1['Time'],
                      
 );

array_push($response["foods"], $jsonRow_201);
  
}






   echo json_encode($response);    

} catch(Error $e) {
    $trace = $e->getTrace();
    echo $e->getMessage().' in '.$e->getFile().' on line '.$e->getLine().' called from '.$trace[0]['file'].' on line '.$trace[0]['line'];
}

}

 
    
 
function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>