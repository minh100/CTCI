package Yangshun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwitchAutoComplete {

  /*
    Implement a function that accepts a prefix and a string of array that will return a sorted
    list of streamers that match the given search prefix.

    Cases:
      if there are matches return them in a sorted list
      if there are none return noMatches
   */

  public static String[] solution(String searchPrefix, String[] listOfSteamers) {
    Arrays.sort(listOfSteamers);
    ArrayList<String> list = new ArrayList<>();

    for(String s: listOfSteamers) {
      list.add(s);
    }

    for(int i = 0; i < searchPrefix.length(); i++) {
      for(int j = 0; j < list.size(); j++) {
        String currentStreamer = list.get(j);
        if(searchPrefix.length() > currentStreamer.length() ||
            searchPrefix.charAt(i) != currentStreamer.charAt(i)) {
          list.remove(currentStreamer);
          j--;
          continue;
        }
      }
    }

    String[] res = list.toArray(new String[list.size()]);
    String[] noMatch = {"noMatches"};
    return list.isEmpty() ? noMatch : res;

  }


  public static void main(String[] args) {
    String prefix = "nin";
    String[] array = {"lilypichu", "nintendo","ninja", "shroud"};

    System.out.println(Arrays.toString(solution(prefix, array)));
    long start1 = System.nanoTime();
    long start2 = System.nanoTime();
    solution(prefix, array);
    long stop = System.nanoTime();
    long diff = stop - 2*start2 + start1;

    System.out.println(diff + " ns");


  }
}
