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

    float getNxtCheckPointDistance()
    {
        float O;
        float A;
        float H;

        A = getCheckPointPositionX(getNextCheckPointIndex()) - getShipPositionX();
        O = getCheckPointPositionY(getNextCheckPointIndex()) - getShipPositionY();
        A = A * A;
        O = O * O;
        H = A + O;
        H = sqrt(H);
        return H;
    }

    float getAngletoNextCheckPoint()
    {
        float asqcp;
        float A;
        float O;

        A = getCheckPointPositionX(getNextCheckPointIndex()) - getShipPositionX();
        O = getCheckPointPositionY(getNextCheckPointIndex()) - getShipPositionY();
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

        turnToAngle(getAngletoNextCheckPoint());
        if (getNxtCheckPointDistance() > 6)
            incSpeed(1.0f);
        else
            incSpeed(0.3f);
        if (getNxtCheckPointDistance() > 9 && getAngletoNextCheckPoint() <= getShipAngle() + 1 && getAngletoNextCheckPoint() >= getShipAngle() - 1)
            useBoost();
        // END OF CODE AREA
        //-------------------------------------------------------
    }

}
