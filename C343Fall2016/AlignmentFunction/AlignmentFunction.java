

public class AlignmentFunction {
  
  public int compare(char c1, char c2){
    Constants con = new Constants();
    if(c1==c2){
      return con.MATCH;
    }
    
    if(c1 == con.SPACE_CHAR || c2 == con.SPACE_CHAR){
      return con.SPACE_PENALTY;
    }
    else{
      return con.MISMATCH; 
    } 
  }
  
  //use .charAt func to get characters out of the given strings
  
  static Result[][] align(final String s1, final String s2,
                          StringBuilder s1_aligned, StringBuilder s2_aligned) {
    
    
    Constants con = new Constants();
    Result[][] res = new Result[s1.length()+1][s2.length()+1];
    
    res[0][0] = new Result(0, Mutation.M);
    
    
    for (int row = 1; row <= s1.length(); row++){
      Result r = new Result(res[row - 1][0].score + con.SPACE_PENALTY, Mutation.I);
      res[row][0] = r;
    }
    
    for (int col = 1; col <= s1.length(); col++){
      Result r = new Result(res[0][col - 1].score + con.SPACE_PENALTY, Mutation.D);
      res[0][col] = r;
    }
    
    
    for(int i=1; i <= s1.length(); i++){
      for(int j=1; j <= s2.length(); j++){
        
        int scoreDiag; //compare chars later
        int scoreRight = res[i][j - 1].score + con.SPACE_PENALTY; // insertion
        int scoreDown = res[i - 1][j].score + con.SPACE_PENALTY; // deletion
        int maxScore;
        
        if(s2.charAt(i-1) == s1.charAt(j-1)){
          scoreDiag = res[i - 1][j - 1].score + con.MATCH;
        }
        
        else{
          scoreDiag = res[i - 1][j - 1].score + con.MISMATCH;
        }
        
        Result r;
        
        if(scoreDiag >= scoreRight && scoreDiag >= scoreDown){
          r = new Result(scoreDiag, Mutation.M);
        }
        else if(scoreDown >= scoreDiag && scoreDown >= scoreRight){
          r = new Result(scoreDown, Mutation.D);
        }
        else if(scoreRight >= scoreDiag && scoreRight >= scoreDown){
          r = new Result(scoreRight, Mutation.I);
        }
        else { r = new Result(-1, Mutation.M);}
        res[i][j] = r;
        
      }
    }
    return res;
  }
}
