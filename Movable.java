/**
 * Interface for movable objects.
 * NOTE: Does not incluude any required attributes (X position, direction, etc).
 */
public interface Movable {
    void move();
    void turnLeft();
    void turnRight();
}
