

public class Line {
  
  private int lineNumber;
  private String code;
  
  // maybe add AST here?
  
  public Line(int lineNumber, String code) {
    this.lineNumber = lineNumber;
    this.code = code;
  }
  
  public int getLineNumber() {
    return lineNumber;
  }
  
  public String getCode() {
    return code;
  }
  
  public String toString() {
    return lineNumber + " " + code;
  }
  
}