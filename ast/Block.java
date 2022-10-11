package ast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Block extends Statement {

	private ArrayList<Statement> statements = new ArrayList<Statement>();

	@Override
	public void translate(BufferedWriter out) throws IOException {
		for(var statement: statements){
			statement.translate(out);
		}
	}

}