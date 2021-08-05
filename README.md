# 多功能计算器

* 此代码是作者出于兴趣爱好自己编写的。转载请注明。

* 作者的邮箱：contactwangpai@163.com

---

分支 M # 最新版本 ` M.1.2 ` 支持的功能：（以用户的角度）

1. 操作数支持多位运算。一个操作数可以是十位数或者更高位数的数
2. 操作数支持小数点、负数，运算结果支持显示小数、负数
3. 表达式可以含多个操作数、多个运算符，还可以带括号
4. 对输入的表达式提供实时自动语法检查与错误定位，并支持检查后的修改
5. 对输入无误的表达式进行实时自动计算，并可选显示完整详细的计算过程。
6. 使用 GUI 界面来显示上面的表达式输入、报错显示、运算过程
7. 提供界面按钮以供输入，按钮包含文本全选、光标左移与右移，选中文本的删除、输入替换
8. 支持键盘输入

---

<br/>

# 本次更新介绍

<p align="right">——2021年8月5日</p>

代码介绍：

&emsp;&emsp;本工程是在 `20210801-多功能计算器` 的基础之上进行的升级。由于即将推出下一个版本，因此本版本的介绍从略。另外，本版本也有一些未解决的问题，这些问题将在下一版本进行解决或指出。

&emsp;&emsp;相对于 ` M.1.1 `，本版本 ` M.1.2 ` 的改进主要有：

* 提供了文本全选按钮
* 提供了对选中文本的删除、输入替换
* 解除操作数之间的继承关系，去掉了运算类中的反射代码
* 优化了表达式解析的一些代码与设计



&emsp;&emsp;可供未来版本实现的功能：

* 提供文本的清空、复制、剪切、粘贴按钮
* 提供文本的撤销和恢复快捷键



* 笔者使用的开发工具：IntelliJ IDEA 2020.1.2 (Ultimate Edition)



* 核心 Java 语言代码文件：

* 程序测试启动入口 API：

  类 CalculatorFrame_Test 的方法 main：

  - 位于模块 calculator 的文件夹 Test
  - 包名：org.wangpai.calculator.view



* Java 代码：
  - 总的代码行数为：6004
  - 单元测试代码行数为：1667

> 8+34+29+31+106+279+8+102+156+160+233+185+34+267+284+191+260+91+665+53+143+61+357+84+87+28+234+76+63+47+89+123+24+182+288+157+103+13+34+36+38+20+34+25+61+35+31+33+31+31+63+37+40+39+40+41=6004
>
> 76+63+47+89+123+24+182+288+157+183+13+34+36+38+20+34+63+37+40+39+40+41=1667



* 程序屏幕输入示例：`2334.623*6345-234/1234+234*(254-45.242)=`



* 一个屏幕输出结果的片段：

---

![](F:\MyGithubCodes\calculator_Java\img_md\20210804_1.png)

---

![](F:\MyGithubCodes\calculator_Java\img_md\20210804_2.png)

---
