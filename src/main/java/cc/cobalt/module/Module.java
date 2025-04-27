package cc.cobalt.module;

import cc.cobalt.settings.Setting;
import cc.cobalt.utils.MilliTimer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Module
{
    private final String name;
    private int keycode;
    private final Category category;
    private MilliTimer timer;
    private boolean toggled = false;

    private ModuleFlag moduleFlag = ModuleFlag.None;
    private final List<Setting<?>> settings;

    public Module(String name, Category category)
    {
        this(name, 0, category);
    }

    public Module(String name, int keycode, Category category)
    {
        this.name = name;
        this.keycode = keycode;
        this.category = category;

        this.timer = new MilliTimer();
        this.settings = new ArrayList<>();

        this.category.addModule(this);
    }

    public abstract void onEnable();
    public abstract void onDisable();
    // return empty string if none;
    public abstract String getSuffix();

    public String getName()
    {
        return this.name;
    }

    public int getKeycode()
    {
        return keycode;
    }

    public void setKeycode(int keycode)
    {
        this.keycode = keycode;
    }

    public Category getCategory()
    {
        return category;
    }

    public ModuleFlag getModuleFlag()
    {
        return moduleFlag;
    }

    public void toggle()
    {
        this.setToggled(!toggled);
    }

    public void setToggled(boolean value)
    {
        if (value == toggled)
            return;

        toggled = value;

        if (toggled)
            this.onEnable();
        else
            this.onDisable();

        this.timer.reset();
    }

    public MilliTimer getTimer()
    {
        return timer;
    }

    public void addSettings(Setting<?>... settings)
    {
        this.settings.addAll(Arrays.stream(settings).collect(Collectors.toList()));
    }

    public List<Setting<?>> getSettings()
    {
        return settings;
    }

    public boolean isHidden()
    {
        return false;
    }
}
