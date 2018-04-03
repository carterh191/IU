public class TOH {

 public void Tower(int number, String source, String other, String destination){
  if(number==1){
   System.out.println("Move disc "+  number + " from " + source + " to " + destination  );
  }
  else{
   Tower(number-1, source, destination, other);
   System.out.println("Move disc " + number + " from " + source + " to " + destination  );
   Tower(number-1, other, source, destination); 
  }
 }
 public static void main (String[] args) throws java.lang.Exception
 {
  int number = 4;
  TOH i = new TOH();
  i.Tower(number,"A","C","B");
 }
}