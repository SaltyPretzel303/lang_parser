package ast;

import java.io.BufferedWriter;
import java.io.IOException;

public class LoopStatement extends Statement {

	private Expression expression;
	private Statement statement;

	public LoopStatement(Expression expression, Statement statement) {
		this.expression = expression;
		this.statement = statement;
	}

	@Override
	public void translate(BufferedWriter out) throws IOException {

		var topLab = AstNode.genLab();
		var endLab = AstNode.genLab();

		out.write(topLab + ":");
		out.newLine();

		expression.translate(out);
		expression.genLoad("R1", out);

		out.write("\tJumpIfZero\t R1, " + endLab);
		out.newLine();

		statement.translate(out);
		out.newLine();

		out.write("\tJump\t " + topLab);
		out.newLine();

		out.write(endLab + ":");
		out.newLine();

	}

}