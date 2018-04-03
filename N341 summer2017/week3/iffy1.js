function promptUser()
  {
   var answer="   "
   var statement="Answer yes or no"
   var answer=prompt("Have you arrived to port on time?")
   if ( answer == "yes")
    {statement="you have earned 7 doubloons"}
   if(answer == "no")
    {statement="Argh!Off with ye head"}
   alert(statement)
    }