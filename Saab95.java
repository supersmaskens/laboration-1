import java.awt.*;

public class Saab95 extends Car implements Movable{

    public boolean turboOn;
    private double xPosition;

    private double yPosition;

    private double direction;

    public Saab95(double xPosition, double yPosition, double direction){
        super(2, Color.red, 125, "Saab95", xPosition, yPosition, direction);
	    turboOn = false;
        stopEngine();
    }
    public Saab95() {
        this(0,0,0);
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = clamp(getCurrentSpeed() + speedFactor() * amount,0, enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = clamp(getCurrentSpeed() - speedFactor() * amount,0, enginePower);
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(clamp(amount, 0, 1));
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(clamp(amount, 0, 1));
    }

    public void move() {
        xPosition += Math.cos(direction) * getCurrentSpeed();
        yPosition += (-Math.sin(direction)) * getCurrentSpeed();
    }
    public void turnLeft(){
        direction = Math.abs((direction + (Math.PI / 180)) % (Math.PI * 2));
    }
    public void turnRight(){
        direction = Math.abs((direction - (Math.PI / 180)) % (Math.PI * 2));
    }
}
