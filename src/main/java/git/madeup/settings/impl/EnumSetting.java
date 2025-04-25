package git.madeup.settings.impl;

import git.madeup.settings.Setting;

import java.util.function.Predicate;

/**
 * Creates a EnumSetting that can have a value
 * from an Enum.
 * Be warned, it will use the Enum's VALUE_NAME
 * @param <T> T = Enum
 */
public class EnumSetting<T extends Enum<?>> extends Setting<T>
{
    private T value;

    public EnumSetting(String name, T defaultValue, Predicate<Boolean> predicate)
    {
        super(name, predicate);

        this.value = defaultValue;
    }

    public EnumSetting(String name, T defaultValue)
    {
        this(name, defaultValue, null);
    }

    @Override
    public void set(T value)
    {
        this.value = value;
    }

    @Override
    public T get()
    {
        return value;
    }
}
