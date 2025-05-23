package com.example.ui.elements;

import cc.cobalt.elements.IElement;
import cc.cobalt.input.keyboard.impl.KeyboardPressInput;
import cc.cobalt.input.mouse.impl.MouseInput;
import cc.cobalt.ui.CobaltUI;

import static cc.cobalt.input.mouse.MouseInputType.Press;

public class WatermarkElement implements IElement
{
    private CobaltUI ui;
    private int x = 20;
    private int y = 20;
    @Override
    public void init(CobaltUI ui)
    {
        this.ui = ui;
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
    public void setX(int x)
    {
        // make unmovable
    }

    @Override
    public void setY(int y)
    {
        // make unmovable
    }

    @Override
    public int getWidth()
    {
        return 100;
    }

    @Override
    public int getHeight()
    {
        return 100;
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
        switch (input.getType())
        {
            case Press:
                System.out.println("Pressed watermark!");
                break;
        }
    }

    @Override
    public void keyboardInput(KeyboardPressInput input)
    {

    }

    @Override
    public String getName()
    {
        return "Watermark";
    }

    @Override
    public boolean isVisible()
    {
        return true;
    }

    @Override
    public void draw(int mouseX, int mouseY)
    {

    }
}
