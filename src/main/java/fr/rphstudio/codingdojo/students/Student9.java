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
        //turnToAngle();
        incSpeed(1f);

        // END OF CODE AREA
        //-------------------------------------------------------
    }

}
