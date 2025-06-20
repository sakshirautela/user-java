/*
You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

 

Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"*/

public class CowsBulls {
  public static String getHint(String secret, String guess) {
      int bulls = 0;
      int cows = 0;

      int[] secretCount = new int[10]; // counts of digits 0-9
      int[] guessCount = new int[10];

      for (int i = 0; i < secret.length(); i++) {
          char s = secret.charAt(i);
          char g = guess.charAt(i);

          if (s == g) {
              bulls++;
          } else {
              // Count digits for later cow comparison
              secretCount[s - '0']++;
              guessCount[g - '0']++;
          }
      }

      // Count cows (min overlap of non-bull digits)
      for (int i = 0; i < 10; i++) {
          cows += Math.min(secretCount[i], guessCount[i]);
      }

      return bulls + "A" + cows + "B";
  }

  public static void main(String[] args) {
      String secret = "1807";
      String guess = "7810";

      System.out.println(getHint(secret, guess)); // Output: 1A3B
  }
}
