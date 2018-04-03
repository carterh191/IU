
$(document).ready(function(){
			
	alert("Hoist the secret message ye scurvy dawgs!");
	function alertpositive(){
	alert("Enter ye but one letter");
	}
	alertpositive();
	//Your code here
	
	/*****			
	Purpose: *** For full credit, describe the purpose of this function here ***			
	Parameters: single character / letter		
	Return: integer representing an ascii value
	*****/
	function parseAscii(chrCharacter)
	{
		intAscii = chrCharacter.charCodeAt(0);
		return intAscii;
	}
	
	/*****			
	Purpose: *** For full credit, describe the purpose of this function here ***			
	Parameters: single integer representing an ascii value	
	Return: binary, base 2 representation of the number passed to this function
	*****/
	function parseBin(intAscii)
	{
		strBin = parseInt(intAscii, 10).toString(2);
		if(strBin.length < 8)
		{
			var intPlaceHolders = 8 - strBin.length;
			for(var i = 0; i < intPlaceHolders; i++)
			{
				strBin = "0" + strBin;
			}
			
		}
		
		return strBin;
	}
});