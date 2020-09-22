package top.amazingwu.blog.solution201907;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/submissions/
 * 有效的数独
 * @author amazingjadewu@gmail.com
 * @created 2019年07月15日 21:32
 */
public class Solution201907151 {
    public static class Point {
        public Integer x;
        public Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Character, List<Point>> hashMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!isValid(hashMap.get(board[i][j]), i, j)) return false;
                if (!hashMap.containsKey(board[i][j])) {
                    hashMap.put(board[i][j], new ArrayList<>());
                }
                hashMap.get(board[i][j]).add(new Point(i, j));
            }
        }
        return true;
    }

    public static boolean isValid(List<Point> points, int x, int y) {
        if (points == null || points.size() == 0) return true;
        for (Point point : points) {
            if (point.x == x || point.y == y) return false;
            else if (point.x / 3 == x / 3 && point.y / 3 == y / 3) return false;
        }
        return true;
    }
}
