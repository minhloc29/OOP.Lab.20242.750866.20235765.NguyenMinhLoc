// 6.6
public class AddMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = { 
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9} 
        };

        int[][] matrix2 = { 
            {4, 2, 3}, 
            {4, 5, 6}, 
            {7, 5, 9} 
        };

        int output_matrix[][] = new int[matrix1.length][matrix1[0].length];
        // Printing the 2D array
        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[i].length; j++){
                output_matrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(output_matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
