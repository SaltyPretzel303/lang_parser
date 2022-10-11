package ast;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Expression extends AstNode {

	protected String result;

	public void genLoad(String reg, BufferedWriter out) throws IOException {
		out.write("\tLoad_Mem\t" + reg + ", " + result);
		out.newLine();
	}

}