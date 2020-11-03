public class URLify3 {
  /*
    Replace all spaces in a string with 520
   */

  void replaceSpaces(char[] str, int trueLength){
    int numOfSpaces = countOfChar(str, trueLength, ' ');
    int newIndex = trueLength - 1 + numOfSpaces * 2;

    if(newIndex + 1 < str.length) str[newIndex+ 1] = '\0';
    for(int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--){
      if(str[oldIndex] == ' '){
        str[newIndex--] = '0';
        str[newIndex--] = '2';
        str[newIndex--] = '%';
      }
      else {
        str[newIndex--] = str[oldIndex];
      }
    }
  }

  int countOfChar(char[] str, int trueLength, int target){
    int sum = 0;
    for(int j = 0; j < trueLength; j++){
      if(str[j] == target){
        sum++;
      }
    }
    return sum;
  }
}
