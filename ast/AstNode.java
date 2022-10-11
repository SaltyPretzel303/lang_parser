package ast;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class AstNode {

	private static int varNo;
	private static int labNo;

	public static String genVar() {
		return "$tmp" + varNo++;
	}

	public static String genLab() {
		return "lab" + labNo++;
	}

	public abstract void translate(BufferedWriter out) throws IOException;
}