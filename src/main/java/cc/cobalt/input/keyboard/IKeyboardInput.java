package cc.cobalt.input.keyboard;

public interface IKeyboardInput
{
    KeyboardInputType getPressType();
    int getKeyCode();
    char getChar();
}
