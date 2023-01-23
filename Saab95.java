import java.awt.*;
/**
 * A class representing a Saab 95.
 */
public class Saab95 extends Car{
    /**
     * Boolean that affects the speed factor of the car.
     */
    private boolean turboOn;

    /**
     * Constructor with parameters for initial position/direction.
     *
     * @param xPosition Initial X position.
     * @param yPosition Initial Y position.
     * @param direction Initial direction.
     */

    public Saab95(double xPosition, double yPosition, double direction){
        super(2, Color.red, 125, "Saab95", xPosition, yPosition, direction);
	    turboOn = false;
        stopEngine();
    }
    /**
     * Constructor with default arguments (0,0,0).
     */
    public Saab95() {
        this(0,0,0);
    }

    /**
     * Turns turbo on.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns turbo off.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Used to calculate new currentSpeed values.
     *
     * @return Factor in incrementSpeed and decrementSpeed.
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Checks whether turbo is on
     * @return Currently not used in anything
     */
    public boolean isTurboOn() {
        return turboOn;
    }
}


