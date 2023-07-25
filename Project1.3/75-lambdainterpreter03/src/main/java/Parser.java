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
        String param;
        String paramValue;
        if (lexer.skipThisType(TokenType.LAMBDA)){
            if(lexer.nextIsMatched(TokenType.LCID)) {
                param = lexer.tokenvalue;
                lexer.checkAndNext(TokenType.LCID);
                if (lexer.skipThisType(TokenType.DOT)) {
                    ctx.add(0,param);
                    paramValue = ""+ctx.indexOf(param);
                    AST aTerm = parseAsTerm(ctx);
                    ctx.remove(ctx.indexOf(param));
                    return new Abstraction(new Identifier(param,paramValue),aTerm);
                }
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
        AST rhs;
        while(true) {
            rhs =parseAsAtom(ctx);
            if (rhs==null) {
                return lhs;
            } else {
                lhs = new Application(lhs,rhs);
            }
        }
    }

    /**
     *解析 atom
     * @param ctx
     * @return
     */
    private AST parseAsAtom(ArrayList<String> ctx){
        String param;
        String paramValue;
        if(lexer.skipThisType(TokenType.LPAREN)){
            AST aTerm = parseAsTerm(ctx);
            if(lexer.skipThisType(TokenType.RPAREN))
                return aTerm;
        }else if(lexer.nextIsMatched(TokenType.LCID)){
            param = lexer.tokenvalue;
            paramValue = ""+ctx.indexOf(param);
            lexer.checkAndNext(TokenType.LCID);
            return new Identifier(param,paramValue);
        }
        return  null;
    }
}
