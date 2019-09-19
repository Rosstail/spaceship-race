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

        pdx = getNextCheckPointX() - getShipPositionX();
        return pdx;
    }

    float getNxtCheckPointDistanceY()
    {
        float pdy;

        pdy = getNextCheckPointY() - getShipPositionY();
        return pdy;
    }

    float getAngletoNextCheckPoint()
    {
        float asqcp;
        float A;
        float O;

        A = getNextCheckPointX() - getShipPositionX();
        O = getNextCheckPointY() - getShipPositionY();
        asqcp = (180 * atan2(O, A) / PI);

        return asqcp;
    }
    
    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta)
    {   
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("9 - 4x4");
        selectShip(9);
        setPlayerColor(255,0,255,255);

        //turnTowardPosition(getNextCheckPointX(), getNextCheckPointY());
        incSpeed(1f);
        turnToAngle(getAngletoNextCheckPoint());
        if (getNxtCheckPointDistanceX() > 200 && getNxtCheckPointDistanceY() > 200)
            if (getAngletoNextCheckPoint() < 5 && getAngletoNextCheckPoint() > -5)
                useBoost();
        // END OF CODE AREA
        //-------------------------------------------------------
    }

}
