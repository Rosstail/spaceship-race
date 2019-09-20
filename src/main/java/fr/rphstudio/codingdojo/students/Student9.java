/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.codingdojo.students;

import fr.rphstudio.codingdojo.game.Pod;
import fr.rphstudio.codingdojo.game.PodPlugIn;

/**
 * @author Romuald GRIGNON
 */
public class Student9 extends PodPlugIn {
    public Student9(Pod p) {
        super(p);
    }

    //-------------------------------------------------------
    // DECLARE YOUR OWN VARIABLES AND FUNCTIONS HERE

    float speed = 1f;

    float getNxtCheckPointDistance() {
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

    float getSndCheckPointDistance() {
        float O;
        float A;
        float H;

        A = getSecondCheckPointX();
        O = getSecondCheckPointY();
        A = A * A;
        O = O * O;
        H = A + O;
        H = sqrt(H);
        return H;
    }

    float getAngletoNextCheckPoint() {
        float asqcp;
        float A;
        float O;

        A = getCheckPointPositionX(getNextCheckPointIndex()) - getShipPositionX();
        O = getCheckPointPositionY(getNextCheckPointIndex()) - getShipPositionY();
        asqcp = (180 * atan2(O, A) / PI);

        return asqcp;
    }

    float getAngletoSndCheckPoint() {
        float asqcp;
        float A;
        float O;

        A = getCheckPointPositionX(getNextCheckPointIndex()) - getShipPositionX();
        O = getCheckPointPositionY(getNextCheckPointIndex()) - getShipPositionY();
        asqcp = (180 * atan2(O, A) / PI);

        return asqcp;
    }

    boolean isDirectionGood(int a) {
        if (getAngletoNextCheckPoint() <= getShipAngle() + a)
            if (getAngletoNextCheckPoint() >= getShipAngle() - a)
                return true;
        return false;
    }

    void autopilot()
    {
        if (getNxtCheckPointDistance() < 3.8f && getShipSpeed() > 1f) {
            speed = -0.5f;
            turnToAngle(getAngletoSndCheckPoint());
        }
        else if (getShipSpeed() < 0.5f && isDirectionGood(10)) {
            speed = 0.4f;
            turnToAngle(getAngletoNextCheckPoint());
        }
        else {
            speed = 1.0f;
            turnToAngle(getAngletoNextCheckPoint());
        }
        incSpeed(speed);
        System.out.println("VITESSE = " + speed);
        if (getNxtCheckPointDistance() > 10 && isDirectionGood(1))
            useBoost();
    }

    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("9 - 4x4");
        selectShip(9);
        setPlayerColor(255, 0, 255, 255);

        autopilot();
        // END OF CODE AREA
        //-------------------------------------------------------
    }

}
