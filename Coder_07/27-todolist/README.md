python
To Do List

待办完成事项清单

> 编写一个命令行的待完成事项清单程序，用户按照格式输入命令，程序需要解析用户输入的命令，并完成相应的操作。
> 
> 待办事项状态有两个状态：todo，表示待办；completed，表示已完成。命令和待办事项都为英文单词组成，单个待办事项为短语，不包含标点符号，首尾没有空格。
> 
> 用户输入的命令和内容满足下列要求。

1. todo -a "todo item1" "todo item2"
	
	表示增加(add)待办事项，待办事项可以为1个或多个，单个事项用双引号(英文)括起来，事项之间以空格分隔。
	用户输入该命令后，程序应将待办事项保存到持久性位置（文件）。
	存储时一行表示一个待办事项，格式为"状态:待办事项"，状态包括todo和completed，待办事项就是上面的todo item1和todo item2。

2. todo -d "todo item1"

	删除(delete)待办事项，待办事项可以为1个或多个，单个事项用双引号(英文)括起来，事项之间以空格分隔。
	用户输入该命令后，程序应从所有任务中删去该任务，并同步到文件。

3. todo -c "todo item1" "todo item2"

	修改待办事项为已完成(complete)，待办事项可以为1个或多个，单个事项用双引号(英文)括起来，事项之间以空格分隔。
	用户输入该命令后，程序应将这些任务的状态标记为已完成，并同步到文件。

4. todo -f status

	查询(find)待办事项。status表示事项状态，可以是todo或completed。用户输入该命令后，程序应查询出指定状态的待办事项，并向控制台输出。
	要求一行输出一个任务，并按照添加时的相对顺序输出，即先添加的输出在前（注：多个待办事项以一个命令添加的，位置靠前的是先添加的）。
	
5. todo -all
    
    查询所有待办事项。用户输入该命令后，程序应查询出所有的待办事项，并向控制台输出。
    要求一行输出一个任务，并按照添加时的相对顺序输出，即先添加的输出在前（注：多个待办事项以一个命令添加的，位置靠前的是先添加的）。

6. todo -quit

    停止接收输入，结束方法，不要使用sys.exit()命令


程序操作过程分为：从控制台读取命令->解析命令->调用对应函数处理命令。


示例1：

	1. 增加待办事项：
	输入：
	todo -a "complete homework" "do handwriting" "go shopping" "read books" "visit grandparents" "participate the interview"
	此时文件中保存内容如下：
	todo:complete homework
	todo:do handwriting
	todo:go shopping
	todo:read books
	todo:visit grandparents
	todo:participate the interview
	2. 删除待办事项：
	输入：
	todo -d "go shopping"
	此时文件中保存内容如下：
	todo:complete homework
	todo:do handwriting
	todo:read books
	todo:visit grandparents
	todo:participate the interview
	3. 修改待办事项为已完成：
	输入：
	todo -c "complete homework" "participate the interview" "read books"
	此时文件中保存内容如下：
	completed:complete homework
	todo:do handwriting
	completed:read books
	todo:visit grandparents
	completed:participate the interview
	4. 查询待办事项：
	输入：
	todo -f todo
	输出：
	todo:do handwriting
	todo:visit grandparents
	5. 查询已完成事项：
	输入：
	todo -f completed
	输出：
	completed:complete homework
	completed:read books
	completed:participate the interview
	6. 查询所有事项
	输入：
	todo -all
	输出：
	completed:complete homework
	todo:do handwriting
	completed:read books
	todo:visit grandparents
	completed:participate the interview

存储的文件名为tasks.txt，存储路径为ToDoList根目录，存储的文件路径已经设置在file变量中，不可修改文件名及路径
请严格按照示例规范输出，不可修改方法名称、参数以及文件名,可以添加自己的方法