package git.madeup.ui;

import git.madeup.CobaltGraphics;
import git.madeup.CobaltGraphicsBuilder;
import git.madeup.exceptions.CobaltInitException;
import net.minecraft.client.gui.GuiScreen;

public class CobaltUI extends GuiScreen
{
    private String name;
    public CobaltUI(String name)
    {
        if (!CobaltGraphics.isInited())
        {
            throw new CobaltInitException("Failed due to no init call!");
        }
    }



    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public String getName()
    {
        return name;
    }
}
