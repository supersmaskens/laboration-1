import java.awt.*;

/**
 * Abstract class representing a car.
 */
public abstract class Car {

    private final int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    public Car(int nrDoors, Color color, double enginePower, String name) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = name;
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

}
