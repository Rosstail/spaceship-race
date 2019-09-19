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

    float getNxtCheckPointDistanceX(int cp)
    {
        float pdx;

        pdx = getCheckPointPositionX(cp) - getShipPositionX();
        return pdx;
    }

    float getNxtCheckPointDistanceY(int cp)
    {
        float pdy;

        pdy = getCheckPointPositionY(cp) - getShipPositionY();
        return pdy;
    }

    float getAngletoNextCheckPoint(int cp)
    {
        float asqcp;
        float A;
        float O;

        A = getCheckPointPositionX(cp) - getShipPositionX();
        O = getCheckPointPositionY(cp) - getShipPositionY();
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

        int cp;

        cp = getNbValidCheckPoints() + 1;
        setPlayerName("9 - 4x4");
        selectShip(9);
        setPlayerColor(255,0,255,255);

        //turnTowardPosition(getNextCheckPointX(), getNextCheckPointY());
        incSpeed(1f);
        turnToAngle(getAngletoNextCheckPoint(cp));
        if (getNxtCheckPointDistanceX(cp) > 20 && getNxtCheckPointDistanceY(cp) > 20)
            if (getAngletoNextCheckPoint(cp) < 50)
                useBoost();
        // END OF CODE AREA
        //-------------------------------------------------------
    }

}
