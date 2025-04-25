package git.madeup.components;

import git.madeup.render.CobaltRenderContext;

import java.util.function.BiConsumer;

public class CobaltComponent
{
    private int width;
    private int height;

    private BiConsumer<CobaltComponent, CobaltRenderContext> consumer;

    public CobaltComponent(int width, int height, BiConsumer<CobaltComponent, CobaltRenderContext> consumer)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.consumer = consumer;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }
}
