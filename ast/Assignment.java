package ast;

import java.io.BufferedWriter;
import java.io.IOException;

public class Assignment extends Statement {

	private Variable left;
	private Expression right;

	public Assignment(Variable left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void translate(BufferedWriter out) throws IOException {
		right.translate(out);
		right.genLoad("R1", out);

		out.write("\tStore\t R1" + left.name);
		out.newLine();
	}

}