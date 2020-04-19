package com.pondGame.controller;

import java.awt.*;
import java.util.LinkedList;

public class ObjectsHandler {

    public LinkedList<PondGameObject> object = new LinkedList<PondGameObject>();

    public void tick()
    {
        for(int i=0; i< object.size(); i++)
        {
            PondGameObject tempObject = object.get(i);
            tempObject.tick();
        }

    }

    public void render(Graphics gr)
    {
        for(int i=0; i< object.size(); i++)
        {
            PondGameObject tempObject = object.get(i);
            tempObject.render(gr);
        }

    }

    public void addObject(PondGameObject pObject)
    {
        this.object.add(pObject);
    }

    public void removeObject(PondGameObject pObject)
    {
        this.object.remove(pObject);
    }
}
