import java.util.ArrayList;

public class Abstraction extends AST {
    Identifier param;//变量
    AST body;//表达式
    Abstraction(Identifier p, AST b){
        param = p;
        body = b;
    }
    public String toString(){
        return "\\"+"."+body.toString();
    }
    @Override
    public boolean equals(AST ast) {
        if (ast instanceof Abstraction) {
            if (this.body.equals(((Abstraction) ast).body))
                return true;
            else
                return false;
        }else
            return false;
    }
}
