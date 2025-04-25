package git.madeup.utils;

public class MathUtils
{
    public static double clamp(double min, double max, double value)
    {
        if (min > value)
            return min;
        else if (max < value)
            return max;
        return value;
    }
}
