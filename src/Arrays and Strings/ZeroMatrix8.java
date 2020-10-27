public class ZeroMatrix8 {
  static void setZeros(int[][] matrix){
    boolean[] row = new boolean[matrix.length];
    boolean[] col = new boolean[matrix[0].length];

    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[i].length; j++){
        if(matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }

    //set rows to 0
    for(int r = 0; r < row.length; r++){
      if(row[r]) {
        nullifyRow(matrix, r);
      }
    }

    //set cols to 0
    for(int c = 0; c < col.length; c++){
      if(col[c]){
        nullifyCol(matrix, c);
      }
    }
  }

  static void nullifyRow(int[][] matrix, int r){
    for(int i = 0; i < matrix[0].length; i++) {
      matrix[r][i] = 0;
    }
  }

  static void nullifyCol(int[][] matrix, int c){
    for(int j = 0; j < matrix.length; j++){
      matrix[j][c] = 0;
    }
  }
}