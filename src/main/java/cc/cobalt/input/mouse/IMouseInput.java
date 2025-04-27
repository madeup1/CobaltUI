package cc.cobalt.input.mouse;

public interface IMouseInput
{
    MouseInputType getType();
    int getX();
    int getY();
    int getMouseButton();
}
