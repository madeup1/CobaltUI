package cc.cobalt.themes;

import cc.cobalt.themes.impl.DefaultTheme;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CobaltThemeManager
{
    private LinkedList<ITheme> themes;
    private ITheme theme;
    public void init()
    {
        themes = new LinkedList<>();

        add(new DefaultTheme());
        theme = themes.getFirst();
    }

    public void add(ITheme... themes)
    {
        this.themes.addAll(Arrays.stream(themes).collect(Collectors.toList()));
    }

    public void setSelected(String name)
    {

    }

    public ITheme getTheme()
    {
        return theme;
    }
}
