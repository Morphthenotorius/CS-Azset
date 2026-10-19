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
As we already mentioned we cannot imagine any computer without ISA because without ISA neither instructions nor registers make sense. Therefore every device which have brain (CPU) these kind of devices must contain ISA. Due to that we have many other ISAs beside RISC and CISC such as **Stack machine** which works with 0 address principle which means this ISA doesn't take any arguments for ALU (Arithmetic Logic Unit) operations. Also we have Accumulator based ISA **(1 Address)**, VLIW **(Very long instruction word)** and we have many other ISAs which I wont clarify in this document, but I will cover two most popular, and most used ISAs. 

## What is RISC V (Reduced Instruction Set Computer) 
Reduced Instruction Set computer as known as **RISC V** is a approach to processor design. It's like a template which used while creating CPU. RISC V basically used for designing small, simple devices such as smartphones, embedded systems, smartwatches and etc. As you can see most of these devices was built for long battery life which means all of these devices' main idea is keeping screen alive with saving battery as much as possible. Due to that RISC has so many differences compared to many other ISAs. First off all RISC runs small set of simple instructions, which means each instruction performs basic operation such as loading, computing, storing. Other characteristic is RISC only uses fixed-length instructions therefore each operation must be 32 bit length otherwise **Illegal Instruction Exception** or **Instruction Address Misaligned Exception** will be thrown at hardware level. Actually devices which based on RISC architecture are most of the time use fixed-length instruction. There is no specific rule which states that every device which of uses RISC architecture must use fixed-length instructions it is possible to have variable-length instructions on RISC based devices as well, but RISC user devices always use fixed-length instructions because of it's very easy to decode and very power efficient. Let me explain why fixed-length instructions are most of the time fast and power efficient. First in fixed-length CPU always know that upcoming operations will always be 32 bit length in RISC. Due to that CPU doesn't spend time to figure out what upcoming instruction actually is because those last 7 bits always represent opcodes that's why we don't need any extra steps to figure out upcoming instructions. On the other hand we have pipelining speed which most of the time faster than CISC's (Vanilla) pipeline speed. The reason is fixed-length instructions always pass through processor's pipeline in the exact time interval, so processor doesn't spend much time these **Fetch, Decode, Execute, Memory, Writeback** steps more clearly, processor goes through these pipeline steps faster, and sequentially .
