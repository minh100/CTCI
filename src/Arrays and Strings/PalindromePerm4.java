public class PalindromePerm4 {
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
    for(int i = 0; i < table.length; i++){
      if(table[i] % 2 != 0){
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]){
    System.out.println(isPermutation("tact coa"));
  }
}