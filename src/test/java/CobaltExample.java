import git.madeup.settings.impl.EnumSetting;
import git.madeup.settings.impl.RangeSetting;

public class CobaltExample
{
    private RangeSetting rotationTime = new RangeSetting("Rotation Time", 0, 1000, 160, 390, 10, a -> true);
    private EnumSetting<MacroState> defaultState = new EnumSetting<>("Default State", MacroState.Farming);

    public enum MacroState
    {
        Mining,
        Farming,
        GayButtSex;
    }
}
