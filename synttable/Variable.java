package synttable;

public class Variable extends SymbolNode {

	public int lastDef;
	public int lastUsed;

	public Variable(String name, TypeNode type, SymbolNode next) {
		super(name, SymbolNode.VAR, type, next);

		this.lastDef = -1;
		this.lastUsed = -1;
	}

}