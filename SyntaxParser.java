package parser;

import java.io.FileReader;

public class SyntaxParser {
	public static void main(String[] args) {

		try {

			FileReader reader = new FileReader(args[0]);
			Lexer lexer = new Lexer(reader);
			parser _parser = new parser(lexer);
			java_cup.runtime.Symbol lastSym = _parser.parse();

		} catch (Exception e) {
			System.out.println("Exception while parsing ... ");
			System.out.println(e.getMessage());
		}

	}
}
