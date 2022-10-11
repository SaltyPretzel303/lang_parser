package synttable;

public class TypeNode extends SymbolNode {

	public static int INTEGER = 0;
	public static int CHARACTER = 1;
	public static int INT_POINTER = 3;
	public static int CHAR_POINTER = 4;
	public static int UNKNOWN = 2;

	public int typeKind;

	public TypeNode(String name, int typeKind, SymbolNode next) {
		super(name, SymbolNode.TYPE, null, next);

		this.typeKind = typeKind;
		this.type = this;

	}

}