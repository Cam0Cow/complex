import java.util.ArrayList;
import java.util.List;

public class CLexer {
	
	private List<CToken> tokens;
	private String line;
	private int lineNum;
	int current;
	int start;
	
	public CLexer() {
		tokens = new ArrayList<CToken>();
		current = 0;
		start = 0;
	}
	
	public void newLine(String line, int lineNum) {
		this.line = line;
		this.lineNum = lineNum;
		tokens.clear();
		current = 0;
		start = 0;
	}
	
	public CToken[] ScanLine() {
		while(current<line.length()) {
			char c = getNext();
			switch(c) {
			case '+': addToken(CTokenType.PLUS); break;
			case '-': addToken(CTokenType.MINUS); break;
			case '/': addToken(CTokenType.SLASH); break;
			case '*': addToken(CTokenType.STAR); break;
			case '=': addToken(matches('=')?CTokenType.EQUAL_EQUAL:CTokenType.EQUAL); break;
			case '>': addToken(matches('=')?CTokenType.GREATER_EQUAL:CTokenType.GREATER); break;
			case '<': addToken(matches('=')?CTokenType.LESS_EQUAL:CTokenType.LESS); break;
			case '!': addToken(matches('=')?CTokenType.BANG_EQUAL:CTokenType.BANG); break;
			case '(': addToken(CTokenType.LEFT_PAREN); break;
			case ')': addToken(CTokenType.RIGHT_PAREN); break;
			case '{': addToken(CTokenType.LEFT_BRACE); break;
			case '}': addToken(CTokenType.RIGHT_BRACE); break;
			case '"': addString();break;
			default:
				if(isNumber(c))
					addNum();
			}
		}
		CToken[] arr = new CToken[tokens.size()];
		return tokens.toArray(arr);
	}
	
	private void addNum() {
		while(isNumber(peek())) {
			current++;
		}
		addToken(CTokenType.NUMBER);
	}
	
	private void addString() {
		start++;
		while(peek()!='"'&&current<line.length()) {
			current++;
		}
		addToken(CTokenType.STRING);
		start++;
		current++;
	}
	
	private char peek() {
		if(current>=line.length())
			return '\0';
		return line.charAt(current);
	}
	
	private boolean matches(char key) {
		if(line.charAt(current)!=key||current>=line.length())
			return false;
		current++;
		return true;
	}
	
	public boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	
	/*private boolean isAlpha(char c) {
	    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||  c == '_';
	  }*/
	
	private char getNext() {
		current++;
		return line.charAt(current-1);
	}
	
	private void addToken(CTokenType type) {
		addToken(null, type);
	}
	
	private void addToken(Object literal, CTokenType type) {
		tokens.add(new CToken(line.substring(start, current), literal, type));
		start = current;
	}
}
