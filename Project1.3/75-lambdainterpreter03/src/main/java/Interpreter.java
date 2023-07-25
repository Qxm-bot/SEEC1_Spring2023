public class Interpreter {
    Parser parser;
    AST astAfterParser;

    public Interpreter(Parser p) {
        parser = p;
        astAfterParser = p.parse();
        System.out.println("After parser:" + astAfterParser.toString());
    }

    private boolean isAbstraction(AST ast) {
        return ast instanceof Abstraction;
    }

    private boolean isApplication(AST ast) {
        return ast instanceof Application;
    }

    private boolean isIdentifier(AST ast) {
        return ast instanceof Identifier;
    }

    public AST eval() {
        return evalAST(astAfterParser);
    }

    public boolean isFinalValue(AST ast) {
        if (isIdentifier(ast)) {
            return true;
        } else if (isApplication(ast)) {
            if (isIdentifier(((Application) ast).lhs)) {
                return true;
            } else {
                return isFinalValue(((Application) ast).lhs);
            }
        } else if (isAbstraction(ast)) {
            return isFinalValue(((Abstraction) ast).body);
        }
        return false;
    }

    private AST evalAST(AST ast) {
        if(isApplication(ast)){
            if(isAbstraction(((Application) ast).lhs)){
                ((Application) ast).rhs = evalAST(((Application) ast).rhs);
                ast = substitute(((Abstraction)((Application) ast).lhs).body, ((Application) ast).rhs);
                return evalAST(ast);
            }else if(isIdentifier(((Application)ast).lhs)){
                ((Application) ast).rhs = evalAST(((Application) ast).rhs);
                return ast;
            }else {
                ((Application) ast).lhs = evalAST(((Application) ast).lhs);
                if(isAbstraction(((Application) ast).lhs)){
                    return evalAST(ast);
                }
                return ast;
            }
        }else if(isAbstraction(ast)){
            ((Abstraction) ast).body = evalAST(((Abstraction) ast).body);
            return ast;
        }
        return ast;
    }

    private AST substitute(AST node, AST value) {
        return shift(-1, subst(node, shift(1, value, 0), 0), 0);
    }

    private AST subst(AST node, AST value, int depth) {
        if (isApplication(node)) {
            return new Application(subst(((Application) node).lhs, value, depth), subst(((Application) node).rhs, value, depth));
        } else if (isAbstraction(node)) {
            return new Abstraction(((Abstraction) node).param, subst(((Abstraction) node).body, value, depth + 1));
        }
        if (Integer.parseInt(((Identifier) node).value) == depth) {
            return shift(depth, value, 0);
        }
        return node;
    }

    private AST shift(int by, AST node, int from) {
        if (isApplication(node)) {
            return new Application(shift(by, ((Application) node).lhs, from), shift(by, ((Application) node).rhs, from));
        } else if (isAbstraction(node)) {
            return new Abstraction(((Abstraction) node).param, shift(by, ((Abstraction) node).body, from + 1));
        }
        if (Integer.parseInt(((Identifier) node).value) >= from) {
            String s = "" + (Integer.parseInt(((Identifier) node).value) + by);
            return new Identifier(((Identifier) node).name, s);
        }
        return new Identifier(((Identifier) node).name, ((Identifier) node).value);
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer("(\\f.\\x.   (\\f.\\x.f (f x))   (\\g.\\h.h(g f))  (\\u.x)  (\\u.u))");
        Parser parser = new Parser(lexer);
        Interpreter interpreter = new Interpreter(parser);
        System.out.println((interpreter.eval()).toString());
    }
}

//  \f.\x.   (\f.\x.f (f x))   (\g.\h.h(g f))  (\\u.x)  (\\u.u)
//  -->
//  \f.\x.   (\x. (\g.\h.h(g f)) ((\g.\h.h(g f)) x) )    (\\u.x)  (\\u.u)
//  -->
//  \f.\x.   (\x. (\g.\h.h(g f)) (\h.h(x f)) )    (\\u.x)  (\\u.u)
//  \.\.((\.(\.\.(0 (1 4)) \.(0 (1 3))) \.1) \.0)
//  -->
//  \f.\x.   (\x. (\h.h((\h.h(x f)) f))  )    (\\u.x)  (\\u.u)