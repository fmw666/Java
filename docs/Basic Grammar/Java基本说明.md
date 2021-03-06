<div align="center">
     Java基本说明 / <a href="">数据类型</a> / <a href="">运算符</a> / <a href="">条件语句</a> / <a href="">循环语句</a> / <a href="">数组</a>
</div>

<br>
<div align="right">
    <a href="README.md">返回目录⤴</a>
</div>
<br>

+ **[💬 Java 的基本介绍](#-java-的基本介绍)**

+ **[💬 JDK 下载](#-jdk-下载)**

+ **[💬 JDK 剖析](#-jdk-剖析)**

+ **[💬 Java 环境变量配置](#-java-环境变量配置)**

+ **[💬 常见 Java 开发环境](#-常见-java-开发环境)**

+ **[💬 Eclipse 下载地址](#-eclipse-下载地址)**

+ **[💬 Java 程序开发步骤](#-java-程序开发步骤)**

+ **[💬 Java 注释](#-java-注释)**

+ **[💬 Java 文档注释](#-java-文档注释)**

---

## 💬 Java 的基本介绍

+ ### Java 分为三个体系  
 &emsp;&emsp;**JavaSE** (Java Platform Standard Edition，java平台标准版)<br>
 &emsp;&emsp;**JavaEE** (Java Platform Enterprise Edition，java平台企业版)<br>
 &emsp;&emsp;**JavaME** (Java Platform Micro Edition，java平台微型版)

&emsp;&emsp;简单解释来说：Java SE 是做电脑上的运行软件；Java EE 是做网站的；Java ME 是做手机软件的。

Java程序->Java字节码(中间)->JVM-in-Windows/Unix/Macintosh
JVM(Java Virtual Machine虚拟机)
</br>编译时： .java->.class

+ ### 什么是 JRE 和 JDK？

&emsp;&emsp;**JRE：**(Java Runtime Envioment——Java运行环境)。所有的Java程序都要在JRE下才能运行。它包括了JVM和JAVA核心类库等。

&emsp;&emsp;**JDK:** (Java Development Kit——Java开发工具包)。它是整个Java的核心。包括了Java运行环境、Java开发工具(javac、java、javadoc等和Java基础类库)

> **总结：** 与 JDK 相比，JRE它不包含开发工具、编译器、调试器和其他工具。开发java程序就安装jdk，运行java程序安装JRE即可。

<div align="right">
     <a href="#">返回顶部 ↑</a>
</div>

## 💬 JDK 下载

> 官方地址：www.oracle.com  &ensp;或&ensp;  www.sun.com

## 💬 JDK 剖析

+ **bin：** JDK包含的一些开发工具执行文件
+ **db:** 一个开源的Java开发的关系数据库Derby
+ **include：** C语言头文件
+ **jre:** Java运行环境(JRE)的根目录
+ **lib:** Java开发工具要用的一些库文件(非核心类库tools.jar、dt.jar等)
+ **src.zip:** 归档的Java源代码

## 💬 Java环境变量配置

+ **安装完JDK后配置环境变量** 
+ 计算机→属性→高级系统设置→高级→环境变量
+ 系统变量→寻找Path变量→编辑→新建&emsp;&emsp;粘贴jdk的bin目录路径

## 💬 常见Java开发环境

+ **文本编辑器：** notepad、EditPlus、UltraEdit
+ **集成开发环境(IDE):** Eclipse、JBuilder、NetBeans

## 💬 Eclipse下载地址

> &ensp; www.eclipse.org

## 💬 Java程序开发步骤：

+ 通过文本编辑器来编写java代码至扩展名为java的文件中。
+ 调用编译工具javac.exe来对java源文件进行编译，生成扩展名为class的字节码文件(中间语言)
+ 调用运行工具java.exe来对编译好的字节码文件进行解释执行(JVM)。

     ```java
     public class MyFirstJava{
          public static void main(String[] args){
               System.out.print("Hello World!");
          }
     }
     ``` 

## 💬 Java注释

+ **单行注释**
     ```java
     //这是单行注释
     ```
+ **多行注释** 
     ```java
     /*这是多行注释*/

     /*所以，
     当然可以多行~*/
     ```
+ **文档注释**

     ```Java
     /**
     * Description:这是我的第一个Java程序
     * Author:范茂伟
     * Create Date:2018-9-27
     * Modified Date:2018-9-27
     * Modified By:fmw
     */
     public class MyFirstJava{
          /**
          *Description:这是程序的入口点
          *参数:字符串数组
          */
          public static void main(String []args){
               //打印输出到控制台
               System.out.println("Hello World");
               System.out.print("hello world\n");
               //System.out.println("hello wor\tld");
          }
          /**
          *Description:显示输出个人的信息
          *@return String 姓名
          *@param content 个人资料
          *
          */
          public String toString(String content){
          
               return content;
          }
     }
     ```

## 💬 Java文档注释

+ **JavaDoc命令**  
     + 从程序源代码中抽取文档注释形成一个和源代码配套的API帮助文档在编写程序时以文档标签作注释，
在程序编写完成后，通过Javadoc可以自动生成程序的开发文档。    
+ **简单使用命令：**
     + javadoc -d 生成目标路径 源文件&ensp;&ensp;&ensp;&ensp;(比如：```javadoc -d doc MyFirstJava.java```)  
+ （进入doc文件夹，打开index.html即可查看生成的API文档，由于注释文档是生成的html文件，所以需要换行则在代码文档注释中添加```<br/>```即可）

<br>
<div align="right">
     <a href="#-章节1">返回顶部 ⬆</a>
<div>
<div align="center">
     - 完 -
</div>