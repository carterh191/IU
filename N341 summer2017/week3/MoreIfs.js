function promptUser()
  {
	int intCurrentLatitude;
	int intCurrentLongitude;
	int intDestinationLatitude;
	int intDestinationLongitude;
	
   var dest=""
   //var longi=""
   //var statement="Enter Coordinates"
   var answer=prompt("Enter latitude")
   var answer2=prompt("Enter Longitude")
   
   if (intCurrentLatitude <= intDestinationLatitude && intCurrentLongitude <= intDestinationLongitude)
    {dest="Head North East"}
   else if(intCurrentLatitude <= intDestinationLatitude && intCurrentLongitude >= intDestinationLongitude)
    {dest="Head North West"}
else if(intCurrentLatitude >= intDestinationLatitude && intCurrentLongitude >= intDestinationLongitude)
    {dest="Head South West"}
else if(intCurrentLatitude >= intDestinationLatitude && intCurrentLongitude >= intDestinationLongitude)
    {dest="Head South East"}
else 
	alert("Land Ho!")
    }
	
	//not sure what I am doing wrong on this 