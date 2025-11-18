// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
        int result = x1;
        if (x2 > 0) {
            for (int i = 0; i < x2; i++) {
                result++;
            }
        }
        else if (x2 < 0) {
            for (int i = 0; i > x2; i--) {
                result--;
            }
        }
        return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
        int result = x1;
        if (x2 > 0) {
            for (int i = 0; i < x2; i++) {
                result--;
            }
        }
        else if (x2 < 0) {
            for (int i = 0; i > x2; i--) {
                result++;
            }
        }
        return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int result = 0;
        if (x2 > 0) {
            for (int i = 0; i < x2; i++) {
                result = plus(result, x1);
            }
        }
        else if (x2 < 0) {
            for (int i = 0; i > x2; i--) {
                result = minus(result, x1);
            }
        }
        return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
            return 1;
        }
        int result = x;
        for (int i = 1; i < n; i++) {
            result = times(result, x);
        }
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
        int absoluteX1 = x1;
        int absoluteX2 = x2;
        if (x1 < 0) {
            absoluteX1 = minus(0, x1);
        }
        if (x2 < 0) {
            absoluteX2 = minus(0, x2);
        }
        // find how many times does absolute value of x2 fit in x1.
        // The amount of times is the div value.
        // If only one of x1 and x2 is a minus, then the result is 0 minus the div value from before.
        int divResult = 0;
        int absoluteSum = 0;
        while (plus(absoluteSum, absoluteX2) <= absoluteX1) {
            absoluteSum = plus(absoluteSum, absoluteX2);
            divResult++;
        }

        if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
            return minus(0, divResult);
        }
		return divResult;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        int divResult = div(x1, x2);
        int divResultTimesX2 = times(divResult, x2);
        return minus(x1, divResultTimesX2);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Unimplemented for imaginary numbers.
        if (x < 0) {
            return 0;
        }
        int count = 0;
        // Brute force until we find a number that is equal or bigger that times itself equals x.
        // We decrement it by 1 since the count is one too far.
        while (times(count, count) <= x) {
            count++;
        }
        return minus(count, 1);
	}	  	  
}