package git.madeup.input.keyboard;

public interface IKeyboardInput
{
    KeyboardInputType getPressType();
    int getKeyCode();
    char getChar();
}
