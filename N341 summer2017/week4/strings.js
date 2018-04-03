function promptUser(){

   var strName = "";
   var strQuestion = "Who ye queen fancy right now?";
   var strDefault = "William";
   strName = prompt(strQuestion, strDefault);
   alert(strName);
   
   // var strPhrase = strName;
//    var intPhraseLength = 0;
//    intPhraseLength = strPhrase.length;
//    alert("The length of your phrase is " + intPhraseLength);
   
   var text1 = strName;
   var text2 = text1.toUpperCase();
   var text3 = text1.toLowerCase();
   alert(text2)
   alert(text2 + "" + "The Destroyer");
   alert(text3);
    
   var str = strName;
   var charResult = str.charAt(2);
   alert(charResult);
   
   var str = strName;
   var res = str.substring(3);
   alert(res);
   
   var str = strName;
   var res2 = str.substring(1, 4);
   alert(res2);
   
   var str = strName;
   var n = str.replace(str, "This guy");
   alert(n);
   
   var str = strName;
   var q = str.replace(str, str + "" + "THEE Magnificent");
   alert(q);
   
   var str = strName;
   var k = str.trim(str);
   alert(k);
   
   var str =strName;
   var p = str.substr(3,6);
   alert(p);
   
   var str =strName;
   var w = str.substr(1 + ".",2 + ".");
   alert(w);
   
   var str = strName;
   var pos = str.indexOf("e" + "slayer");
   alert(pos);
   
   
   var shipNames = [text2,text2 + "" + "The Destroyer", text3, charResult,
   res, res2, n, q, k, p, w, pos],
    arrayLength = arrayVariable.length;

	for (i = 0; i < arrayLength; i++) {
  	$('<div class="results" />').text(shipNames[i]).appendTo('body');
}
   
  
    }
    