# [Project Euler](https://projecteuler.net)

| Files        | Description           | 
| ------------- |-------------| 
| pX.txt      | Input files | 
| pX.java      | Solution code |
| Operations.java | Some helpful functions, some aren't used due to more efficient alternatives | 
| Pair.java | int pair class |  


### What is Project Euler?  
    A series of math problems intended to be solved with programs.


### What I learned...
    When iterating through a loop one hundred billion times, every optimization counts.
    
    Is there an algorithm that will get me the same answer in a fraction of the time?
    Is there potential for integer overflow?  
    Can I avoid the integer overflow without using long or BigInteger?
    Can I narrow down the solution space?
    Which condition should I check first?
    
##### Example:  
    Find all primes numbers between 1 and 1000000 that begin with 77.

    Brute Force: Loop through all numbers checking their two leftmost digits and if they are prime.
    
    Would it be faster converting the numbers to strings to get the first 2 digits, or performing a couple of math operations?
    Could you generate only numbers that begin with 77 and then check each for primeness?
    Could you generate primes numbers and then check if they start with 77?

    Answers:
      Strings are slow, we can determine the number of digits and then use division to get the first 2 digits.
      Checking individual numbers for primeness is slow.
      With a sieve, we can quickly generate all primes between 1 and 1000000.  Then we only need to check 78,498 numbers to see if they start with 77.
      
    The optimized version would finish in less than a minute, the brute force version (using strings) would take many hours, possibly days.
    
    
    
