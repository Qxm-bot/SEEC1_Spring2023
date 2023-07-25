import java.util.ArrayList;

public class Parser {
    Lexer lexer;
    public Parser(Lexer l){
        lexer = l;
    }


    public AST parse(){//解析入口
        AST ast = parseAsTerm(new ArrayList<>());
        return ast;
    }

    /**
     *解析 term
     * @param ctx
     * @return
     */
    private AST parseAsTerm(ArrayList<String> ctx){
        String paramName;
        String paramValue;
        if(lexer.tokenType == null){
            if(lexer.nextToken() == TokenType.LAMBDA){
                if(lexer.nextToken() == TokenType.LCID){
                    paramName = lexer.tokenValue;
                    ctx.add(0, paramName);
                    lexer.nextToken(); //跳过DOT
                    lexer.nextToken(); //到DOT后面一个token
                    AST body = parseAsTerm(ctx);
                    paramValue = "" + ctx.indexOf(paramName);
                    ctx.remove(paramName);
                    return new Abstraction(new Identifier(paramName, paramValue), body);
                }
            }else {
                return parseAsApplication(ctx);
            }
        }else if(lexer.tokenType == TokenType.LAMBDA){
            if(lexer.nextToken() == TokenType.LCID) {
                paramName = lexer.tokenValue;
                ctx.add(0, paramName);
                lexer.nextToken(); //跳过DOT
                lexer.nextToken(); //到DOT后面一个token
                AST body = parseAsTerm(ctx);
                paramValue = "" + ctx.indexOf(paramName);
                ctx.remove(paramName);
                return new Abstraction(new Identifier(paramName, paramValue), body);
            }
        }else {
            return parseAsApplication(ctx);
        }
        return null;
    }

    /**
     *解析 application
     * @param ctx
     * @return
     */
    private AST parseAsApplication(ArrayList<String> ctx){
        AST lhs = parseAsAtom(ctx);
        AST rhs = null;
        while(lexer.expression.length() != 0 && lexer.nextToken() != TokenType.RPAREN){
            lhs = new Application(lhs, rhs);
            rhs = parseAsAtom(ctx);
        }
        return new Application(lhs, rhs);
    }

    /**
     *解析 atom
     * @param ctx
     * @return
     */
    private AST parseAsAtom(ArrayList<String> ctx){
        if(lexer.tokenType == null){
            if(lexer.nextToken() == TokenType.LPAREN){
                AST term = parseAsTerm(ctx);
                return term;
            }else if(lexer.nextToken() == TokenType.LCID){
                String paramName = lexer.tokenValue;
                String paramValue = "" + ctx.indexOf(paramName);
                return new Identifier(paramName, paramValue);
            }
        }else {
            if(lexer.tokenType == TokenType.LPAREN){
                lexer.nextToken(); //到下一个token
                AST term = parseAsTerm(ctx);
                return term;
            }else if(lexer.tokenType == TokenType.LCID){
                String paramName = lexer.tokenValue;
                String paramValue = "" + ctx.indexOf(paramName);
                return new Identifier(paramName, paramValue);
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        String Str = "(\\m.\\n.((m (\\n.\\f.\\x.f (n f x)) ) n))";
        Lexer lexer = new Lexer(Str);
        Parser parser = new Parser(lexer);
        System.out.println(parser.parse().toString());
    }
}

