package cc.cobalt.settings.impl;

import cc.cobalt.settings.Setting;

import java.util.function.Predicate;

/**
 * Creates a setting that, when clicked, runs.
 */
public class ClickableSetting extends Setting<Runnable>
{
    private Runnable runnable;

    public ClickableSetting(String name, Runnable runnable, Predicate<Boolean> predicate)
    {
        super(name, predicate);
    }

    public ClickableSetting(String name, Runnable runnable)
    {
        this(name, runnable, null);
    }

    @Override
    public void set(Runnable runnable)
    {

    }

    @Override
    public Runnable get()
    {
        return this.runnable;
    }
}
