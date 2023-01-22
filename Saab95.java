import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

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

}
