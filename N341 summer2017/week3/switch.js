<script>

	var day;
	int intCurrentLatitude = 0;
	int intCurrentLongitude= 0;
	int intDestinationLatitude= 0;
	int intDestinationLongitude = 0;
	var dest=""
   //var longi=""
   //var statement="Enter Coordinates"
   var answer=prompt("Enter latitude")
   var answer2=prompt("Enter Longitude")
   
switch (true){ 
//(new Date().getDay()) {
    case 0:
        (intCurrentLatitude <= intDestinationLatitude && intCurrentLongitude <= intDestinationLongitude)
    {dest="Head North East"};
        break;
    case 1:
        (intCurrentLatitude <= intDestinationLatitude && intCurrentLongitude >= intDestinationLongitude)
    {dest="Head North West"};
        break;
    case 2:
        (intCurrentLatitude >= intDestinationLatitude && intCurrentLongitude >= intDestinationLongitude)
    {dest="Head South West"};
        break;
    case 3:
        (intCurrentLatitude >= intDestinationLatitude && intCurrentLongitude >= intDestinationLongitude)
    {dest="Head South East"};
        alert("Land Ho!");
    
}
document.getElementById("demo").innerHTML = "Today is " + day;
</script>