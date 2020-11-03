public class PalindromePerm4 {

  /*
    Given a string, check if it is a permutation of a palindrome
   */

   static boolean isPermutation(String phrase){
    phrase = phrase.toLowerCase();
    int[] table = buildCharFreq(phrase);
    return checkOdds(table);
  }

  static int[] buildCharFreq(String phrase){

    int[] table = new int[26];
    for(char c : phrase.toCharArray()){
      int index = c - 'a';
      if( index > 0 && index < 26){
        table[index]++;
      }
    }

    return table;
  }

  static boolean checkOdds(int[] table){
    boolean foundOdd = false;
    for(int i = 0; i < table.length; i++){
      if(table[i] % 2 == 1){
        if(foundOdd){
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  public static void main(String args[]){
    System.out.println(isPermutation("tact coat"));
  }
}
