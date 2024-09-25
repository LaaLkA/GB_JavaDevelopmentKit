package Lects.Lect1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    private final int MODE = 0;
    private static final int MODE_AI = 1;
    private static final int MODE_HUMAN = 2;

    private int cntColMap = 0;
    private int cntRowsMap = 0;
    private int winLen = 0;


    JButton btnStart = new JButton("Start new game");
    JButton btnAiMode = new JButton("Play with AI");
    JButton btnHumanMode = new JButton("Play with Human");
    JTextField fldWidthMap = new JTextField();
    JTextField fldHeightMap = new JTextField();
    JTextField fldWinLen = new JTextField();

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cntColMap = Integer.parseInt(fldWidthMap.getText());
                cntRowsMap = Integer.parseInt(fldHeightMap.getText());
                winLen = Integer.parseInt(fldWinLen.getText());
                //Заглушка, что все 3 занчения должны быть одинаковые из-за метода checkWin
                if(cntColMap != cntRowsMap && cntColMap != winLen) return;

                gameWindow.startNewGame(MODE,cntColMap,cntRowsMap,winLen);
                int height = Integer.parseInt(fldHeightMap.getText());
                setVisible(false);
            }
        });

        JPanel panWidth = new JPanel(new GridLayout(1, 3));
        panWidth.add(new JLabel("Count columns of map: "), BorderLayout.WEST);
        panWidth.add(fldWidthMap, BorderLayout.EAST);

        JPanel panHeight = new JPanel(new GridLayout(1, 3));
        panHeight.add(new JLabel("Count rows of map: "), BorderLayout.WEST);
        panHeight.add(fldHeightMap, BorderLayout.EAST);

        JPanel panWinLen = new JPanel(new GridLayout(1, 3));
        panWinLen.add(new JLabel("Win length: "), BorderLayout.WEST);
        panWinLen.add(fldWinLen, BorderLayout.EAST);

        JPanel panMode = new JPanel(new GridLayout(1, 2));
        panMode.add(btnAiMode);
        panMode.add(btnHumanMode);

        JPanel panStart = new JPanel(new BorderLayout());
        panStart.add(btnStart);

        add(panHeight);
        add(panWidth);
        add(panWinLen);
        add(panMode);
        add(panStart);
    }
}
