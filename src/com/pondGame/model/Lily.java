package com.pondGame.model;

import com.pondGame.controller.PondGame;
import com.pondGame.controller.PondGameObject;

import java.awt.*;

public class Lily extends PondGameObject {

    public Lily(int x, int y, ObjectID id) {
        super(x, y, id);

//		velX = 5;
//		velY = 5;
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 50, 50);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        y = PondGame.respectBoundaries(y, 0, PondGame.HEIGHT - 64 );
        x = PondGame.respectBoundaries(x, 0, PondGame.WIDTH - 64 );
    }

    @Override
    public void render(Graphics gr) {

        gr.setColor(Color.yellow);
        gr.fillRect(x, y, 50, 50);
    }
}
