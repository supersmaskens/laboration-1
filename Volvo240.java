import java.awt.*;

/**
 * A class representing a Volvo 240.
 */
public class Volvo240 extends Car implements Movable{

    /**
     * Represents the cars trim factor and affects its speedFactor value.
     */
    private final static double trimFactor = 1.25;
    /**
     * Represents position on X-axis.
     */
    private double xPosition;
    /**
     * Represents position on Y-axis.
     */
    private double yPosition;
    /**
     * Represents direction and should always be between -2 * PI and 2 * PI.
     */
    private double direction;

    /**
     * Constructor with parameters for initial position/direction.
     * @param xPosition Initial X position.
     * @param yPosition Initial Y position.
     * @param direction Initial direction.
     */
    public Volvo240(double xPosition, double yPosition, double direction){
        super(4, Color.black, 100, "Volvo240");
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction % (2 * Math.PI);
        stopEngine();
    }

    /**
     * Constructor with default arguments (0,0,0).
     */
    public Volvo240(){
        this(0,0,0);
    }

    /**
     * Used to calculate new currentSpeed values.
     * @return Factor in incrementSpeed and decrementSpeed.
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Gives the current X position.
     * @return Current X position.
     */
    public double getX() {
        return xPosition;
    }
    /**
     * Gives the current Y position.
     * @return Current Y position.
     */
    public double getY() {
        return yPosition;
    }
    /**
     * Gives the current direction.
     * @return Current direction.
     */
    public double getDirection() {
        return direction;
    }
    /**
     * Sets a new higher currentSpeed value.
     * New value will be between 0 and enginePower.
     * @param amount Should be between 1 and 0.
     */
    public void incrementSpeed(double amount){
	    currentSpeed = clamp(getCurrentSpeed() + speedFactor() * amount,0, enginePower);
    }

    /**
     * Sets a new lower currentSpeed value.
     * New value will be between 0 and enginePower.
     * @param amount Should be between 1 and 0.
     */
    public void decrementSpeed(double amount){
        currentSpeed = clamp(getCurrentSpeed() - speedFactor() * amount,0, enginePower);
    }

    // TODO fix this method according to lab pm

    /**
     * Increases the currentSpeed value.
     * Calls incrementSpeed with a value between 0 and 1.
     * @param amount Should be between 1 and 0.
     */
    public void gas(double amount){
        incrementSpeed(clamp(amount, 0 ,1));
    }

    // TODO fix this method according to lab pm

    /**
     * Decreases the currentSpeed value.
     * Calls decrementSpeed with a value between 0 and 1.
     * @param amount Should be between 1 and 0.
     */
    public void brake(double amount){
        decrementSpeed(clamp(amount, 0, 1));
    }

    /**
     * Changes the current X and Y coordinates based on objects currentSpeed value.
     */
    public void move() {
        xPosition += Math.cos(direction) * getCurrentSpeed();
        yPosition += (-Math.sin(direction)) * getCurrentSpeed();
    }

    /**
     * Changes direction by one degree (PI / 180) to the left.
     */
    public void turnLeft(){
        direction = (direction + (Math.PI / 180)) % (Math.PI * 2);
    }

    /**
     * Changes direction by one degree (PI / 180) to the right.
     */
    public void turnRight(){
        direction = (direction - (Math.PI / 180)) % (Math.PI * 2);
    }
}
