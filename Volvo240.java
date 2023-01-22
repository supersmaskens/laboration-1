import java.awt.*;

/**
 * A class representing a Volvo 240.
 */
public class Volvo240 extends Car implements Movable {

    /**
     * Represents the cars trim factor and affects its speedFactor value.
     */
    private final static double trimFactor = 1.25;


    /**
     * Constructor with parameters for initial position/direction.
     *
     * @param xPosition Initial X position.
     * @param yPosition Initial Y position.
     * @param direction Initial direction.
     */
    public Volvo240(double xPosition, double yPosition, double direction) {
        super(4, Color.black, 100, "Volvo240",
                xPosition, yPosition, direction % (2 * Math.PI));
        stopEngine();
    }

    /**
     * Constructor with default arguments (0,0,0).
     */
    public Volvo240() {
        this(0, 0, 0);
    }

    /**
     * Used to calculate new currentSpeed values.
     *
     * @return Factor in incrementSpeed and decrementSpeed.
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
