package com.company;
import java.util.*;

public class EightQueens {
    private boolean[][] cboard;
    private Stack<String> positions;

    private boolean safe(int row, int col){
        boolean safe = true;
        for (int i = 0; i < row; i++){
            if (cboard[i][col]){
                safe = false;
            }
        }
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0){
            if (cboard[i--][j--]){
                safe = false;
            }
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j <= 7){
            if (cboard[i--][j++]){
                safe = false;
            }
        }
        return safe;
    }

    private void addQ(int row, int col){
        cboard[row][col] = true;
        positions.push(row + "-" + col);
    }

    private void removeQ(int row, int col){
        cboard[row][col] = false;
        positions.pop();
    }

    private boolean solve(int n){
        if (n == 0){
            return true;
        }
        int r = 8 - n;
        for (int i = 0; i < 8; i++){
            if (safe(r, i)){
                addQ(r, i);
                if (solve(n-1)){
                    return true;
                }else{
                    removeQ(r, i);
                }
            }
        }
        return false;
    }

    public String solve(){
        cboard = new boolean[8][8];
        positions = new Stack<String>();
        if(solve(8) == false){
            return "not solvable";
        }
        return positions.toString();
    }
}
