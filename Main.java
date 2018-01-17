

public class Main {
  public static void main(String[] args) {
    Line l1 = new Line(20, "Print A");
    Line l2 = new Line(10, "Let A=42");
    Program p = new Program();
    p.addLine(l1);
    p.addLine(l2);
    System.out.println(p);
  }
}