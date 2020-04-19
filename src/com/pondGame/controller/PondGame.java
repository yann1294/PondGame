package com.pondGame.controller;

import com.pondGame.model.*;
import com.pondGame.vue.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class PondGame extends Canvas implements Runnable {

    private static final long serialVersionUID = -8306173677029391098L;

    public static final int WIDTH = 720;
    public static final int HEIGHT = 720;
    public static final String TITLE = "Welcome to the Pond Game";
    private Thread thread;
    private boolean running = false;

    private ObjectsHandler objectsHandler;

    private Random r;
    Timer timer;


    public PondGame()
    {
        objectsHandler = new ObjectsHandler();

        this.addKeyListener(new KeyInput(objectsHandler));

        new MainWindow(WIDTH, HEIGHT, TITLE, this);
        r = new Random();
        objectsHandler.addObject(new Duck(WIDTH/2 - 62 , HEIGHT/2 - 32, ObjectID.Duck, objectsHandler));
        objectsHandler.addObject(new Lily(WIDTH/2 , HEIGHT/2, ObjectID.Lily));

        //objectsHandler.addObject(new FollowerDuck(WIDTH/3 , HEIGHT/3, ObjectID.Lily, objectsHandler));




        timer = new Timer(4500, new ActionListener(){

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent ae)
            {
                objectsHandler.addObject(new Lily(r.nextInt(WIDTH - 10) , r.nextInt(HEIGHT - 10 ), ObjectID.Lily));

            }

        });

        timer.start();

    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;

    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now -lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                tick();
                delta --;
            }

            if(running)
                render();

            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }

        }

        stop();
    }

    private void tick()
    {
        objectsHandler.tick();
    }


    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics gr = bs.getDrawGraphics();
        gr.setColor(Color.black);
        gr.fillRect(0, 0, WIDTH, HEIGHT);

        Rock.rockCreation(320, 320, gr);

        objectsHandler.render(gr);
        gr.dispose();
        bs.show();


    }


    public static int respectBoundaries(int actualVal, int min, int max)
    {
        if(actualVal <= min)
            return(actualVal = min);
        else if(actualVal >= max)
            return (actualVal = max);
        else
            return actualVal;
    }
}
