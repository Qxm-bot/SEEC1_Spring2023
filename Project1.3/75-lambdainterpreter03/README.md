## Lambda演算-作业III

### 实验要求

#### 要求概述

本次作业是Lambda演算的最后一次作业，要求是实现一个Lambda表达式的解释器。而解释器的作用即为对指定的Lambda表达式**求值**。即通过Lambda演算的规则进行字符串的代换，体现在当前的作业框架下即为从一个AST树按一定的规则变换成另一个AST树。

#### 作业要求

由于我们已经采用了De Bruijn index命名规范，本次作业中主要的操作为对一个Parser得到的抽象语法树(AST根节点)根据Lambda规则进行β 归约（即函数调用）的变换，并且在这个过程中保持表达式**仍遵循De Bruijn index规范**，相关的四个函数如下

```
//对根节点ast递归求值，返回求值后的根节点
private  AST evalAST(AST ast)；

//对一个Application类型的AST节点，使用节点value进行β归约的代换
private AST substitute(AST node,AST value)

//下面两个函数用于实现substitute函数
//用节点value替换一个lambda表达式根节点下特定深度的节点
private AST subst(AST node, AST value, int depth)；

//对一个节点node应用De Bruijn index值位移，内层深度为from，偏移量为by
private AST shift(int by, AST node,int from)；
```

### 实验指导

#### 主体方法

##### evalAST

term的定义与构造方式在实验II中已经介绍过，而**值（value）**即为在应用**某些求值规则**对terms变换的过程中得到的最终形式，即在它上面无法在应用类似的规则。

而evalAST函数根据当前节点与其子节点类型的讨论递归地做出求值的动作，并对AST的结构进行更改，返回求值后的AST根节点，**而测试中会与作业II相同的方式检查AST的结构是否正确**。

实际的求值规则如下：

1. t1 -> t1'

   t1 t2 -> t1' t2

2. t2 -> t2'

   v1 t2 -> v1 t2'

3. (\x. t12) v2 -> [x -> v2]t12

对规则做出如下解读：

1.如果项 t1的值为t1' ， 一个application {t1 t2} 被求值为 t1' t2；即**一个 application 的左侧先被求值**。

2.如果项 t2的值为t2'， 一个application {v1 t2}求值为 v1 t2'。注意这里左侧的是 value，不能再一步被求值，即只有**左侧是值的情况下，才会对右侧求值**。

3.对一个application {(\x. t12) v2} （它的lhs左子树是一个抽象，rhs右子树是一个已经是value的AST节点）求值时，和 t12 中出现的所有 x 被有效替换之后是一样的（**β 归约**）。

所以evalAST方法可以参考以下的思路实现：

- 1.对于一个Application节点，如果lhs是值，对rhs求值

  ```
  ((Application) ast).rhs = evalAST(((Application) ast).rhs);
  ```

  2.如果lhs是一个Abstraction，我们可以对它应用规则3，即先对其rhs求值，再调用substitute方法实现。（**注意，这一代换后无法保证当前的lambda表达式是value**）

  3.**如不是以上两点，只对左侧求值**。

- 对一个Abstraction节点，只需对它的body求值。

- 如果没有对应的规则，则整个语法树已经完成求值，返回新语法树的根节点即可。

##### substitute

以下给出了该方法的一个实现

```
	private AST substitute(AST node,AST value){
        return shift(-1,subst(node,shift(1,value,0),0),0);
    }
```

分为三步：**对value节点**进行De Bruijn index变换（使之在变换后仍满足这个规范）；把value节点代换到node节点的body中**深度为0的变量**；**对变换后的表达式**去除对应的 ”\\.“ 

##### shift

对给定的AST节点，对语法树中**深度大于等于from**（即De Bruijn index value）的Identifier，进行偏移量为by的De Bruijn index值偏移，返回替换后语法树的根节点

1. 对于Application节点，对lhs与rhs分别地递归进行这一过程
2. 对于Abstraction节点，对它的body递归地进行偏移
3. 对于**深度大于等于from**的Identifier节点，将该节点的value设置为value+by作为偏移

##### subst

对给定的AST节点node，使用AST节点value替换De Bruijn index值等于**depth**的identifier，**返回替换后语法树的根节点**。

1. 对于Application节点，对lhs与rhs分别地递归进行这一过程

2. 对于Abstraction节点，对它的body进行替换，但在递归的过程中需要注意：

   对Abstraction { \\.body } 替换depth为0的节点等价于对body替换depth为1的节点 ，以此类推
   
3. 对于Identifier节点，首先需要判断它是否是需要替换的节点，如果是则进行替换（即返回处理后的value节点）。**注意：value节点在替换后需要在新的语法树中符合De Bruijn index规范，即需要对它做shift操作。**

   由于代入替换的是**深度=depth**的变量，对节点value来说需要修正其所有的De Bruijn index值，相当于value中所有变量的深度增加了depth层。

   因此在插入value节点前，需要先对它使用shift做如下操作，才能满足插入后符合规范。

   ```
   shift(depth, value, 0)
   ```

