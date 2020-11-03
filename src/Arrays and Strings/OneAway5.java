public class OneAway5 {

  /*
    Check if a one string is one edit away from the other string
    Edits include deleting, inserting, or changing just one character
   */

  static boolean isOneEdit(String first, String second){
    if(first.length() == second.length()){
      return replaceEdit(first, second);
    } else if ( first.length() + 1 == second.length()){ //first is smaller
      return insertEdit(second, first); //remove
    } else if (first.length() - 1 == second.length()){ //first is larger
      return insertEdit(first, second); //insert
    } else {
      return false;
    }
  }

  static boolean replaceEdit(String s1, String s2){
    boolean foundDiff = false;
    for(int i = 0; i < s1.length(); i++){
      if(s1.charAt(i) != s2.charAt(i)){
        if(foundDiff){
          return false;
        }
        foundDiff = true;
      }
    }
    return true;
  }

  static boolean insertEdit(String longerStr, String shorterStr){
    int longIdx = 0;
    int shortIdx = 0;
    while(longIdx < longerStr.length() && shortIdx < shorterStr.length()){
      if(longerStr.charAt(longIdx) != shorterStr.charAt(shortIdx)){
        if(longerStr != shorterStr){
          return false;
        }
        shortIdx++;
      } else {
        longIdx++;
        shortIdx++;
      }
    }
    return true;
  }
}
