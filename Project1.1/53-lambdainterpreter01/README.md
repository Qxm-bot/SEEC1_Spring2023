## Lambda演算-作业I

### 实验背景

#### Lambda演算介绍

以下是lambda演算的一个定义

> Lambda calculus (also written as λ-calculus) is a formal system in mathematical logic for expressing computation based on function abstraction and application using variable binding and substitution.

解释一些这个定义中的名词：

​	formal system：形式系统，指其中有公理又承认推理方法（规则）的体系，在其中我们可以使用规则从公理中推出定理。因此lambda演算类似一个数学模型，它最初的目的并非关注解的具体实现，而是强调变换规则的使用。

​	function abstraction and application：抽象与应用，即lambda演算的组成元素，abstraction对应匿名函数的定义，application对应匿名函数的调用，一个合法的lambda表达式由abstraction与application以相应的规则组织而成，在作业II的语法解析中会得到更深入的了解。

​	variable binding：描述lambda表达式的定义

​	substitution：描述lambda表达式的变换（化简）方式，lambda演算所做的只是对一个字符串按规则进行解析与推导，如α变换与β归约。

​	lambda演算与[图灵机](https://en.wikipedia.org/wiki/Turing_machine)的表达能力等价。这两个数学模型分别从不同的角度给出了判定性问题的否定，lambda演算通过提出两个lambda表达式是否等价的问题进行否定，而图灵机通过“停机问题”否定。它们为可计算性、可判定性等领域提供理论支持。

#### Lambda演算与函数式编程

> 通过图灵机描述的可计算性，引出了命令式编程。通过λ演算描述的可计算性，引出了函数式编程 
>
>  -- Cooper & Leeuwen（2013）

​	除了理论领域，lambda演算的思想也在工程领域促进了函数式编程的发展。

##### 为何需要函数式编程？

​	一方面，函数式编程具有简洁性与优秀的表达能力，如对于一些简单、调用次数较少的函数，我们可以不必独立地进行定义。

​	另一方面，函数式编程可以减少系统中的非纯函数（非纯函数指在调用中可能受当前上下文影响或对上下文产生影响的函数），提高可测试性与可维护性。

##### 函数式编程的应用

​	如java中回调函数与流（Stream）处理，JavaScript的闭包等，支持匿名函数特性的编程语言中都可以看到lambda演算的思想。

### 实验要求

#### 解析Lambda表达式

​	整个实验达成的效果为：对一个符合lambda演算规范的字符串，需要编写能够对它进行自动推导、求值的程序，为了实现这一点，我们需要对它进行词法分析（lexer）、语法分析（parser）与解释求值（interpret）几个步骤。

​	词法分析的目标是将**字符序列按既定的规则转化成token序列**

​	语法分析的目标是将**token序列按既定的规则建模为抽象语法树（AST）**，抽象语法树相比token序列包含了更多的信息，抽象语法树可以表示一种依赖关系，如树中某个节点的信息依赖它的子节点的信息，也就是说：子节点的信息应该先于父节点被计算，比如用于表示算术优先级。

​	以上是进行语法上的检查与解析，而interpreter从语义上进行计算，如**替换求值**这一操作。

#### 本次实验：实现Lexer，并阅读理解AST中的元素

实验I中，只需要根据以下的词法规则，实现Lexer类中的nextToken()方法，成功解析字符串的tokentype序列即可。

```
public enum TokenType {
	 //注意：输入中的所有空格应该忽略
     EOF,//标识lambda表达式的结束
     LAMBDA,// '\',即lambda表达式中的lambda，注意转义
     LPAREN,// 左括号
     RPAREN,// 右括号
     LCID,// 标识符，要求小写字母开头，大写或小写字母组成
     DOT// lambda表达式中的'.'
}
```

​	Lexer类的构造函数需要接收一个待解析的String类型lambda表达式，该类的构造函数与成员变量均可自行设计，只要保证nextToken()方法输出指定的结果即可。

​	nextToken()方法需要解析出字符串表达式的未解析的下一个token，**需要换行打印**并返回解析出的TokenType，测试中会检查输出的TokenType序列是否正确。

比如：

```java
String ZERO = "(\\f.\\x.x)";
```

​	此时第一个未解析的字符是"("，它需要被解析为LPAREN，输出出来。

​	需要注意的是，lexer被parser调用时，对于LCID类型的token，不仅需要得到待解析token的类型，还需要得到待解析token的内容，这点并不影响实验I的实现，但在设计时可能需要考虑这点。

​	除了nextToken()方法外，在Lexer类中还提供了三个待实现的工具方法next(),match()与return()，在接下来的实验中提供给parser调用，请自行阅读注解，**本次作业可以酌情实现**

**编写建议**

```java
public class Lexer{
    public TokenType token;
    public String tokenvalue;
    //........
   }
```

​	大家可以在类内定义自己觉得需要的成员变量，**例如token与tokenvalue，来记录当前符合词法的元素的类型与字符串值**，以便本次以及后续的实验。

#### 阅读理解ATS中元素

​	代码框架中提供了一些类与成员方法，请自行阅读理解。
​	lambda 演算的 AST 较为简单，因为我们只有 3 种节点： Abstraction （抽象）， Application （应用）以及 Identifier （标识符），鼓励大家自行上网阅读lambda演算的语法规则，以便下一次parser的任务能够更容易上手。

#### 测试

​	本次实验只会检查大家nextToken()方法的正确性。

​	本地提供若干测试帮助检查代码的正确性，也提供了部分基础的lambda表达式，包括自然数与逻辑值的定义，以及一些函数的定义，可以使用提供的app()拼接这些lambda表达式，从而以它们为基础构造新的新的测试用例。

```
	static String ZERO = "(\\f.\\x.x)";
    static String SUCC = "(\\n.\\f.\\x.f (n f x))";
    static String ONE = app(SUCC, ZERO);
    static String PLUS = "(\\m.\\n.((m " + SUCC + ") n))";
    ...
    app(PLUS, ZERO, ONE);//构造新的符合lambda表达式规则的字符串
```

### 提醒

​	本次实验中为整个解释器的一个模块，没给出main方法，在测试时会直接调用同学们的nextToken()方法，同学们在进行自测的时候可以随意添加main方法，不会影响实际测试。

