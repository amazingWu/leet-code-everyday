package top.amazingwu.blog.solution201907;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/submissions/
 * 解数独(回溯法->但实现的效率不是很高)
 *
 * @author amazingjadewu@gmail.com
 * @created 2019年07月16日 22:40
 */
public class Solution201907161 {

    public static class Point {
        public Character c;
        public Integer x;
        public Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Point(Integer x, Integer y, Character c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static class NumberStruct {
        public HashMap<Integer, Void> rows;
        public HashMap<Integer, Void> columns;
        public HashMap<Integer, Void> boxes;

        public NumberStruct() {
            rows = new HashMap<>();
            columns = new HashMap<>();
            boxes = new HashMap<>();
        }
    }

    public static void solveSudoku(char[][] board) {
        LinkedList<Point> stack = new LinkedList<>();
        LinkedList<Point> spacePoints = new LinkedList<>();
        HashMap<Character, NumberStruct> allNumbers = new HashMap<>();
        for (char i = '1'; i <= '9'; i++) {
            allNumbers.put(i, new NumberStruct());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spacePoints.add(new Point(i, j));
                } else {
                    allNumbers.get(board[i][j]).rows.put(i, null);
                    allNumbers.get(board[i][j]).columns.put(j, null);
                    allNumbers.get(board[i][j]).boxes.put((i / 3) * 3 + j / 3, null);
                }
            }
        }

        char[] currentIndexex = new char[spacePoints.size()];
        for (int i = 0; i < currentIndexex.length; i++) {
            currentIndexex[i] = '0';
        }
        int current = 0;

        boolean nextPoint = false;
        while (spacePoints.size() > 0) {
            Point point = spacePoints.pop();
            nextPoint = false;
            for (Map.Entry<Character, NumberStruct> entry : allNumbers.entrySet()) {
                if (entry.getValue().rows.size() < 9
                        && entry.getKey() > currentIndexex[current]
                        && !entry.getValue().rows.containsKey(point.x)
                        && !entry.getValue().columns.containsKey(point.y)
                        && !entry.getValue().boxes.containsKey((point.x / 3) * 3 + point.y / 3)) {
                    point.c = entry.getKey();
                    stack.push(point);
                    entry.getValue().rows.put(point.x, null);
                    entry.getValue().columns.put(point.y, null);
                    entry.getValue().boxes.put((point.x / 3) * 3 + point.y / 3, null);
                    nextPoint = true;
                    currentIndexex[current] = entry.getKey();
                    board[point.x][point.y] = entry.getKey();
                    break;
                }
            }
            if (!nextPoint) {
                currentIndexex[current] = '0';
                current--;

                spacePoints.push(point);
                Point prePoint = stack.pop();

                allNumbers.get(prePoint.c).rows.remove(prePoint.x);
                allNumbers.get(prePoint.c).columns.remove(prePoint.y);
                allNumbers.get(prePoint.c).boxes.remove((prePoint.x / 3) * 3 + prePoint.y / 3);
                spacePoints.push(prePoint); // 回退到上一步
            } else {
                current++;
            }
        }
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    public static void main(String[] args) {
        char[][] chars = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                chars[i][j] = '.';
            }
        }
        solveSudoku(chars);
    }
}
