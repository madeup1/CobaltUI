package git.madeup.settings;

import java.util.function.Predicate;

public abstract class Setting<T>
{
    private final String name;
    private Predicate<Boolean> predicate = null;

    public Setting(String name)
    {
        this(name, null);
    }

    public Setting(String name, Predicate<Boolean> predicate)
    {
        this.name = name;
        this.predicate = predicate;
    }

    public abstract void set(T value);
    public abstract T get();

    public String getName()
    {
        return this.name;
    }

    public boolean isVisible()
    {
        return predicate != null && predicate.test(true);
    }
}
