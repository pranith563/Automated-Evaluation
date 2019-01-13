#Automated TestCase Generator

Basic python script that looks for Scanner class functions (nextInt,  nextFloat, etc...) and uses a random generator function to create testcases.  

 Since there are additional constraints in the problem statements, we have modified the random function to output numbers that heavily favors the constraints (For eg: positive numbers by making random generator for *INT *between 0 to 2^31).

We have written a reference solutions that takes care of the other constraints in input, like the ordering of numbers, greater, lesser etc... by using assert statements in the code appropriately 