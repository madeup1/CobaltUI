package git.madeup.themes;

import java.awt.*;

public interface ITheme
{
    Color getPrimaryColor();
    Color getSecondaryColor();
    // Color getPrimaryColor(int index);
    Color getSecondaryColor(int index);

    String getName();
}
