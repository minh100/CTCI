public class IsUnique1 {

  public static boolean isUniqueChars(String str){
    boolean[] unique = new boolean[128];

    for(int i = 0 ; i < str.length(); i++){
      char value = str.charAt(i);
      if(unique[value]){
        return false;
      }
      unique[value] = true;
    }
    return true;
  }

  public static void main(String[] args){
    System.out.println(isUniqueChars("hello"));
  }
}
