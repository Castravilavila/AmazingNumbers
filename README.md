# AmazingNumbers
 
This is a project that i made as a task from JetBrains Academy, the program should process the user requests and indicate the properties of the numbers taken from the input. In this stage, the program should:

1) Welcome users;
2) Display the instructions;
3) Ask for a request;
4) If a user enters an empty request, print the instructions;
5) If the user enters zero, terminate the program;
6) If numbers are not natural, print the error message;
7) If an incorrect property is specified, print the error message and the list of available properties;
8) For one number, print the properties of the number;
9) For two numbers, print the properties of all numbers in the list;
10) For two numbers and two properties, print the list of numbers that contain the specified properties;
11) If a property is preceded by a minus, this property should not be present in a number;
12) If the user specifies mutually exclusive properties, abort the request and warn the user.
13) Once the request is processed, continue execution from step 3.

In this stage, property names include even, odd, buzz, duck, palindromic, gapful, spy, sunny, square, jumping, sad, and happy. Mutually exclusive properties are even/odd, duck/spy, sunny/square, sad/happy pairs, as well as direct opposites (property and -property). You may format numbers as you like.

# Supported requests:
- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
  * the first parameter represents a starting number;
  * the second parameter shows how many consecutive numbers are to be printed;
- two natural numbers and properties to search for;
- a property preceded by minus must not be present in numbers;
- separate the parameters with one space;
- enter 0 to exit.
