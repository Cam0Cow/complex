import java.util.*;

public class Program {
  
  private LinkedList<Line> list;
  
  public Program() {
    list = new LinkedList<>();
  }
  
  public void addLine(Line l) {
    if (list.size() == 0) {
      list.add(l);
    } else {
      ListIterator<Line> iter = list.listIterator();
      // find Where to insert the new line
      while (iter.hasNext() && iter.next().getLineNumber() < l.getLineNumber());
      list.add(iter.previousIndex(), l);
    }
  }
  
  public String toString() {
    ListIterator iter = list.listIterator();
    String s = "";
    while (iter.hasNext()) {
      s += iter.next();
      s += "\n";
    }
    return s;
  }
}