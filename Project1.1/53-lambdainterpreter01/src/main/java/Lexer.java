
import java.util.regex.*;

public class Lexer {
    public TokenType tokenType;
    public String expression;
    public String tokenValue;

    /**
     * Lexer 类内构造函数
     *
     * @param s
     */
    public Lexer(String s) {
        expression = s;
        tokenValue = null;
    }

    /**
     * 解析函数，本次作业主任务
     *
     * @return TokenType 当前合法的token的tokenType
     */
    public TokenType nextToken() {
        if (expression.length() == 0) {
            tokenType = TokenType.EOF;
            tokenValue = null;
        } else {
            while (expression.charAt(0) == ' ') {
                expression = expression.substring(1);
            }
            if (expression.charAt(0) == '\\') {
                tokenType = TokenType.LAMBDA;
                expression = expression.substring(1);
                tokenValue = "\\";
            } else if (expression.charAt(0) == '(') {
                tokenType = TokenType.LPAREN;
                expression = expression.substring(1);
                tokenValue = "{";
            } else if (expression.charAt(0) == ')') {
                tokenType = TokenType.RPAREN;
                expression = expression.substring(1);
                tokenValue = "}";
            } else if (expression.charAt(0) == '.') {
                tokenType = TokenType.DOT;
                expression = expression.substring(1);
                tokenValue = ".";
            } else {
                String match = "[A-Za-z]";
                int len = expression.length();
                int i = 0;
                while (i < len) {
                    if (!expression.substring(i, i + 1).matches(match)) {
                        break;
                    }
                    i++;
                }
                tokenValue = expression.substring(0, i);
                if (i != len) {
                    expression = expression.substring(i);
                } else {
                    expression = "";
                }
                tokenType = TokenType.LCID;
            }
        }

        System.out.println(tokenType);
        return tokenType;
    }

    /**
     * check token == t 检查类型
     *
     * @param t
     * @return 类型是否匹配
     */
    public boolean nextIsMatched(TokenType t) {
        //TODO
        return false;
    }

    /**
     * 保证当前token的类型与传入的t相同，并解析下一个符合此法规则的token
     * 如果解析到不同于t的类型，则退出并报错
     *
     * @param t
     */
    public void checkAndNext(TokenType t) {
        //TODO
    }

    /**
     * 跳过当前TokenType t，并解析下一个符合此法规则的token
     *
     * @param t
     * @return 是否skip成功
     */
    public boolean skipThisType(TokenType t) {
        //TODO
        return false;
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer("(\\f.\\x.x)");
        while (lexer.nextToken() != TokenType.EOF){

        }
    }
}
