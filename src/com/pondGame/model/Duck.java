package com.pondGame.model;

import com.pondGame.controller.ObjectsHandler;
import com.pondGame.controller.PondGame;
import com.pondGame.controller.PondGameObject;

import java.awt.*;
import java.util.Random;

public class Duck extends PondGameObject {

    Random r = new Random();
    ObjectsHandler objectsHandler;
    private int width = 32;
    private int height = 32;
    private int duckGrowthValue = 10;

    public Duck(int x, int y, ObjectID id, ObjectsHandler objectsHandler)
    {
        super(x, y, id);
        this.objectsHandler = objectsHandler;

    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, getWidth(), getHeight());
    }

    private void collision()
    {
        for(int i= 0; i< objectsHandler.object.size(); i++)
        {
            PondGameObject myGameObject = objectsHandler.object.get(i);
            if(myGameObject.getId() == ObjectID.Lily)
            {
                // Collision between a duck and a lilly happens here
                if(getBounds().intersects(myGameObject.getBounds()))
                {
                    System.out.println("COLLISION");
                    duckGrowth(getWidth(), getHeight(), duckGrowthValue);
                    objectsHandler.removeObject(myGameObject);
                }
            }

        }
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

        y = PondGame.respectBoundaries(y, 0, PondGame.HEIGHT - 42 );
        x = PondGame.respectBoundaries(x, 0, PondGame.WIDTH - 42 );

        collision();

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public int getDuckGrowthValue() {
        return duckGrowthValue;
    }

    public void setDuckGrowthValue(int duckGrowthValue) {
        this.duckGrowthValue = duckGrowthValue;
    }

    @Override
    public void render(Graphics gr) {


        gr.setColor(Color.white);
        gr.fillRect(x, y, getWidth(), getHeight());
    }


    private void duckGrowth(int width, int height, int duckGrowthValue)
    {
        setHeight(height + duckGrowthValue);
        setWidth(width + duckGrowthValue);

    }
}
