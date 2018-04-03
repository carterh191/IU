import java.util.*;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FloodFunction2 {
  public Driver driver;
  public List<Coord> flooded_list = new LinkedList<>();
  
  public FloodFunction2(final Driver _driver) {
    this.driver = _driver;
    this.flooded_list.add(new Coord(0, 0));
  }
  
  public boolean inbound(final Coord coord) {
    return coord.x > -1 && coord.x < this.driver.size && coord.y > -1 && coord.y < this.driver.size;
  }
  
  public Coord up(final Coord coord) {
    return new Coord(coord.x, coord.y-1);
  }
  
  public Coord down(final Coord coord) {
    return new Coord(coord.x, coord.y+1);
  }
  
  public Coord left(final Coord coord) {
    return new Coord(coord.x-1, coord.y);
  }
  
  public Coord right(final Coord coord) {
    return new Coord(coord.x+1, coord.y);
  }
  
  public void flood(final Map color_of_tiles, final Integer color) {
    // students: put your code here!
    LinkedHashSet<Coord> All = new LinkedHashSet<>();
    HashSet<Coord> flooding = new HashSet<>();
    HashSet<Coord> Search = new HashSet<>();
    for(Coord coord:this.flooded_list){
      Search.add(coord);
    }
    int Size = All.size();
    for(;;){
      Size = All.size();
      for(Coord coord:Search){
        if(this.inbound(this.down(coord))){
          if(color_of_tiles.get(this.down(coord)) == color){
            flooding.add(this.down(coord));
          }
        }
        if(this.inbound(this.right(coord))){
          if(color_of_tiles.get(this.right(coord)) == color){
            flooding.add(this.right(coord));
          }
        }
        if(this.inbound(this.left(coord))){
          if(color_of_tiles.get(this.left(coord)) == color){
            
            flooding.add(this.left(coord));
          }
        }
        
        if(this.inbound(this.up(coord))){
          if(color_of_tiles.get(this.up(coord)) == color){
            flooding.add(this.up(coord));
          }
        }
      }
      All.addAll(flooding);
      if(All.size() == Size){
        break;
      }
      Search = flooding;
      flooding = new HashSet<>();
    }
    for(Coord coord:this.flooded_list){
      All.remove(coord);
    }
    this.flooded_list.addAll(All);
    System.out.println("Size: " + this.flooded_list.size());
  }
}
