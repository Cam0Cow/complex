
public class LexerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLexer lexer = new CLexer();
		lexer.newLine("(15+4+1)/4+\"Hello World\"+12{}", 0);
		CToken[] arr = lexer.ScanLine();
		for(CToken i : arr) {
			System.out.println(i);
		}
	}

}
