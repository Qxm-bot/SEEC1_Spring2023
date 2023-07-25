python
locate car problem

##编写一个程序，通过一系列的问题引导用户定位汽车存在的问题。
具体流程请参考problem.png

示例输出：
Is the car silent when you turn the key? y
Are the battery terminals corroded? y
Clean terminals and try starting again.

Is the car silent when you turn the key? n
Dose the car make a clicking noise? n
Does the car crank up but fail to start? n
Does the engine start and then die? y
Does your car have fuel injection? y
Get it in for service.

Does the engine start and then die?虽然只有一个分支，也必须要接受输入
在过程中，只问与当前状况和前面答案相关的问题。不要一下子让用户输入所有信息。
请严格按照示例规范输出，不可修改方法名称、参数以及文件名