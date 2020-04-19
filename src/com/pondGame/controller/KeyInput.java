package com.pondGame.controller;

import com.pondGame.model.ObjectID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private ObjectsHandler objectsHandler;

    public KeyInput(ObjectsHandler objectsHandler)
    {
        this.objectsHandler = objectsHandler;
    }


    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        //System.out.println(key);
        for(int i= 0; i< objectsHandler.object.size(); i++)
        {
            PondGameObject tempObject = objectsHandler.object.get(i);
            if(tempObject.getId() == ObjectID.Duck)
            {
                //key events for the duck

                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
                if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
            }

        }
    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        for(int i= 0; i< objectsHandler.object.size(); i++)
        {
            PondGameObject tempObject = objectsHandler.object.get(i);
            if(tempObject.getId() == ObjectID.Duck)
            {
                //key events for the duck
                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }

        }

    }

}
