package git.madeup.settings.impl;

import git.madeup.settings.Setting;

import java.util.function.Predicate;

/**
 * Creates a setting that can be typed in.
 */
public class StringSetting extends Setting<String>
{
    private String value;
    private int maxLength;

    public StringSetting(String name, String value, int maxLength, Predicate<Boolean> predicate)
    {
        super(name, predicate);

        this.value = value;
        this.maxLength = maxLength;
    }

    public StringSetting(String name, String value, Predicate<Boolean> predicate)
    {
        this(name, value, 32, predicate);
    }

    public StringSetting(String name, String value, int maxLength)
    {
        this(name, value, maxLength, null);
    }

    public StringSetting(String name, String value)
    {
        this(name, value, 32);
    }

    @Override
    public void set(String value)
    {
        if (this.value.length() > 32)
            return;

        this.value = value;
    }

    @Override
    public String get()
    {
        return "";
    }
}
