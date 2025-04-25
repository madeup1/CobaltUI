package git.madeup.input.keyboard.impl;

import git.madeup.input.keyboard.IKeyboardInput;
import git.madeup.input.keyboard.KeyboardInputType;

public class KeyboardPressInput implements IKeyboardInput
{
    private final KeyboardInputType type;
    private final int keyCode;
    private final char typedChar;

    public KeyboardPressInput(int keyCode, char typedChar, KeyboardInputType type)
    {
        this.keyCode = keyCode;
        this.typedChar = typedChar;
        this.type = type;
    }

    @Override
    public KeyboardInputType getPressType()
    {
        return this.type;
    }

    @Override
    public int getKeyCode()
    {
        return this.keyCode;
    }

    @Override
    public char getChar()
    {
        return this.typedChar;
    }
}
