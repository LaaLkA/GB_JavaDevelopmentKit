package Lects.Lect1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";

    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;

    //Дополнение
    private int mode;
    private int winLen;
    private int cntColMap;
    private int cntRowsMap;

    private int fieldSizeY;
    private int fieldSizeX;
    private char[][] field;

    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;

    private boolean isGameOver;
    private boolean isInitialized;

    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;

        panelHeight = getHeight();
        panelWidth = getWidth();
        cellHeight = panelHeight / cntRowsMap;
        cellWidth = panelWidth / cntColMap;

        g.setColor(Color.BLACK);
        for (int h = 0; h < cntRowsMap; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < cntColMap; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] + " in cell: x=" + x + " y=" + y);
                }

            }
        }
        if (isGameOver) showGameOver(g);
    }

    private void showGameOver(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW -> g.drawString(MSG_DRAW, 180, getHeight() / 2);
            case STATE_WIN_AI -> g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
            case STATE_WIN_HUMAN -> g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
            default -> throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        this.mode = mode;
        this.cntColMap = fSzX;
        this.cntRowsMap = fSzY;
        this.winLen = wLen;
        this.fieldSizeX = fSzX;
        this.fieldSizeY = fSzY;

        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin((char) dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    /**
     * Tic Tac Toe game logic
     */

    private void initMap() {
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(char c) {
        boolean winMainDiag = true;
        boolean winSecDiag = true;

        //Проверка линий по вертикали и горизонтали
        for (int i = 0; i < field.length; i++) {
            boolean winCol = true;
            boolean winRow = true;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] != c) winRow = false;
                if (field[j][i] != c) winCol = false;
            }
            if (winCol || winRow) return true;
        }
        // Проверка главной и побочной диагонали
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] != c) {
                winMainDiag = false;
                break;
            }
        }

        for (int i = 0; i < field.length; i++) {
            if (field[i][field.length - 1 - i] != c) {
                winSecDiag = false;
                break;
            }
        }
        return winMainDiag || winSecDiag;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}
