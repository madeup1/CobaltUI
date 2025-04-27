package cc.cobalt.themes.impl;

import cc.cobalt.themes.ITheme;

import java.awt.*;

public class DefaultTheme implements ITheme
{
    private static final Color primaryColor = new Color(20, 20, 20);
    private static final Color secondaryColor = new Color(35, 150, 190);



    @Override
    public Color getPrimaryColor()
    {
        return primaryColor;
    }

    @Override
    public Color getSecondaryColor()
    {
        return secondaryColor;
    }

    @Override
    public Color getSecondaryColor(int index)
    {
        return secondaryColor;
    }

    @Override
    public String getName()
    {
        return "Classic";
    }
}
