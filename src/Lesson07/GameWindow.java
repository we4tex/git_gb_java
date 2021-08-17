package Lesson07;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private int winWidth = 800;
    private int winHeight = 600;
    private int winPosX = 450;
    private int winPosY = 200;

    private GameMap map;
    private JPanel gui;

    private JPanel gameControls;
    private JButton btnStartGame;
    private JButton btnExitGame;

    private JPanel gameInfo;
    private JLabel mapSizeInfo;
    private JLabel countEnemyInfo;
    private JLabel gameRoundInfo;

    private JPanel playerInfo;
    private JLabel playerHealthInfo;
    private JLabel playerStepsInfo;

    private JPanel playerActions;
    private JButton moveUp;
    private JButton moveDown;
    private JButton moveLeft;
    private JButton moveRight;
    private JButton moveLeftUp;
    private JButton moveRightUp;
    private JButton moveLeftDown;
    private JButton moveRightDown;

    private JScrollPane containerForGameLog;
    private JTextArea gameLog;

    GameWindow() {
        prepareWindow();

        map = new GameMap();

        prepareGui();

        add(gui, BorderLayout.EAST);
        add(map);

        setVisible(true);
    }

    private void prepareGui() {
        gui = new JPanel();
        gui.setLayout(new GridLayout(5, 1));

        prepareGameControls();
        prepareGameInfo();
        preparePlayerInfo();
        preparePlayerActions();
        prepareGameActionsLog();

        gui.add(gameControls);
        gui.add(gameInfo);
        gui.add(playerInfo);

    }

    private void prepareGameControls() {
        gameControls = new JPanel();
        gameControls.setLayout(new GridLayout(2, 1));

        btnStartGame = new JButton("Start Game!");
        btnExitGame = new JButton("Exit Game!");

        gameControls.add(btnStartGame);
        gameControls.add(btnExitGame);

    }

    private void prepareGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4, 1));
        gameInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        gameRoundInfo = new JLabel("Current Round: ");
        mapSizeInfo = new JLabel("Current map size: ");
        countEnemyInfo = new JLabel("Current enemy count: ");

        gameInfo.add(new JLabel("== Game Info =="));
        gameInfo.add(gameRoundInfo);
        gameInfo.add(mapSizeInfo);
        gameInfo.add(countEnemyInfo);

    }

    private void preparePlayerInfo() {
        playerInfo = new JPanel();
        playerInfo.setLayout(new GridLayout(3, 1));
        playerInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        playerHealthInfo = new JLabel("Health: - ");
        playerStepsInfo = new JLabel("Steps: -");

        playerInfo.add(new JLabel("== Player Info =="));
        playerInfo.add(playerHealthInfo);
        playerInfo.add(playerStepsInfo);

    }

    private void preparePlayerActions() {

    }

    private void prepareGameActionsLog() {

    }


    private void prepareWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(winPosX, winPosY);
        setSize(winWidth, winHeight);
        setTitle("GraphicApp Game");
        setResizable(false);
    }

}

