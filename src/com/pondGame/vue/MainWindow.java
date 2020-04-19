package com.pondGame.vue;

import com.pondGame.controller.PondGame;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends Canvas {
    private static final long serialVersionUID = -6447581172906444365L;
    int width, height;
    String title;

    public MainWindow(int width, int height, String title, PondGame pondGame)
    {
        this.width = width;
        this.height = height;
        this.title = title;

        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(this.width, this.height));
        frame.setMaximumSize(new Dimension(this.width, this.height));
        frame.setMinimumSize(new Dimension(this.width, this.height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(pondGame);
        frame.setVisible(true);
        pondGame.start();

    }
}
