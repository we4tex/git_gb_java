package Lesson08;

import Lesson08.models.Enemy;
import Lesson08.models.Player;
import Lesson08.models.Tools;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    private GameWindow gameWindow;

    private final int LABEL_PLAYER = 1;
    private final int LABEL_ENEMY = 2;
    private final int LABEL_READY_CELL = 99;
    private final int LABEL_EMPTY_CELL = 0;

    private int[][] map;
    private int[][] invisibleMap;
    private int mapWidth;
    private int mapHeight;
    private int mapSizeMin = 3;
    private int mapSizeMax = 5;

    private int currentLevel = 0;
    private int countEnemies;

    public static final int DIRECTION_UP = 8;
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_RIGHT = 6;
    public static final int DIRECTION_RIGHT_DOWN = 7;
    public static final int DIRECTION_LEFT_UP = 3;
    public static final int DIRECTION_RIGHT_UP = 1;
    public static final int DIRECTION_LEFT_DOWN = 9;

    private int cellWidth;
    private int cellHeight;

    private Player player;
    private Enemy enemy;

    private boolean isMapExist;
    private boolean isGameStart;

    public boolean setRandomStartPosition = true;

    GameMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.BLACK);
        isMapExist = false;
        isGameStart = false;
    }

    void initGame() {
        player = new Player();
        currentLevel = 0;
        startNewRound();
        isMapExist = true;
        isGameStart = true;
    }

    private void startNewRound() {
        createGameWorld();
        initPlayer();
        createEnemies();
        ++currentLevel;
        gameWindow.refreshGameInfo();
        gameWindow.recordLog("Welcome to Level " + currentLevel);
    }

    private void createGameWorld() {
        mapHeight = Tools.randomRange(mapSizeMin, mapSizeMax);
        mapWidth = Tools.randomRange(mapSizeMin, mapSizeMax);
        map = new int[mapHeight][mapWidth];
        invisibleMap = new int[mapHeight][mapWidth];
        repaint();
    }

    private void initPlayer() {
        if (setRandomStartPosition) {
            player.setPosition(Tools.randomRange(0, mapWidth - 1), Tools.randomRange(0, mapHeight - 1));
        } else {
            player.setPosition(mapWidth / 2, mapHeight / 2);
        }
        map[player.getY()][player.getX()] = LABEL_PLAYER;
    }

    private void createEnemies() {
        int posX;
        int posY;

        countEnemies = (mapWidth + mapHeight) / 4;

        for (int i = 0; i < countEnemies; i++) {

            do {
                posX = Tools.random.nextInt(mapWidth);
                posY = Tools.random.nextInt(mapHeight);
            } while (posX == player.getX() && posY == player.getY());

            invisibleMap[posY][posX] = LABEL_ENEMY;
        }
        enemy = new Enemy();
    }

    private void render(Graphics g) {
        drawMap(g);

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {

                if (map[y][x] == LABEL_EMPTY_CELL) {
                    continue;
                }

                if (map[y][x] == LABEL_PLAYER) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }

                if (map[y][x] == LABEL_READY_CELL) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    void update(int direction) {
        if (!isGameStart) {
            return;
        }

        int currentX = player.getX();
        int currentY = player.getY();

        switch (direction) {
            case DIRECTION_UP:
                player.moveUp();
                break;
            case DIRECTION_DOWN:
                player.moveDown();
                break;
            case DIRECTION_LEFT:
                player.moveLeft();
                break;
            case DIRECTION_RIGHT:
                player.moveRight();
                break;
            case DIRECTION_LEFT_UP:
                player.moveLeftUp();
                break;
            case DIRECTION_RIGHT_UP:
                player.moveRightUp();
                break;
            case DIRECTION_LEFT_DOWN:
                player.moveLeftDown();
                break;
            case DIRECTION_RIGHT_DOWN:
                player.moveRightDown();
                break;
        }

        if (!isValidNextMove(currentY, currentX, player.getY(), player.getX())) {
            return;
        }

        playerNextMoveAction(currentY, currentX, player.getY(), player.getX());
        gameWindow.refreshGameInfo();
        repaint();

        if (isFullMap()) {
            startNewRound();
        }

        if (!player.isPlayerAlive()) {
            isGameStart = false;
            gameWindow.recordLog("Player died!");
            JOptionPane.showMessageDialog(this, "Game over! Player died! Count steps is " + player.getStep());
        }
    }

    private void drawMap(Graphics g) {
        if (!isMapExist) {
            return;
        }

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / mapWidth;
        cellHeight = height / mapHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i < mapHeight; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < mapWidth; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

    }

    public boolean isValidNextMove(int currentY, int currentX, int nextY, int nextX) {
        if (nextY >= 0 && nextY < mapHeight && nextX >= 0 && nextX < mapWidth) {
            gameWindow.recordLog("Player move to [" + (nextX + 1) + ":" + (nextY + 1) + "]  success");
            return true;
        } else {
            player.setPosition(currentX, currentY);
            gameWindow.recordLog("Invalid move. Please try again");
            return false;
        }
    }

    public void playerNextMoveAction(int currentY, int currentX, int nextY, int nextX) {
        if (invisibleMap[nextY][nextX] == LABEL_ENEMY) {
            player.decreaseHealth(enemy.getPowerPoint());
            countEnemies--;
            gameWindow.recordLog("Alert! Enemy give damage " + enemy.getPowerPoint());
        }

        invisibleMap[currentY][currentX] = LABEL_READY_CELL;
        map[currentY][currentX] = LABEL_READY_CELL;
        map[player.getY()][player.getX()] = LABEL_PLAYER;
    }

    public boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if (map[y][x] == LABEL_EMPTY_CELL) return false;
            }
        }
        return true;
    }

    public int getCurrentLevelInfo() {
        return currentLevel;
    }

    public int getCountEnemiesInfo() {
        return countEnemies;
    }

    public String getMapSizeInfo() {
        return mapWidth + "x" + mapHeight;
    }

    public int getPlayerHPInfo() {
        return player.getHealth();
    }

    public int getPlayerStepsInfo() {
        return player.getStep();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
}

