import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    String lineBreak;
    String initInfo;
    String steps;

    static int index =0;
    static int sum = 0;
    static String ZERO = "(\\f.\\x.x)";
    static String SUCC = "(\\n.\\f.\\x.f (n f x))";
    static String ONE = app(SUCC, ZERO);
    static String TWO = app(SUCC, ONE);
    static String THREE = app(SUCC, TWO);
    static String FOUR = app(SUCC, THREE);
    static String FIVE = app(SUCC, FOUR);
    static String PLUS = "(\\m.\\n.((m " + SUCC + ") n))";
    static String POW = "(\\b.\\e.e b)";       // POW not ready
    static String PRED = "(\\n.\\f.\\x.n(\\g.\\h.h(g f))(\\u.x)(\\u.u))";
    static String SUB = "(\\m.\\n.n" + PRED + "m)";
    static String TRUE = "(\\x.\\y.x)";
    static String FALSE = "(\\x.\\y.y)";
    static String AND = "(\\p.\\q.p q p)";
    static String OR = "(\\p.\\q.p p q)";
    static String NOT = "(\\p.\\a.\\b.p b a)";
    static String IF = "(\\p.\\a.\\b.p a b)";
    static String ISZERO = "(\\n.n(\\x." + FALSE + ")" + TRUE + ")";
    static String LEQ = "(\\m.\\n." + ISZERO + "(" + SUB + "m n))";
    static String EQ = "(\\m.\\n." + AND + "(" + LEQ + "m n)(" + LEQ + "n m))";
    static String MAX = "(\\m.\\n." + IF + "(" + LEQ + " m n)n m)";
    static String MIN = "(\\m.\\n." + IF + "(" + LEQ + " m n)m n)";

    static String app(String func, String x) {
        return "(" + func + x + ")";
    }
    static String app(String func, String x, String y) {
        return "(" + "(" + func + x + ")" + y + ")";
    }
    static String app(String func, String cond, String x, String y) {
        return "(" + func + cond + x + y + ")";
    }

    String[] sources = {
            ZERO,//0
            ONE,//1
            TWO,//2
            THREE,//3
            app(PLUS, ZERO, ONE),//4
            app(PLUS, TWO, THREE),//5
    };
    public AST testParser(int n) {
        Lexer lexer = new Lexer(sources[n]);
        Parser parser = new Parser(lexer);
        return parser.parse();
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
    public void test0_ZERO_testParser() {
        AST ast = testParser(0);
        assertEquals("\\.\\.0", ast.toString());
    }
    @Test
    public void test1_SUCC_testParser() {
        AST ast = testParser(1);
        assertEquals("(\\.\\.\\.(1 ((2 1) 0)) \\.\\.0)", ast.toString());
    }
    @Test
    public void test2_SUCC_testParser() {
        AST ast = testParser(2);
        assertEquals("(\\.\\.\\.(1 ((2 1) 0)) (\\.\\.\\.(1 ((2 1) 0)) \\.\\.0))", ast.toString());
    }
    @Test
    public void test3_SUCC_testParser() {
        AST ast = testParser(3);
        assertEquals("(\\.\\.\\.(1 ((2 1) 0)) (\\.\\.\\.(1 ((2 1) 0)) (\\.\\.\\.(1 ((2 1) 0)) \\.\\.0)))", ast.toString());
    }
    @Test
    public void test4_PLUS_testParser() {
        AST ast = testParser(4);
        assertEquals("((\\.\\.((1 \\.\\.\\.(1 ((2 1) 0))) 0) \\.\\.0) (\\.\\.\\.(1 ((2 1) 0)) \\.\\.0))", ast.toString());
    }
    @Test
    public void test5_PLUS_testParser() {
        AST ast = testParser(5);
        assertEquals("((\\.\\.((1 \\.\\.\\.(1 ((2 1) 0))) 0) (\\.\\.\\.(1 ((2 1) 0)) (\\.\\.\\.(1 ((2 1) 0)) \\.\\.0))) (\\.\\.\\.(1 ((2 1) 0)) (\\.\\.\\.(1 ((2 1) 0)) (\\.\\.\\.(1 ((2 1) 0)) \\.\\.0))))", ast.toString());
    }
}
