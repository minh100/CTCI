public class StringRotate9 {
  static boolean isRotation(String s1, String s2){
    int len = s1.length();
    if(len == s2.length() && len > 0) {
      String newS1 = s1 + s1;
      return newS1.contains(s2);
    }
    return false;
  }

  public static void main(String[] args){
    String s1 = "waterbottle";
    String s2 = "erbottlewat";
    System.out.println(isRotation(s1,s2));
  }


}
