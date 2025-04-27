package cc.cobalt;

import cc.cobalt.fonts.CobaltFontManager;
import cc.cobalt.render.impl.DefaultComponentRenderer;
import cc.cobalt.themes.CobaltThemeManager;
import cc.cobalt.utils.BlurUtils;
import net.minecraft.client.Minecraft;

public class CobaltGraphics
{
    public static Minecraft mc;

    private static CobaltGraphicsBuilder settings;

    // handlers
    private static CobaltThemeManager themeManager = new CobaltThemeManager();
    private static CobaltFontManager fontManager = new CobaltFontManager();

    private static boolean inited = false;

    public static void init(CobaltGraphicsBuilder builder)
    {
        if (inited)
            return;

        mc = Minecraft.getMinecraft();

        settings = builder;
        inited = true;

        themeManager.init();
        fontManager.init();
        BlurUtils.init();
    }

    public static boolean isInited()
    {
        return inited;
    }

    public static CobaltGraphicsBuilder getSettings()
    {
        return settings;
    }

    public static CobaltThemeManager getThemeManager()
    {
        return themeManager;
    }

    public static CobaltFontManager getFontManager()
    {
        return fontManager;
    }

    public static final CobaltGraphicsBuilder DEFAULT = new CobaltGraphicsBuilder()
            .setComponentRenderer(new DefaultComponentRenderer());
}
