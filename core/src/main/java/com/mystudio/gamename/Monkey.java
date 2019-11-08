package com.mystudio.gamename;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import java.awt.*;
import static com.mystudio.gamename.Variable.*;

/**
 * Kong (Player)
 */
public  class Monkey extends Rectangle  {
    private boolean onLadder;
    private boolean onFloor;
    private boolean A_Pressed;
    private boolean D_Pressed;
    private boolean W_Pressed;
    private boolean S_Pressed;
    private float monkeySpeed_X = 10;
    private float monkeySpeed_Y = 3;
//    private CollisionPoint point;
    private CollisionBox monkeyBox;
    private  Sprite sprite;

    /**
     *
     * @param sprite
     * create monkey
     * set sprite's size, collisionBox's size and position
     */
    public Monkey(Sprite sprite){
        monkeyBox = new CollisionBox(0,0,200,200);
        this.sprite = sprite;
        this.sprite.setSize(200,200);
    }

    public CollisionBox getMonkeyBox() {
        return monkeyBox;
    }


    /**
     *
     * @param t the element to be insert
     */
    public void setA_Pressed(boolean t) {
        A_Pressed = t;
    }

    public void setD_Pressed(boolean t) {
        D_Pressed = t;
    }

    public void setW_Pressed(boolean t) {
        W_Pressed = t;
    }

    public void setS_Pressed(boolean t) {
        S_Pressed = t;
    }

    public void setOnFloor(boolean t){
        onFloor = t;
    }

    public void setOnLadder(boolean t) {
        onLadder = t;
    }

    public void checkFloor(CollisionBox a,CollisionBox b){
        if((a.getY()+a.getHeight()) >= b.getY()){ setOnFloor(true); }
        else setOnFloor(false);
    }
    /**
     * Control Player's movement.
     * if player doesn't stand on floor, player will fall down to the ground.
     */
    public void monkeyMove(){

        if(onFloor) {
            if (A_Pressed && onFloor) {
                monkeyBox.set(monkeyBox.getX() - monkeySpeed_X * 1f, monkeyBox.getY());
            }
            if (!A_Pressed && onFloor) {
                monkeyBox.set(monkeyBox.getX(), monkeyBox.getY());
            }
            if (D_Pressed) {
                monkeyBox.set(monkeyBox.getX() + monkeySpeed_X * 1f, monkeyBox.getY());
            }
            if (!D_Pressed) {
                monkeyBox.set(monkeyBox.getX(), monkeyBox.getY());
            }
            if (W_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }
            if(!W_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }
            if(S_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }
            if(!S_Pressed){
                monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
            }
        }
        if(!onFloor){
            monkeyBox.set(monkeyBox.getX(),monkeyBox.getY() + GRAVITY *1f);
        }
//        if(W_Pressed && D_Pressed){
//            monkeyBox.set(monkeyBox.getX() + monkeySpeed_X *0.5f, monkeyBox.getY() - monkeySpeed_Y *1f);
//        }
//        if(W_Pressed && A_Pressed){
//            monkeyBox.set(monkeyBox.getX() - monkeySpeed_X *0.5f, monkeyBox.getY() - monkeySpeed_Y *1f);
//        }
//        if(!W_Pressed){
//            monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
//        }
//        if(S_Pressed){
//            monkeyBox.set(monkeyBox.getX() , monkeyBox.getY() + monkeySpeed_Y *1f);
//        }
//        if(!S_Pressed){
//            monkeyBox.set(monkeyBox.getX() , monkeyBox.getY());
//        }
    }


    public void update() {
        monkeyBox.preUpdate();
    }

    public void interpolate(float alpha) {
        monkeyBox.interpolate(null, alpha);

    }

    public void render(Graphics g) {
        g.drawSprite(sprite, monkeyBox.getRenderX(), monkeyBox.getRenderY());
    }


}
