package git.madeup.settings.impl;

import git.madeup.settings.Setting;
import git.madeup.utils.MathUtils;

import java.util.function.Predicate;

public class SliderSetting extends Setting<Double>
{
    private double value;
    private final double min;
    private final double max;

    public SliderSetting(String name, double value, double min, double max)
    {
        this(name, value, min, max, null);
    }

    public SliderSetting(String name, double value, double min, double max, Predicate<Boolean> predicate)
    {
        super(name, predicate);

        this.value = value;
        this.min = min;
        this.max = max;
    }

    @Override
    public void set(Double value)
    {
        this.value = MathUtils.clamp(min, max, value);
    }

    @Override
    public Double get()
    {
        return this.value;
    }
}
