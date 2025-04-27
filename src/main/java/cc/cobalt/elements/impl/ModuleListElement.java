package cc.cobalt.elements.impl;

import cc.cobalt.CobaltGraphics;
import cc.cobalt.elements.IElement;
import cc.cobalt.fonts.ICobaltFontRenderer;
import cc.cobalt.input.keyboard.impl.KeyboardPressInput;
import cc.cobalt.input.mouse.impl.MouseInput;
import cc.cobalt.module.Category;
import cc.cobalt.themes.ITheme;
import cc.cobalt.ui.CobaltUI;
import cc.cobalt.utils.RenderUtils;

import java.awt.*;

public class ModuleListElement implements IElement
{
    private Category category;
    private CobaltUI ui;
    private int width;
    private int x;
    private int y;

    private int offX = -1;
    private int offY = -1;

    private boolean extended = false;

    public ModuleListElement(Category category, int x, int y)
    {
        this.category = category;
        this.x = x;
        this.y = y;

        this.width = (int) CobaltGraphics.getFontManager().getDefault().getStringWidth(category.getName()) + 70;
    }

    @Override
    public void init(CobaltUI ui)
    {
        this.ui = ui;
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
        return width;
    }

    @Override
    public int getHeight()
    {
        if (!extended)
            return 20;
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
            case Hold:
                if (input.getMouseButton() == 0)
                {
                    if (offX == -1)
                    {
                        offX = (input.getX() - this.x);
                        offY = (input.getY() - this.y);
                    }

                    this.setX(input.getX() - offX);
                    this.setY(input.getY() - offY);
                }
                break;
            case Release:
                if (input.getMouseButton() == 0)
                {
                    offX = -1;
                    offY = -1;
                }
                break;
            case Press:
                if (input.getMouseButton() == 1)
                {
                    extended = !extended;
                }
        }
    }

    @Override
    public void keyboardInput(KeyboardPressInput input)
    {

    }

    @Override
    public String getName()
    {
        return category.getName();
    }

    @Override
    public boolean isVisible()
    {
        return true;
    }

    @Override
    public void draw(int mouseX, int mouseY)
    {
        ITheme theme = CobaltGraphics.getThemeManager().getTheme();
        ICobaltFontRenderer font = CobaltGraphics.getFontManager().getDefault();

        if (extended)
        {
            RenderUtils.drawBorderedRoundedRect(
                    this.x, this.y, this.getWidth(), this.getHeight(), 2.0f, 1.5f,
                    theme.getPrimaryColor().getRGB(), theme.getPrimaryColor().getRGB()
            );
        }

        RenderUtils.drawBorderedRoundedRect(
                this.x, this.y, this.getWidth(), 20, 2.0f, 1.5f,
                theme.getPrimaryColor().getRGB(), theme.getPrimaryColor().getRGB()
        );

        font.drawCenteredString(
                category.getName(), this.x + ((double) this.getWidth() / 2), this.getY() + 6,
                theme.getSecondaryColor().getRGB()
        );
    }
}
