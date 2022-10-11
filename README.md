# lang_parser
Notes about how to use jflex (lexical analyzer) and cup (syntax/semantic analyzer)

Clone this repo: `~/$ git clone https://github.com/SaltyPretzel303/lang_parser/`  
Navigate in to the cloned repo: `~/$ cd lang_parser`  

Download [jFlex](https://jflex.de/)  
Download [CUP](http://www2.cs.tum.edu/projects/cup/docs.php)  

Extract jFlex and start GUI app using: `$ ./jflex-version-/bin/jflex`  
Extract CUP (two jar files should apper java-cup-version.jar and java-cup-version-runtime.jar)  

Build two provided pacakges `ast` and `synttable` with: `$ javac ./ast/*.java ./synttable/*.java`.  

Crate directory which is gonna be used as an java package: `$ mkdir parser`  

Inside newly created package you are gonna need next files: 
  - Lexical specification used by jflex `touch parser/lex_spec.flex`.
  - Syntax and semantic specification used by CUP `touch parser/synt_spec.cup`.
  - Text file containing code that is gonna be read and parsed `touch parser/sample`. 
  - Single java class with the main method in which you will use classes generated based on the specifications to read and parse sample code (class provided in the root of this repo, you can just copy it to your package).  
  `cp SyntaxParser.java ./parser/`  

Write syntax/semantic specification in .cup file (example provided in the whileloop package [synt_spec.cup](/whileloop/synt_spec.cup)).  

In the file [note](/note) you will find few aliases that will help you read specifications and start parsing the code. Copy commands one by one, replace packagename with the name of your package (in this case we crated package named parser) and execute them. 
  - `build_all` will build all java classes inside your package.  
  - `read_cup` will use CUP to generate two classes `parser.java` and `sym.java` based on your synt_spec.cup specification.  
  - `run_parse` will run SyntaxParser's main method which will result in reading reading, parsing and analyzing sample file. 
  
Use `read_cup` alias to read cup specification and generate syntax parser: `$ read_cup`.  
 
If everything goes well you can start writting lexical specification in .flex file (example provided in the whileloop package [lex_spec.flex](/whileloop/lex_spec.flex) )

With the jFlex GUI app (started in one of the steps above) select your lex_spec.flex and click `Generate` button. 
If everything goes well Lexer.java class should be generated inside your package.  

Build all java classes inside your package using build all alias: `$ build_all`.  

If there was no errors you can write code inside the sample txt file and run parser with `$ run_parse`.  

 

 
