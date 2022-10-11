package ast;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class BinaryExpression extends Expression {

	private Expression left;
	private Expression right;

	public BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public abstract String opCode();

	@Override
	public void translate(BufferedWriter out) throws IOException {

		left.translate(out);
		right.translate(out);

		left.genLoad("R1", out);
		right.genLoad("R2", out);

		out.write("\t" + opCode() + "\t R1, R2");
		out.newLine();

		result = AstNode.genVar();
		out.write("\tStore\t R1" + result);
		out.newLine();

	}

}