package 面试题1604_井字游戏;

import java.util.Arrays;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/6/18 18:03
 */
public class Solution {
    public String tictactoe(String[] board) {
        //  一个字符的直接返回
        if(board.length == 1) return board[0].toCharArray()[0]+"";
        //  定义一个二维字符数组 && 转成n个字符数组
        char[][] charArray = new char[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            charArray[i] = board[i].toCharArray();
        }

        //  横向保证一致情况：
        for(int i = 0; i < board.length; i++){
            char temp = charArray[i][0];
            for(int j = 1; j < charArray[i].length; j++){
                if(temp != charArray[i][j]) break;
                if(j == charArray[i].length - 1 && temp !=' ' && temp == charArray[i][j]){
                    return temp+"";
                }
            }
        }

        //  竖向一致的情况
        for(int i = 0; i < board.length; i++){
            char temp = charArray[0][i];
            for(int j = 1; j < board.length; j++){
                if(temp != charArray[j][i])    break;
                if(j == board.length - 1 && temp !=' ' && temp == charArray[j][i]){
                    return temp+"";
                }
            }
        }

        //对角线一致的情况
        char temp1 = charArray[0][0];
        for(int i = 1 ; i < board.length; i++){
            if(charArray[i][i] != temp1) break;
            if(i == board.length - 1 && temp1 !=' ' && temp1 == charArray[i][i]){
                return temp1+"";
            }
        }
        char temp2 = charArray[0][board.length -1];
        for(int i = 1 ; i < board.length; i++){
            if(charArray[i][board.length - 1 - i] != temp2) break;
            if(i == board.length - 1 && temp2 !=' ' && temp2 == charArray[i][board.length - 1 - i]){
                return temp2+"";
            }
        }

        // Draw
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <= board.length -1; j ++){
                if(charArray[i][j] == ' ') return "Pending";
            }
        }

        return "Draw";
    }
}
