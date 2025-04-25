package git.madeup.input.mouse.impl;

import git.madeup.input.mouse.IMouseInput;
import git.madeup.input.mouse.MouseInputType;

public class MouseMoveInput implements IMouseInput
{
    private final MouseInputType type;
    private final int x;
    private final int y;

    public MouseMoveInput(int x, int y, MouseInputType type)
    {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public MouseInputType getType()
    {
        return type;
    }

    @Override
    public int getX()
    {
        return this.x;
    }

    @Override
    public int getY()
    {
        return this.y;
    }
}
