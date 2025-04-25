package git.madeup;

public class CobaltGraphics
{
    private static CobaltGraphicsBuilder settings;
    private static boolean inited = false;

    public static void init(CobaltGraphicsBuilder builder)
    {
        if (inited)
            return;

        settings = builder;
        inited = true;
    }

    public static boolean isInited()
    {
        return inited;
    }

    public static final CobaltGraphicsBuilder DEFAULT = new CobaltGraphicsBuilder();
}
