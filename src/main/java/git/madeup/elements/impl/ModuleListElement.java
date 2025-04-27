package git.madeup.elements.impl;

import git.madeup.elements.IElement;
import git.madeup.input.keyboard.impl.KeyboardPressInput;
import git.madeup.input.mouse.impl.MouseInput;
import git.madeup.ui.CobaltUI;

public class ModuleListElement implements IElement
{
    private int x;
    private int y;
    @Override
    public void init(CobaltUI ui)
    {

    }

    @Override
    public int getX()
    {
        return x;
    }

    @Override
    public int getY()
    {
        return y;
    }

    @Override
    public void setX(int x)
    {
        this.x = x;
    }

    @Override
    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public int getWidth()
    {
        return 0;
    }

    @Override
    public int getHeight()
    {
        return 0;
    }

    @Override
    public void setWidth(int width)
    {

    }

    @Override
    public void setHeight(int height)
    {

    }

    @Override
    public void mouseInput(MouseInput input)
    {

    }

    @Override
    public void keyboardInput(KeyboardPressInput input)
    {

    }

    @Override
    public String getName()
    {
        return "";
    }

    @Override
    public boolean isVisible()
    {
        return false;
    }

    @Override
    public void draw(int mouseX, int mouseY)
    {

    }
}
