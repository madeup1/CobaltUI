package git.madeup.settings.impl;

import git.madeup.settings.Setting;
import git.madeup.utils.MathUtils;

import java.util.function.Predicate;

/**
 * Creates a slider setting with a low and a high value,
 * allowing for a setting to represent a value between
 * low and high, which min and max being start and end
 * of the slider.
 */
public class RangeSetting extends Setting<Double>
{
    private double low;
    private double high;
    private double min;
    private double max;
    private double increment;

    public RangeSetting(String name, double low, double high, double min, double max, double increment)
    {
        super(name);

        this.low = low;
        this.high = high;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    public RangeSetting(String name, double low, double high, double min, double max, double increment, Predicate<Boolean> predicate)
    {
        super(name, predicate);

        this.low = low;
        this.high = high;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    @Override
    public void set(Double value)
    {

    }

    public double getLow()
    {
        return this.low;
    }

    public void setLow(double low)
    {
        if (low >= this.high)
        {
            this.high = low + this.increment;
        }

        this.low = MathUtils.clamp(this.min, this.max, low);
    }

    public double getHigh()
    {
        return this.high;
    }

    public void setHigh(double high)
    {
        if (this.low >= high)
        {
            this.low = high - this.increment;
        }

        this.high = MathUtils.clamp(this.min, this.max, high);
    }

    public double getMin()
    {
        return this.min;
    }

    public double getMax()
    {
        return this.max;
    }

    public double getIncrement()
    {
        return this.increment;
    }

    @Override
    public Double get()
    {
        return 0.0d;
    }
}
