package cc.cobalt.settings.impl;

import cc.cobalt.settings.Setting;
import org.lwjgl.input.Keyboard;

import java.util.function.Predicate;

public class KeybindSetting extends Setting<Integer>
{
    private int value;

    public KeybindSetting(String name, int value, Predicate<Boolean> predicate)
    {
        super(name, predicate);

        this.value = value;
    }

    public KeybindSetting(String name, int value)
    {
        this(name, value, null);
    }

    public boolean isPressed()
    {
        return Keyboard.isKeyDown(this.value);
    }

    @Override
    public void set(Integer value)
    {
        this.value = value;
    }

    @Override
    public Integer get()
    {
        return value;
    }
}
