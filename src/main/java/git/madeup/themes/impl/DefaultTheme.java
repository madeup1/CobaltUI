package git.madeup.themes.impl;

import git.madeup.themes.ITheme;

import java.awt.*;

public class DefaultTheme implements ITheme
{
    private static final Color primaryColor = new Color(15, 15, 15);
    private static final Color secondaryColor = new Color(205, 205, 205);



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
