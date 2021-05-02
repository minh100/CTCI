package Yangshun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChewyVowelQuery {

  /*  Chewy
    Given a string list strArr and a string list query that contains indexes,
    find the strings in strArr from the start to the end that fits the conditions
    where the first and last element are vowels

    Example:
      strArr = {"aba","oau","waw","ede,"ee"}
      query = {"1-3","2-3","2-2"}

      output: {2,1,0}

    Explanation:
      query "1-3" means index 1 to index 3
      so strArr at index 1 = "oau", index 2 = "waw", index 3 = "ede"
      from these indexes only 2 of them fit the condition where first and last element are vowels
      therefore the result is only 2
   */

  //O(n^2)
  public static List<Integer> queryVowel(List<String> strArr, List<String> query) {
    List<String> vowelArray = Arrays.asList(new String[]{"a","e","i","o","u"});
    List<Integer> res = new ArrayList<>();

    for(int i = 0; i < query.size(); i++) {
      String currentQuery = query.get(i);
      String[] indexes = currentQuery.split("-");
      int start = Integer.valueOf(indexes[0]);
      int end = Integer.valueOf(indexes[1]);
      if(start >= strArr.size()) {
        continue;
      }
      if(end >= strArr.size()) {
        end = strArr.size() -1;
      }

      int count = 0;
      for(int j = start; j <= end; j++) {
        String currStr = strArr.get(j);
        if(vowelArray.contains(currStr.substring(0,1)) &&
            vowelArray.contains(currStr.substring(currStr.length()-1))) {
            count++;
        }
      }

      res.add(count);
    }
    return res;
  }

  public static void main(String[] args) {
    List<String> str = Arrays.asList(new String[]{"aba","oau","waw","ede","ee"});
    List<String> q = Arrays.asList(new String[]{"1-3","2-3","2-2"});

    System.out.println(queryVowel(str, q));
  }
}
