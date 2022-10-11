package synttable;

public class SymbolTable {

	public SymbolNode vars;
	public SymbolNode types;

	public SymbolTable() {

		// global types
		this.types = new TypeNode("unknown", TypeNode.UNKNOWN, null);
		this.types = new TypeNode("integer", TypeNode.INTEGER, this.types);
		this.types = new TypeNode("char", TypeNode.CHARACTER, this.types);

		this.types = new TypeNode("int_pointer", TypeNode.INT_POINTER, this.types);
		this.types = new TypeNode("char_pointer", TypeNode.CHAR_POINTER, this.types);

		this.vars = null;

	}

	public boolean addVar(String name, TypeNode type) {

		if (getVar(name) == null) {
			this.vars = new Variable(name, type, this.vars);

			return true;
		}

		return false;
	}

	private void printState() {
		System.out.println("Table content: ");

		var current = vars;
		while (current != null) {
			System.out.println(current.name);

			current = current.next;
		}
	}

	public Variable getVar(String name) {
		var current = this.vars;
		while (current != null && !current.name.equals(name)) {
			current = current.next;
		}
		return (Variable) current;
	}

	public TypeNode getType(String name) {
		var current = this.types;
		while (current != null && !current.name.equals(name)) {
			current = current.next;
		}
		return (TypeNode) current;
	}

}