import org.junit.Test;
import java.awt.*;

public class test {
    @Test
    public void carModelName() {
        Volvo240 car = new Volvo240();
        assert(car.getModelName().equals("Volvo240"));
    }
    @Test
    public void carColor(){
        Volvo240 car = new Volvo240();
        car.setColor(Color.red);
        assert(car.getColor() == Color.red);
    }
    @Test
    public void engineStart() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        assert(car.getCurrentSpeed() == 0.1);
    }
    @Test
    public void engineStop() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        car.stopEngine();
        assert(car.getCurrentSpeed() == 0);
    }
    @Test
    public void defaultVolvoTest(){
        Volvo240 car = new Volvo240();
        assert(car.getNrDoors() == 4 && car.getEnginePower() == 100 && car.getX() == 0 && car.getY() == 0);
    }

    @Test
    public void volvoTurnLeftTest() {
        Volvo240 car = new Volvo240();
        car.turnLeft();
        assert(car.getDirection() == Math.PI / 180);
    }
    @Test
    public void volvoTurnLeftCircleTest() {
        Volvo240 car = new Volvo240(0,0,(Math.PI * 2) - (Math.PI / 180));
        car.turnLeft();
        assert(car.getDirection() == 0);
    }

    @Test
    public void volvoTurnRightTest() {
        Volvo240 car = new Volvo240();
        car.turnRight();
        assert(car.getDirection() == -Math.PI / 180);
    }
    @Test
    public void volvoTurnRightCircleTest() {
        Volvo240 car = new Volvo240(0,0,-(Math.PI * 2) + (Math.PI / 180));
        car.turnRight();
        assert(car.getDirection() == 0);
    }
    @Test
    public void volvoGasTest(){
        Volvo240 car = new Volvo240();
        car.gas(1);
        assert(car.getCurrentSpeed() == car.speedFactor());
    }
    @Test
    public void volvoBrakeTest(){
        Volvo240 car = new Volvo240();
        car.gas(1);
        car.brake(1);
        assert (car.getCurrentSpeed() == 0);
    }
    @Test
    public void volvoMoveTest() {
        Volvo240 car = new Volvo240();
        car.gas(1);
        car.move();
        assert(car.getX() == car.speedFactor() && car.getY() == 0);
    }
    @Test
    public void saabTurboMoveTest(){
        Saab95 car = new Saab95();
        car.setTurboOn();
        car.gas(1);
        car.move();
        assert(car.getX() == car.speedFactor());
    }

    @Test
    public void saabTurnOffTurboTest(){
        Saab95 car = new Saab95();
        car.setTurboOn();
        car.setTurboOff();
        assert(!car.isTurboOn());
    }


}
