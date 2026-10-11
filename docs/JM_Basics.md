1. What is JDK, JRE, JVM?

JDK - Known as Java Development Kit and contains the required toolkit or packages that needed to compile debug,etc. It also contains the JRE packed inside it. 

JRE - Known as Java Runtime Environment, and it contains the core libraries necessary for program execution and JVM. 

JVM - Known as Java Virtual Machine, and is the brain where the program execution happens. The execution area is packed inside JVM and it contains JIT Compiler and Interpretor packed in it.
The Heap Memory, Stack Memory and the Method area are packed in JVM. 

JDK is responsible for compiling a .java program as it contains the toolkit for compilation. 
JRE contains the core libraries required and JVM is where the program execution happens, that is the bytecode is executed to get the output. 

---------------------------------------------------------------------------------------------------

2. What is bytecode?

When a Java program is compiled, the intermediate class file generated for execution is referred to as the byte code. 
It is platform independent and can be executed accross different OS. 

---------------------------------------------------------------------------------------------------

3. What does “write once, run anywhere” mean?

Write Once Run Anywhere principle indicates platform independent codes. 
When a java program is compiled it is not converted into a machine code (eg Windows based format like .exe or Linux based like binary), instead it is converted to bytecode format (.class), which is platform independent and can be executed across different OS machines. 

A Java code follows WORA principle which is compiled once and executed across multiple OS machines. 

---------------------------------------------------------------------------------------------------

