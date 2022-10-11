package ast;

import java.io.BufferedWriter;
import java.io.IOException;

import ast.AstNode;
import ast.Expression;
import ast.Statement;

public class IfStatement extends Statement {

	private Expression condition;
	private Statement thenBlock;
	private Statement elseBlock;

	@Override
	public void translate(BufferedWriter out) throws IOException {
		condition.translate(out);
		condition.genLoad("R1", out);

		var elseLabel = AstNode.genLab();
		var endLabel = AstNode.genLab();

		out.write("\tJumpIfZero\t R1," + elseLabel);
		out.newLine();

		thenBlock.translate(out);

		out.write("\tJump\t " + endLabel);
		out.newLine();

		out.write(elseLabel + ":");
		out.newLine();

		elseBlock.translate(out);

		out.write(endLabel + ":");
		out.newLine();

	}

}