package cc.cobalt;

import cc.cobalt.fonts.ICobaltFontRenderer;
import cc.cobalt.render.ComponentRenderer;

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
