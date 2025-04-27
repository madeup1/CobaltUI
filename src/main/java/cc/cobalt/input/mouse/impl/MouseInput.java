package cc.cobalt.input.mouse.impl;

import cc.cobalt.input.mouse.IMouseInput;
import cc.cobalt.input.mouse.MouseInputType;

public class MouseInput implements IMouseInput
{
    public static final int LEFT_CLICK = 0;
    public static final int RIGHT_CLICK = 1;
    public static final int MIDDLE_CLICK = 2;

    private final MouseInputType type;
    private final int x;
    private final int y;
    private final int mouseButton;

    public MouseInput(int x, int y, int mouseButton, MouseInputType type)
    {
        this.x = x;
        this.y = y;
        this.mouseButton = mouseButton;
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

    @Override
    public int getMouseButton()
    {
        return this.mouseButton;
    }
}
