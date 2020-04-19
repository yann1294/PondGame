package com.pondGame.model;

import com.pondGame.controller.PondGameObject;

import java.awt.*;
import java.util.Random;

public class Rock extends PondGameObject {

    private final int  WIDTH = 35;
    private final int HEIGHT = 35;


    public Rock(int x, int y, ObjectID id) {
        super(x, y, id);
    }

    public void tick()
    {

    }

    public void render(Graphics gr)
    {
        gr.setColor(Color.BLUE);
        gr.fillRect(x, y, WIDTH, HEIGHT);
    }

    public static void rockCreation(int width, int height, Graphics gr)
    {
        Random val = new Random();
        int valWidth = 75;
        int valHeight = 25;
        for(int i =0; i< 5; i++)
        {
            new Rock(width - valWidth, height - valHeight, ObjectID.Rock).render(gr);
            valWidth += 13;
            valHeight += 19;

        }
    }

    @Override
    public Rectangle getBounds() {
        // TODO Auto-generated method stub
        return null;
    }
}
