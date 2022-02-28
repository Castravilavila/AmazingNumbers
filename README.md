# AmazingNumbers
 
This is a project that i made from JetBrains Academy, the program should process the user requests. In this stage, the program should:

Welcome users;
Display the instructions;
Ask for a request;
If a user enters an empty request, print the instructions;
If the user enters zero, terminate the program;
If numbers are not natural, print the error message;
If an incorrect property is specified, print the error message and the list of available properties;
For one number, print the properties of the number;
For two numbers, print the properties of all numbers in the list;
For two numbers and two properties, print the list of numbers that contain the specified properties;
If a property is preceded by a minus, this property should not be present in a number;
If the user specifies mutually exclusive properties, abort the request and warn the user.
Once the request is processed, continue execution from step 3.

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
