
.data
  msg: .asciz "Hello, RARS!\n" 
.text
.globl main
main: 
   #Task1

  #la a0,msg
  #li a7,4
  #ecall
  #li a7,10
  #ecall
  
    #Task2
  #li a7,5
  #ecall
  
  #add t0,a0,zero
  
  #li a7,5
  #ecall
  
  #add a0,t0,a0
  
  #li a7,1
  #ecall
  
    #Task 3
  #li a7,5
  #ecall 
  #bgez a0,end
  
  #add t0, a0,zero
  
  #sub a0,zero,t0	
  #end:
   
  #li a7,1
  #ecall
  
    #Task 4
  #li a7,5
  #ecall 
  #li t1,1
  #li t2,0
  
  #loop:
  #bgt t1,a0,end
  #add t2,t2,t1
  #add t1,t1,1
  #j loop
  
  #end:
  #add a0,t2,zero
  #li a7,1
  #ecall
  
  #Practice 
  li a7,5
  ecall
  
  bgtz a0,great
  bltz a0,less
  
  li,a0,0
  j print
  
  great:
    li,a0,1
    j print
    
  less:
     li,a0,-1
  
  print:
     li a7,1
     ecall
     
  #Odd or Even
  li a7,5
  ecall
  li t1,2
  rem t0,a0,t1
  beqz t0,even
  bnez t0,odd
  
  odd:
  li a0,1
  j print
  
  even:
   li a0,2
  print:
   li a7,1
   ecall
  
  
  #Max of two nums 
  li a7,5
  ecall
  add t0,a0,zero
  
  li a7,5
  ecall
  add t1,a0,zero
  
  bgt t0,t1,first
  
  mv a0,t1
  j print
  
  first:
  mv a0,t0
  j print
  
  print:
  li a7,1
  ecall


  #Print N elements
  li a7,5
  ecall 
  add t0,a0,zero
  
  li t1,1
  loop:
    bgt t0,t1,exit
    
    