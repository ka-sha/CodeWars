public class Matrix {
    private static int[][] minor(int[][] m, int column) {
        int[][] result = new int[m.length - 1][m.length - 1];
        
        for (int j = 0; j < m.length; j++)
            for (int i = 1; i < m.length; i++) {
                if (j < column)
                    result[i - 1][j] = m[i][j];
                else if (j > column)
                    result[i - 1][j - 1] = m[i][j];
        }
      
        return result;
    }
    
    public static int determinant(int[][] m) {
        if (m.length == 1) return m[0][0];
        
        int det = 0;
        for (int i = 0; i < m.length; i++)
            det += ((i & 1) == 0) ? m[0][i] * determinant(minor(m, i)) : -m[0][i] * determinant(minor(m, i));
        return det;
    }
}
