package synttable;

public class SymbolNode {
	public static int TYPE = 0;
	public static int VAR = 1;

	public String name;
	public int symbolKind;
	public TypeNode type;
	public SymbolNode next;

	public SymbolNode(String name,
			int kind,
			TypeNode type,
			SymbolNode next) {

		this.name = name;
		this.symbolKind = kind;
		this.type = type;
		this.next = next;
	}

}