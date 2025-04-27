package git.madeup;

import git.madeup.fonts.ICobaltFontRenderer;
import git.madeup.render.ComponentRenderer;

public class CobaltGraphicsBuilder
{
    private ComponentRenderer componentRenderer;
    private ICobaltFontRenderer fontRenderer;

    public CobaltGraphicsBuilder setComponentRenderer(ComponentRenderer componentRenderer)
    {
        this.componentRenderer = componentRenderer;

        return this;
    }

    public CobaltGraphicsBuilder setDefaultFont(ICobaltFontRenderer fontRenderer)
    {
        this.fontRenderer = fontRenderer;

        return this;
    }

    public ComponentRenderer getComponentRenderer()
    {
        return this.componentRenderer;
    }

    public ICobaltFontRenderer getFontRenderer()
    {
        return this.fontRenderer;
    }
}
