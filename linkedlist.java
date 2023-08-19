import java.io.*;
import java.util.*;

public class ProblemSolution {
    public int solution(int[][] A, int M, int N) {
        return (countGroups(A));   
    }
    public static int countGroups(int[][] matrix){
        int gc = 0; 
        int rows = matrix.length; 
        int cols = matrix[0].length; 
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    gc++;
                    dfs(matrix,i,j,visited);
                }
            }
        }
        return gc;
    }
    public static void dfs(int[][] mat,int row,int col,boolean[][] visited){
        int rows = mat.length; 
        int cols = mat[0].length;
        
        if(row<0 || row >= rows || col < 0 || col >= cols || mat[row][col] == 0 || visited[row][col]){
            return;
        }
        visited[row][col] = true;                                                                                   
        dfs(mat,row-1,col,visited); 
        dfs(mat,row+1,col,visited);    
        dfs(mat,row,col-1,visited);                                                                                
        dfs(mat,row,col+1,visited);
        
}
}
