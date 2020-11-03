public class StringCompression6 {

  /*
    Compress a string into number of character
    Example: aabbbcccc -> a2b3c4
   */

  static String compress(String str){
    StringBuilder compress = new StringBuilder();

    int count = 0;
    for(int i = 0 ; i < str.length(); i++){
      count++;
      if(i+1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
        compress.append(str.charAt(i));
        compress.append(count);
        count = 0;
        if(compress.length() > str.length()){
          return str;
        }
      }
    }
    return compress.toString();
  }

  public static void main(String[] args){
    System.out.println(compress("aabcccccaaa"));
    System.out.println(compress("awsdrfgwsdfrgaszedfvg"));
  }
}
