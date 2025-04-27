package git.madeup.themes;

import git.madeup.themes.impl.DefaultTheme;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CobaltThemeManager
{
    private LinkedList<ITheme> themes;
    private ITheme theme;
    public void init()
    {
        add(new DefaultTheme());
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
