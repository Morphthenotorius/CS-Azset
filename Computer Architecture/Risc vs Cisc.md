# Differences between Risc and Cisc
## Introduction
While building CPU we have to declare that what kind of instructions our CPU going to execute. Some of the CPU's runs only basic instructions such as addition, subtraction, storing ,loading, and etc. but on the other hand some kind of CPU's except these basic instructions they can execute more and more complex instructions in addition. At that point we have to decide that what kind of CPU we are going to build. For example if we want to design a CPU which will work only for small devices then we dont need to use these expanded instructions. In that case this is a situation which Risc **(Reduced Instruction Set Computer)** and Cisc **(Complex Instruction Set Computer)** occurs .They are like different design approaches for CPU in this documentation I will explain the differences between them but first we need to take a look at what ISA **(Instruction set architecture)** actually is, because at the end of the day both of them are ISA's.

## What is Instruction Set Architecture
First of all if we want to command to computer's hardware we have to speak its language .Because computer does not understand human language, so ISA is a language that tells CPU which operations it can perform, moreover it's just a kind of interface which contains registers, operations, data types ,interrupt level and system-level communication. Basically it shows that what CPU capable of. Which instructions CPU can perform, how many, and which registers does it contain and etc. By the way ISA is kind of interface which runs between software level and hardware level. 

* **Source code / script**
  ↓
* **Interpreter / VM**
  ↓
* **Compiler**
  ↓
* **ISA (assembly / binary interface)**
  ↓
* **Binary representation**
  ↓
* **Von Neumann layer**
  ↓
* **Microarchitecture**

As we can see ISA comes after compiler which means that whenever compiler separates source code into blocks, so it takes these divided codes and starts to convert it to assembly instructions, and then assembly instructions are going to be translated into machine level, but at that point if we didn't have ISA then we wouldn't be able to convert these codes into assembly, because our assembly instruction comes from ISA. For example lets imagine that you are trying to calculate some math problem, without any instruction math makes no sense, because all of the numbers given to you would just be random values without operations like addition, subtraction, or multiplication. Similarly, in a computer, without the ISA defining what each code means and what operations the CPU can do, the binary data or assembly code would just be meaningless numbers that the hardware cannot execute. So that's the point which we can't imagine any computer without ISA.

### Other examples why the ISA is special
* **ISA is the layer which directly visible to programmers**
* **Layers below can be replaced without touching high level software**
* **Layers above can change without touching hardware**

### Other ISAs 
As we already mentioned we cannot imagine any computer without ISA because without ISA neither instructions nor registers make sense. Therefore every device which have brain (CPU) these kind of devices must contain ISA. Due to that we have many other ISAs beside RISC and CISC such as **Stack machine** which works with 0 address principle which means this ISA doesn't take any arguments for ALU (Arithmetic Logic Unit) operations. Also we have Accumulator based ISA **(1 Address)**, VLIW **(Very long instruction word)**
