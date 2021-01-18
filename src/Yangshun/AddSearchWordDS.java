package Yangshun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddSearchWordDS {

  /*
  Design a data structure that supports adding new words and finding if a string matches any previously added string.

  Implement the WordDictionary class:

  WordDictionary() Initializes the object.
  void addWord(word) Adds word to the data structure, it can be matched later.
  bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
    word may contain dots '.' where dots can be matched with any letter.
   */

  private HashMap<Integer, List<String>> map;
  public AddSearchWordDS() {
    this.map = new HashMap<>();
  }

  public void addWord(String word) {
    int index = word.length();  // kinda like a hash function that puts the word into the map

    if(!map.containsKey(index)) {   // if the map does not contain the length already create new list
      List<String> list = new ArrayList<>();
      list.add(word);
      map.put(index, list);
    } else {                        // if map does have then put the word at the end of the list
      map.get(index).add(word);
    }
  }

  public boolean search(String word) {
    int index = word.length();
    if(!map.containsKey(index)) {   // says that the word doesn't exist due to no word with that length
      return false;
    }

    List<String> list = map.get(index);
    if(isWord(word)) {              // checks if the word to be search contains the . place holder
      return list.contains(word);
    }

    for(String s: list) {
      if(isSame(s, word)) {
        return true;
      }
    }
    return false;
  }

  // function to check if the word does not contain a . placeholder and is actually a real word
  public boolean isWord(String word) {
    for(int i = 0; i < word.length(); i++) {
      if(!Character.isLetter(word.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  // function to check if the word appears
  public boolean isSame(String compare, String word) {
    if(compare.length() != word.length()) {
      return false;
    }

    for(int i = 0; i < word.length(); i++) {
      if(word.charAt(i) != '.' && word.charAt(i) != compare.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
