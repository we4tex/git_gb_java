package Lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        map = new GameMap(this);

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
        gui.add(playerActions);
        gui.add(containerForGameLog, BorderLayout.SOUTH);

    }

    private void prepareGameControls() {
        gameControls = new JPanel();
        gameControls.setLayout(new GridLayout(2, 1));

        btnStartGame = new JButton("Start Game!");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordLog("=Game Start=");
                map.initGame();
            }
        });

        btnExitGame = new JButton("Exit Game!");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        gameControls.add(btnStartGame);
        gameControls.add(btnExitGame);

    }

    private void prepareGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4, 1));
        gameInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        gameRoundInfo = new JLabel("Current Round: -");
        mapSizeInfo = new JLabel("Current map size: -");
        countEnemyInfo = new JLabel("Current enemy count: -");

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
        playerActions = new JPanel();
        playerActions.setLayout(new GridLayout(3, 3));
        playerActions.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        moveUp = new JButton("\uD83E\uDC79");
        moveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_UP);
            }
        });

        moveDown = new JButton("\uD83E\uDC7B");
        moveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_DOWN);
            }
        });

        moveLeft = new JButton("\uD83E\uDC78");
        moveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_LEFT);
            }
        });

        moveRight = new JButton("\uD83E\uDC7A");
        moveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_RIGHT);
            }
        });

        moveLeftUp = new JButton("\uD83E\uDC7C");
        moveLeftUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_LEFT_UP);
            }
        });

        moveRightUp = new JButton("\uD83E\uDC7D");
        moveRightUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_RIGHT_UP);
            }
        });

        moveLeftDown = new JButton("\uD83E\uDC7F");
        moveLeftDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_LEFT_DOWN);
            }
        });

        moveRightDown = new JButton("\uD83E\uDC7E");
        moveRightDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_RIGHT_DOWN);
            }
        });


        playerActions.add(moveLeftUp);
        playerActions.add(moveUp);
        playerActions.add(moveRightUp);
        playerActions.add(moveLeft);
        playerActions.add(new JLabel());
        playerActions.add(moveRight);
        playerActions.add(moveLeftDown);
        playerActions.add(moveDown);
        playerActions.add(moveRightDown);

    }

    private void prepareGameActionsLog() {
        gameLog = new JTextArea();
        containerForGameLog = new JScrollPane(gameLog);
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
    }

    private void prepareWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(winPosX, winPosY);
        setSize(winWidth, winHeight);
        setTitle("GraphicApp Game");
        setResizable(false);
    }

    void recordLog(String msg) {
        gameLog.append(msg + "\n");
    }

    void refreshGameInfo() {
        gameRoundInfo.setText("Current Round: " + map.getCurrentLevelInfo()) ;
        mapSizeInfo.setText("Current map size: " + map.getMapSizeInfo());
        countEnemyInfo.setText("Current enemy count: " + map.getCountEnemiesInfo());
        playerHealthInfo.setText("Health: " + map.getPlayerHPInfo());
        playerStepsInfo.setText("Steps: " + map.getPlayerStepsInfo());
    }

}

