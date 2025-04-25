package git.madeup.input.keyboard;

import git.madeup.input.keyboard.impl.KeyboardPressInput;

public interface IKeyboardInput
{
    KeyboardInputType getPressType();
    int getKeyCode();
    char getChar();
}
