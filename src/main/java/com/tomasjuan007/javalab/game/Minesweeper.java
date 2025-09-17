package com.tomasjuan007.javalab.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Minesweeper {
    private static final int SIZE = 8;
    private static final int MINES = 10;
    private static final char UNKNOWN = 'M';
    private static final char MINE = '*';

    private final char[][] mineField = new char[SIZE][SIZE];
    private final boolean[][] revealed = new boolean[SIZE][SIZE];
    private final boolean[][] flagged = new boolean[SIZE][SIZE];

    public Minesweeper() {
        displayWelcomeMessage();
        initializeField();
        placeMines();
        calculateNumbers();
    }

    private void displayWelcomeMessage() {
        System.out.println("=======================");
        System.out.println("        扫雷游戏        ");
        System.out.println("=======================\n");
        System.out.println("游戏规则:");
        System.out.println("· 地图包含 " + MINES + " 个地雷");
        System.out.println("· 输入坐标(x y)进行探测");
        System.out.println("· 输入坐标后加 f 标记地雷 (例: 3 4 f)\n");
        System.out.println("地图符号说明:");
        System.out.println("M - 未探测区域");
        System.out.println("F - 已标记地雷");
        System.out.println("数字 - 周围地雷数量\n");
        System.out.println("祝你好运！");
        System.out.println("=======================");
    }

    private void initializeField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mineField[i][j] = '0';
                revealed[i][j] = false;
            }
        }
    }

    private void placeMines() {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < SIZE * SIZE; i++) positions.add(i);
        Collections.shuffle(positions);

        for (int i = 0; i < MINES; i++) {
            int pos = positions.get(i);
            int x = pos / SIZE;
            int y = pos % SIZE;
            mineField[x][y] = MINE;
        }
    }

    private void calculateNumbers() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mineField[i][j] != MINE) {
                    int count = countAdjacentMines(i, j);
                    mineField[i][j] = (char) (count + '0');
                }
            }
        }
    }

    private int countAdjacentMines(int x, int y) {
        int count = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(SIZE - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(SIZE - 1, y + 1); j++) {
                if (mineField[i][j] == MINE) count++;
            }
        }
        return count;
    }

    private void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                // 已标记未地雷、未标记为地雷并且已揭示、未标记为地雷并且未揭示
                if (flagged[i][j]) {
                    System.out.print("F ");
                } else if (revealed[i][j]) {
                    System.out.print(mineField[i][j]);
                    System.out.print(" ");
                } else {
                    System.out.print(UNKNOWN);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void printFinalMap() {
        System.out.println("=======================");
        System.out.println("完整地雷地图：");
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                // 地雷、非地雷但是标记为地雷、非地雷未标记为地雷
                if (mineField[i][j] == MINE) {
                    System.out.print(MINE + " ");
                } else if (flagged[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print(mineField[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private boolean reveal(int x, int y) {
        // 1.点击已揭示的位置，做额外处理
        if (revealed[x][y] || flagged[x][y]) {
            int mineCount = countAdjacentMines(x, y);
            int flagCount = 0;

            // 1.1.周边已标记的地雷检查
            for (int i = Math.max(0, x - 1); i <= Math.min(SIZE - 1, x + 1); i++) {
                for (int j = Math.max(0, y - 1); j <= Math.min(SIZE - 1, y + 1); j++) {
                    if (flagged[i][j]) {
                        flagCount++;
                        if (mineField[i][j] != MINE) return false;
                    }
                }
            }

            // 1.2.满足前提没有错标，周边标记数量大于等于所有地雷数量，则对周边未标记也未揭示的点，进行揭示
            if (mineCount <= flagCount) {
                for (int i = Math.max(0, x - 1); i <= Math.min(SIZE - 1, x + 1); i++) {
                    for (int j = Math.max(0, y - 1); j <= Math.min(SIZE - 1, y + 1); j++) {
                        if (!flagged[i][j] && !revealed[i][j]) {
                            if (!reveal(i, j)) return false;
                        }
                    }
                }
            }
            return true;
        }

        // 2.未揭示位置的处理
        if (mineField[x][y] == MINE) return false;
        revealed[x][y] = true;

        // 3.如果周边没有地雷，进行自动揭示
        if (mineField[x][y] == '0') {
            for (int i = Math.max(0, x - 1); i <= Math.min(SIZE - 1, x + 1); i++) {
                for (int j = Math.max(0, y - 1); j <= Math.min(SIZE - 1, y + 1); j++) {
                    if (!reveal(i, j)) return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin() {
        // 充分条件1.所有非地雷位置已知
        int unRevealedCount = SIZE * SIZE - MINES;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (revealed[i][j]) unRevealedCount--;
            }
        }
        if (unRevealedCount == 0) return true;

        // 充分条件2.所有地雷位置已知
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((mineField[i][j] == MINE) ^ flagged[i][j]) return false;
            }
        }
        return true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        printMap();

        while (true) {
            System.out.print("输入坐标(x y): ");
            try {
                String input = scanner.nextLine().trim();
                String[] parts = input.split("\\s+");
                int argsNum = parts.length;
                if (argsNum < 2 || argsNum > 3) {
                    System.out.println("无效输入!");
                    continue;
                }

                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);

                if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                    System.out.println("坐标超出范围!");
                    continue;
                }

                boolean flagMines = argsNum == 3 && parts[2].equalsIgnoreCase("f");
                if (flagMines) {
                    if (!revealed[x][y]) {
                        flagged[x][y] = !flagged[x][y];
                    }
                } else if (!reveal(x, y)) {
                    printFinalMap();
                    System.out.println("踩到地雷! 游戏结束!");
                    break;
                }

                if (checkWin()) {
                    System.out.println("恭喜你赢了!");
                    printFinalMap();
                    break;
                }

                printMap();
            } catch (Exception e) {
                System.out.println("无效输入!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.play();
    }

}