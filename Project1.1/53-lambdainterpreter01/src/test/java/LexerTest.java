import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class LexerTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    String lineBreak;

    private static String ZERO = "(\\f.\\x.x)";
    private static String SUCC = "(\\n.\\f.\\x.f (n f x))";
    private static String ONE = app(SUCC, ZERO);
    private static String TWO = app(SUCC, ONE);
    private static String THREE = app(SUCC, TWO);
    private static String FOUR = app(SUCC, THREE);
    private static String FIVE = app(SUCC, FOUR);
    private static String PLUS = "(\\m.\\n.((m " + SUCC + ") n))";
    private static String POW = "(\\b.\\e.e b)";       // POW not ready
    private static String PRED = "(\\n.\\f.\\x.n(\\g.\\h.h(g f))(\\u.x)(\\u.u))";
    private static String SUB = "(\\m.\\n.n" + PRED + "m)";
    private static String TRUE = "(\\x.\\y.x)";
    private static String FALSE = "(\\x.\\y.y)";
    private static String AND = "(\\p.\\q.p q p)";
    private static String OR = "(\\p.\\q.p p q)";
    private static String NOT = "(\\p.\\a.\\b.p b a)";
    private static String IF = "(\\p.\\a.\\b.p a b)";
    private static String ISZERO = "(\\n.n(\\x." + FALSE + ")" + TRUE + ")";
    private static String LEQ = "(\\m.\\n." + ISZERO + "(" + SUB + "m n))";
    private static String EQ = "(\\m.\\n." + AND + "(" + LEQ + "m n)(" + LEQ + "n m))";
    private static String MAX = "(\\m.\\n." + IF + "(" + LEQ + " m n)n m)";
    private static String MIN = "(\\m.\\n." + IF + "(" + LEQ + " m n)m n)";

    private static String app(String func, String x) {
        return "(" + func + x + ")";
    }
    private static String app(String func, String x, String y) {
        return "(" + "(" + func + x + ")" + y + ")";
    }
    private static String app(String func, String cond, String x, String y) {
        return "(" + func + cond + x + y + ")";
    }

    private String[] sources = {
            ZERO,//0
            ONE,//1
            TWO,//2
            THREE,//3
            app(PLUS, ZERO, ONE),//4
            app(PLUS, TWO, THREE),//5
    };
    private void testLexer(int n) {
        Lexer lexer = new Lexer(sources[n]);
        while(lexer.nextToken()!=TokenType.EOF){
        }
    }
    @Before
    public void setUp() {
        lineBreak = System.getProperty("line.separator");
        console = System.out;
        bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
    }
    @After
    public void tearDown() {
        System.setOut(console);
    }
    @Test
    public void test0_ZERO_testLexer() {
        testLexer(0);
        assertEquals(
                "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "EOF" + lineBreak, bytes.toString());
    }
    @Test
    public void test1_SUCC_testLexer() {
        testLexer(1);
        assertEquals("LPAREN" + lineBreak +
                "LPAREN" + lineBreak +
                "LAMBDA" + lineBreak +
                "LCID" + lineBreak +
                "DOT" + lineBreak +
                "LAMBDA" + lineBreak +
                "LCID" + lineBreak +
                "DOT" + lineBreak +
                "LAMBDA" + lineBreak +
                "LCID" + lineBreak +
                "DOT" + lineBreak +
                "LCID" + lineBreak +
                "LPAREN" + lineBreak +
                "LCID" + lineBreak +
                "LCID" + lineBreak +
                "LCID" + lineBreak +
                "RPAREN" + lineBreak +
                "RPAREN" + lineBreak +
                "LPAREN" + lineBreak +
                "LAMBDA" + lineBreak +
                "LCID" + lineBreak +
                "DOT" + lineBreak +
                "LAMBDA" + lineBreak +
                "LCID" + lineBreak +
                "DOT" + lineBreak +
                "LCID" + lineBreak +
                "RPAREN" + lineBreak +
                "RPAREN" + lineBreak +
                "EOF" + lineBreak, bytes.toString());
    }
    @Test
    public void test2_SUCC_testLexer() {
        testLexer(2);
        assertEquals(
                "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "EOF" + lineBreak, bytes.toString());
    }
    @Test
    public void test3_SUCC_testLexer() {
        testLexer(3);
        assertEquals(
                "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "EOF" + lineBreak, bytes.toString());
    }
    @Test
    public void test4_PLUS_testLexer() {
        testLexer(4);
        assertEquals(
                "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "EOF" + lineBreak, bytes.toString());
    }
    @Test
    public void test5_PLUS_testLexer() {
        testLexer(5);
        assertEquals(
                "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "LPAREN" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LAMBDA" + lineBreak +
                        "LCID" + lineBreak +
                        "DOT" + lineBreak +
                        "LCID" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "RPAREN" + lineBreak +
                        "EOF" + lineBreak, bytes.toString());
    }
}
