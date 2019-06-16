package com.thoughtworks.GameOfLife.Display;

import com.thoughtworks.GameOfLife.Import.ImportInitTxt;
import com.thoughtworks.GameOfLife.Entity.World;
import com.thoughtworks.GameOfLife.Utils.ExtendedWorldUtils;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;


public class WorldDisplay extends JFrame {
    /**
     *
     * @author:
     * @data: 2019/6/16
     */
    private volatile boolean running = false;
    private final static int DEFAULT_DURATION = 50;
    private volatile int duration = DEFAULT_DURATION;
    // 控件
    private JPanel WorldPanel;
    private JPanel controlPanel;
    private JButton startButton;
    private JButton InitFileButton;
    private JButton stopButton;
    private JButton randomButton;
    private JSlider speedJSlider;//创建一个滑块组建，调节档位
    private JButton speedButton;//显示速度滑块名称

    private JButton[][] jButtonsWorld;//用按钮表示每个细胞
    private volatile World world;

    public WorldDisplay() {
        this.setTitle("Game Of Life");
        InitFileButton = new JButton("TXT");
        ImageIcon icon_file = new ImageIcon("src/Resource/initfile_icon.png");
        InitFileButton.setIcon(icon_file);
        InitFileButton.setPreferredSize(new Dimension(110, 35));
        InitFileButton.addActionListener(new InitTxtFileActionListener());
        /**
         * 显示滑块名称按钮
         */
        speedButton = new JButton();
        speedButton.setEnabled(false);
        ImageIcon icon_speed = new ImageIcon("src/Resource/speed_icon.png");
        speedButton.setIcon(icon_speed);
        speedButton.setPreferredSize(new Dimension(50, 50));
        /**
         * 控制速度的滑块
         */
        speedJSlider = new JSlider(0, 2000, 0);//0-20初始值是0
        speedJSlider.setPreferredSize(new Dimension(100, 50));
        // jSlider.setMajorTickSpacing(5);//数字显示范围
        speedJSlider.setMinorTickSpacing(1);
        speedJSlider.setPaintLabels(true);
        speedJSlider.setPaintTicks(true);
        /**
         * 控制开始按钮
         */
        startButton = new JButton();
        ImageIcon icon = new ImageIcon("src/Resource/start_icon.png");
        startButton.setIcon(icon);
        startButton.setPreferredSize(new Dimension(100, 35));
        startButton.addActionListener(new StartActionListener());
        /**
         * 控制暂停按钮
         */
        stopButton = new JButton();
        ImageIcon icon_pause = new ImageIcon("src/Resource/stop_icon.png");
        stopButton.setIcon(icon_pause);
        stopButton.setPreferredSize(new Dimension(100, 35));
        stopButton.addActionListener(new StopActionListener());
        /**
         * 控制随机初始化
         */
        randomButton = new JButton();
        ImageIcon icon_random = new ImageIcon("src/Resource/random_icon.png");
        randomButton.setIcon(icon_random);
        randomButton.setPreferredSize(new Dimension(100, 35));
        randomButton.addActionListener(new RandomInitActionListener());
        /**
         * 整合组件
         */
        controlPanel = new JPanel();
        controlPanel.add(speedButton);
        controlPanel.add(speedJSlider);
        controlPanel.add(InitFileButton);
        controlPanel.add(randomButton);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);


        getContentPane().add(controlPanel, BorderLayout.SOUTH);
        this.setSize(700, 600);

    }


    /**
     * 迭代展示布局
     * @author:
     * @param: 2019/6/16
     */
    private void setWorldPanel() {
        int rows = world.getHeight();//高就是行数
        int cols = world.getWidth();
        WorldPanel = new JPanel();
        WorldPanel.setLayout(new GridLayout(rows, cols));

        int[][] matrix = world.getMatrix();
        // jTextFieldMatrix = new JTextField[rows][cols];
        jButtonsWorld = new JButton[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton jButton = new JButton();
                jButton.setSize(new Dimension(2, 2));
                if (matrix[i][j] == 1) {
                    jButton.setBackground(Color.RED);
                } else {
                    jButton.setBackground(Color.WHITE);
                }
                jButtonsWorld[i][j] = jButton;
                WorldPanel.add(jButton);
            }
        }
        this.add(WorldPanel);
        WorldPanel.updateUI();
    }

    /**
     * 显示下一代
     * @author:
     * @param: 2019/6/16
     */
    private void updateWorldPanel() {
        world.generation();
        int rows = world.getHeight();
        int cols = world.getWidth();
        int[][] matrix = world.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    jButtonsWorld[i][j].setBackground(Color.RED);
                } else {
                    jButtonsWorld[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }


    /**
     * 选择txt文件
     * @author:
     * @data: 2019/6/16
     */
    private class InitTxtFileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 暂定游戏/游戏未开始
            running = false;
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setDialogTitle("请选择初始配置文件");
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                //读取文件，初始化cellMatrix
                String filepath = fileChooser.getSelectedFile().getPath();
                world = ImportInitTxt.convertTxttoWorld(filepath);
                world = ExtendedWorldUtils.extendedworld(world);
                //初始化cellPanel
                setWorldPanel();
            }
        }
    }
    /**
     * 随机初始化一个状态
     * @author:
     * @data: 2019/6/16
     */
    private class RandomInitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 暂定游戏/游戏未开始
            running = false;
            // 初始化随机矩阵
            world = ImportInitTxt.randomInitWorld();
            setWorldPanel();
        }
    }

    /**
     * @author:
     * @param: 2019/6/16
     */
    private class RunGame implements Runnable {
        @Override
        public void run() {
            while (running) {
                setWorldPanel();
                updateWorldPanel();
                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 开始迭代显示
     * @author:
     * @data : 2019/6/16
     */
    private class StartActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!running) {
                // 获取设定的时间
                try {
                    duration = speedJSlider.getValue();
                } catch (NumberFormatException e1) {
                    duration = DEFAULT_DURATION;
                }
                Thread runGameThread = new Thread(new RunGame());
                runGameThread.start();
                running = true;
            }
        }
    }

    /**
     * 暂停操作
     * @author:
     * @data: 2019/6/16
     */
    private class StopActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                running = false;
            }
        }
    }

}
