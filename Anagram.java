/** Functions for checking if a given string is an anagram. */
public class Anagram {
    public static final int CAPITAL_TO_LOWER_CHAR_DELTA = 32;
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
        int[] lettersArray = new int[('z' - 'a')];
        String processedStr1 = preProcess(str1);
        String processedStr2 = preProcess(str2);

        if (processedStr1.length() != processedStr2.length()) {
            return false;
        }

        for (int i = 0; i < processedStr1.length(); i++) {
            char currentChar = processedStr1.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                lettersArray[currentChar - 'a']++;
            }
        }
        for (int i = 0; i < processedStr2.length(); i++) {
            char currentChar = processedStr2.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                lettersArray[currentChar - 'a']--;
            }

        }

        for (int i = 0; i < lettersArray.length; i++) {
            if ((lettersArray[i]) != 0) {
                return false;
            }
        }
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
        // NOTE: I'm aware that the comment for the function isn't correct, we delete all characters which aren't from a to z.
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                newStr = newStr + ((char)(currentChar + CAPITAL_TO_LOWER_CHAR_DELTA));
            }
            else if ((currentChar >= 'a' && currentChar <= 'z')) {
                newStr = newStr + currentChar;
            }
        }
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
        String tempStr = str;
        String outStr = "";

        while(tempStr.length() > 0) {
            int randomIndex = (int)(Math.random() * (tempStr.length()));
            char randomChar = tempStr.charAt(randomIndex);
            outStr += randomChar;
            tempStr = tempStr.substring(0, randomIndex) + tempStr.substring(randomIndex + 1);

        }
		return outStr;
	}
}
