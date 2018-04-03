class Coord {
  Coord(int init_x, int init_y) { x = init_x; y = init_y; } 
  int x; int y;
}
static int carve_seam(int[][] D, ArrayList<Coord> seam) { ... }


class carve_seam(d){
  result[][] table == new result[][]
    (best_Cost(d, table, ()

class best_Cost(d, table, (i, ,j)){
  if (table[i][j] != null)
    return table[i][j];
  else table[i][j] = (min( best_Cost(d, table,(i+1, j-1),
                                     (best_cost(d, table,(i+1, j+1),
                                                (best_cost(d, table,(i+1, j))
                                                   (+ d[i][j])))))))
    return table[i][j];
}

class Result{
  int cost; 
  ArrayList<Coord> = path;
  public Result(int c, ArryList<Coord> p){
    cost = c;
    path = p;
    
  }
}
  
  
                                      

{
    int[][] D = new int[3][3];
    D[0][0] = 1; D[0][1] = 0; D[0][2] = 1;
    D[1][0] = 1; D[1][1] = 0; D[1][2] = 1;
    D[2][0] = 1; D[2][1] = 0; D[2][2] = 1;

    ArrayList<Coord> seam = new ArrayList<Coord>();
    int disruption = carve_seam(D, seam);
    assert disruption == 0;
    for (int i = 0; i != seam.size(); ++i) {
    Coord c = seam.get(i);
    assert c.x == i;
    assert c.y == 1;
    }
}
