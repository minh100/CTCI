public class CheckPermutation2 {
/*
  Check if one string is a permutation of another
 */
  public static boolean isPermutation(String s1, String s2){
    if(s1.length() != s2.length()) return false;

    int[] letters = new int[128];
    for(int i = 0 ; i < s1.length(); i++){
      letters[s1.charAt(i)]++;
    }

    for(int j = 0; j < s2.length(); j++){
      letters[s2.charAt(j)]--;
      if(letters[s2.charAt(j)] < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args){
    System.out.println(isPermutation("h1","1h"));
  }
}
