

public class Identifier extends AST {
    String name; //名字
    String value;//De Bruijn index值
    public Identifier(String n,String v){
        name = n;
        value = v;
    }
    public String toString(){
        return value;
    }

    public boolean equals(AST ast){
        if(ast instanceof Identifier) {
            if (this.value.equals(((Identifier) ast).value))
                return true;
            else
                return false;
        }else
            return false;
    }
}
