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

    private final int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

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
    public void setDirection(double direction) {
        this.direction = direction;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double clamp(double value, double lowerBound, double upperBound){
        return Math.max(lowerBound, Math.min(upperBound, value));
    }
    abstract double speedFactor();

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

