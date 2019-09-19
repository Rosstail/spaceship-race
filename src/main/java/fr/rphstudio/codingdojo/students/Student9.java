/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.codingdojo.students;

import fr.rphstudio.codingdojo.game.Pod;
import fr.rphstudio.codingdojo.game.PodPlugIn;

/**
 *
 * @author Romuald GRIGNON
 */
public class Student9 extends PodPlugIn {
    public Student9(Pod p){
        super(p);
    }
    
    //-------------------------------------------------------
    // DECLARE YOUR OWN VARIABLES AND FUNCTIONS HERE

    float getNxtCheckPointDistanceX()
    {
        float pdx;

        pdx = getShipPositionX() - getNextCheckPointX();
        if (pdx < 0)
            pdx = -pdx;
        return pdx;
    }

    float getNxtCheckPointDistanceY()
    {
        float pdy;

        pdy = getShipPositionY() - getNextCheckPointY();
        if (pdy < 0)
            pdy = -pdy;
        return pdy;
    }

    float getAngletoNextChectPoint()
    {
        float fangle;
        fangle = getShipAngle();

        return fangle;
    }
    
    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta)
    {   
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE
        
        setPlayerName("Groupe 9");
        selectShip(9);
        setPlayerColor(255,0,255,255);

        turnTowardPosition(getNextCheckPointX(), getNextCheckPointY());
        incSpeed(1f);
        if  (getNxtCheckPointDistanceX() < 50 && getNxtCheckPointDistanceY() < 50)
            useBoost();
        // END OF CODE AREA
        //-------------------------------------------------------
    }

}
