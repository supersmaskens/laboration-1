import java.awt.*;

/**
 * Abstract class representing a car.
 */
public abstract class Car implements Movable{

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
     * Number of doors that the car has.
     */
    private final int nrDoors;
    /**
     * Engine power of the car.
     */
    double enginePower;
    /**
     * The current speed of the car.
     */
    private double currentSpeed;
    /**
     * Color of the car.
     */
    private Color color;
    /**
     * The car model name.
     */
    private final String modelName;

    /**
     * Basic constructor for a car.
     * @param nrDoors Number of doors.
     * @param color Color of the car.
     * @param enginePower Engine power, also serves as max speed.
     * @param name Model name for the car.
     * @param xPosition Initial X position.
     * @param yPosition Initial Y position.
     * @param direction Initial direction.
     */
    public Car(int nrDoors, Color color, double enginePower, String name,
               double xPosition, double yPosition, double direction) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = name;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    /**
     * Gives the current X position.
     * @return Current X position.
     */
    public double getX() {
        return xPosition;
    }

    /**
     * Sets a new X position.
     * @param xPosition New X position.
     */
    public void setX(double xPosition) {
        this.xPosition = xPosition;
    }
    /**
     * Gives the current Y position.
     * @return Current Y position.
     */
    public double getY() {
        return yPosition;
    }

    /**
     * Sets a new Y position.
     * @param yPosition New Y Position.
     */
    public void setY(double yPosition) {
        this.yPosition = yPosition;
    }
    /**
     * Gives the current direction.
     * @return Current direction.
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Sets a new direction.
     * @param direction New direction.
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * Gives the number of doors.
     * @return Number of doors.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Gives the engine power.
     * @return Engine power.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Gives the current speed.
     * @return Current speed.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Gives the name of the model.
     * @return Name of the cars model.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Gives the color of the car.
     * @return The cars current color.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets a new color for the car.
     * @param clr The new color.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the current speed to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Clamp method, not sure where to put it.
     * @param value A double to be clamped.
     * @param lowerBound Lowerbound.
     * @param upperBound Upperbound.
     * @return Clamped value.
     */
    public double clamp(double value, double lowerBound, double upperBound){
        return Math.max(lowerBound, Math.min(upperBound, value));
    }

    /**
     * SpeedFactor is used by each subclass to calculate speed when moving.
     */
    abstract double speedFactor();

    /**
     * Sets a new higher currentSpeed value.
     * New value will be between 0 and enginePower.
     * @param amount Should be between 0 and 1.
     */
    public void incrementSpeed(double amount){
        currentSpeed = clamp(getCurrentSpeed() + speedFactor() * amount,0, enginePower);
    }

    /**
     * Sets a new lower currentSpeed value.
     * New value will be between 0 and enginePower.
     * @param amount Should be between 0 and 1.
     */
    public void decrementSpeed(double amount){
        currentSpeed = clamp(getCurrentSpeed() - speedFactor() * amount,0, enginePower);
    }

    // TODO fix this method according to lab pm

    /**
     * Increases the currentSpeed value.
     * Calls incrementSpeed with a value between 0 and 1.
     * @param amount Should be between 0 and 1.
     */
    public void gas(double amount){
        incrementSpeed(clamp(amount, 0 ,1));
    }

    // TODO fix this method according to lab pm

    /**
     * Decreases the currentSpeed value.
     * Calls decrementSpeed with a value between 0 and 1.
     * @param amount Should be between 0 and 1.
     */
    public void brake(double amount){
        decrementSpeed(clamp(amount, 0, 1));
    }

    /**
     * Changes the current X and Y coordinates based on objects currentSpeed value.
     */
    public void move() {
        setX(Math.cos(getDirection()) * getCurrentSpeed());
        setY(-Math.sin(getDirection()) * getCurrentSpeed());
    }

    /**
     * Changes direction by one degree (PI / 180) to the left.
     */
    public void turnLeft(){
        setDirection((getDirection() + (Math.PI / 180)) % (Math.PI * 2));
    }

    /**
     * Changes direction by one degree (PI / 180) to the right.
     */
    public void turnRight(){
        setDirection((getDirection() - (Math.PI / 180)) % (Math.PI * 2));
    }
}

