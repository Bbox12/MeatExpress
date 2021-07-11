<?php


header('Content-Type: application/json');
        require_once 'DB_Connect.php';
        // connecting to database
        $db = new Db_Connect();
        $conn = $db->connect();

 
if(!$conn){
   echo "Could not connect to DBMS"; 
    }else { 


if (isset($_POST['_mId'])){
 
    $mobile= $_POST['_mId'];
   
    $mobile=test_input($mobile);

    $unique= $_POST['unique'];
   
    $unique=test_input($unique);

     $canteen= $_POST['canteen'];
   
     $canteen=test_input($canteen);

     $orderid= $_POST['orderid'];
   
    $orderid=test_input($orderid);

try{
$server_ip="139.59.38.160";
  $response = array("bookings"=>array(),"foods"=>array());

   $result =$conn->query("SELECT ID FROM  user_details WHERE ID=$mobile");
          
         if ($result->num_rows > 0) {
          while($row = $result->fetch_assoc()) {
          $uID=$row["ID"];
        }
         }




             $bookings=mysqli_query($conn, "SELECT s.ID,s.OrderID,s.CanteenID,s.Date,s.Time,t.Name,t.Address,t.Latitude,t.Longitude,t.Photo,f.Name AS Food,s.NoofItems FROM `store_order` s  
INNER JOIN book_ride b ON b.OTP=s.OrderID 
INNER JOIN foods f ON f.ID=s.FoodID
INNER JOIN tez_Canteen t ON t.ID=s.CanteenID 
WHERE b.Is_Paid=0 AND b.Ride_Cancelled_by=0  GROUP BY s.ID ORDER BY s.ID ");

         
    while ($user1 = mysqli_fetch_assoc($bookings)) {

$jsonRow_201=array(
                 "ID"=>$user1['ID'],
            "OrderID"=>$user1['OrderID'],
                 "CanteenID"=>$user1['CanteenID'], 
                             "Date"=>$user1['Date'],
            "Time"=>$user1['Time'],
              "Name"=>$user1['Name'],
                     "Address"=>$user1['Address'],
                         "Photo"=>$user1['Photo'],
                           "Latitude"=>$user1['Latitude'],
                                      "Longitude"=>$user1['Longitude'],
                                                "Food"=>$user1['Food'],
                                                            "NoofItems"=>$user1['NoofItems'],

                                                            
 );

array_push($response["bookings"], $jsonRow_201);
  

}

             $foods=mysqli_query($conn, "SELECT s.isOntheWay,s.ID,s.OrderID,s.CanteenID,s.Date,s.Time,f.Name AS Food,s.NoofItems FROM `store_order` s  
INNER JOIN foods f ON f.ID=s.FoodID
WHERE  s.OrderID='$orderid'   GROUP BY s.ID ORDER BY s.ID ");

         
    while ($user1 = mysqli_fetch_assoc($foods)) {

$jsonRow_201=array(
                 "ID"=>$user1['ID'],
                  "isOntheWay"=>$user1['isOntheWay'],
                                                "Food"=>$user1['Food'],
                                                            "NoofItems"=>$user1['NoofItems'],

                                                            
 );

array_push($response["foods"], $jsonRow_201);
  

}

   echo json_encode($response);    

} catch(Error $e) {
    $trace = $e->getTrace();
    echo $e->getMessage().' in '.$e->getFile().' on line '.$e->getLine().' called from '.$trace[0]['file'].' on line '.$trace[0]['line'];
}

}
}
 
    
 
function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>