package whileloop;

%%
%class Lexer
%debug
%line
%column 
%cup

%{
	public java_cup.runtime.Symbol getSym(int id, Object value){
		return new java_cup.runtime.Symbol(id, yycolumn, yycolumn+yylength(), value);
	}
%}

%eofval{
	return getSym(sym.EOF, null);
%eofval}

digit = [0-9]
letter = [a-zA-Z]

%%

// ignore whitespaces and newlines
[\t\n ]		{;}

while		{ return getSym(sym.whilekw, null); }
do		{ return getSym(sym.dokw, null); }
end		{ return getSym(sym.endkw, null); }
\=		{ return getSym(sym.assign, null); }
\;		{ return getSym(sym.semcol, null); }
\+		{ return getSym(sym.plus, null); }
\-		{ return getSym(sym.minus, null); }
\=\=		{ return getSym(sym.equal, null); }
\|\|		{ return getSym(sym.orkw, null); }
\&\&		{ return getSym(sym.andkw, null); }


// recognized ID, first char can be letter or underscor followed by letters, digits or underscors
({letter}|_)({letter}|{digit}|_)*	{ return getSym(sym.ID, yytext()); }

// any sequence of characters between " and "
\"[^\"*]\"		{ return getSym(sym.strconst, yytext()); }

// sequence of digits that can start (doesn't have to) with + or -
(\+|-)?{digit}*		{ return getSym(sym.intconst, Integer.parseInt(yytext())); }
