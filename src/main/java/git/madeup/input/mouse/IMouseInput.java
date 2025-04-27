package git.madeup.input.mouse;

public interface IMouseInput
{
    MouseInputType getType();
    int getX();
    int getY();
    int getMouseButton();
}
