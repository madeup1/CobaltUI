package cc.cobalt.fonts;

import cc.cobalt.exceptions.CobaltFontException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class CobaltFontManager
{
    private final HashMap<String, CobaltFontRenderer> fontMap = new HashMap<>();
    private CobaltFontRenderer defaultFont = null;

    public CobaltFontRenderer getDefault()
    {
        return defaultFont;
    }

    public void setDefault(CobaltFontRenderer defaultFont)
    {
        this.defaultFont = defaultFont;
    }

    public void init()
    {
        this.fontMap.put("default", new CobaltFontRenderer(new Font("default", 0, 19), true, true));

        this.defaultFont = this.fontMap.get("default");
    }

    public boolean has(String key)
    {
        return this.fontMap.containsKey(key);
    }

    public CobaltFontRenderer get(String fontName)
    {
        return this.fontMap.get(fontName);
    }

    public void put(String fontName, int fontSize, boolean antiAlias, boolean fractional)
    {
        try
        {
            fontMap.put(fontName, this.createFontRenderer(fontName, fontSize, antiAlias, fractional));
        } catch (Exception e)
        {
            fontMap.put(fontName, new CobaltFontRenderer(Font.getFont("arial").deriveFont((float) fontSize), antiAlias, fractional));

            new CobaltFontException("Failed to find/or make CobaltFontRenderer! Font was likely not found and null.\n\n" + e).printStackTrace();
        }
    }

    public void put(String name, CobaltFontRenderer font)
    {
        fontMap.put(name, font);
    }

    public CobaltFontRenderer createFontRenderer(String name, int fontSize, boolean antiAlias, boolean fractional) throws Exception
    {
        InputStream stream = this.getStream(name);

        if (stream == null)
        {
            return null;
        }

        Font font = Font.createFont(0, stream);
        font = font.deriveFont((float) fontSize);

        return new CobaltFontRenderer(font, antiAlias, fractional);
    }

    public InputStream getStream(String name) throws IOException
    {
        return Minecraft
                .getMinecraft()
                .getResourceManager()
                .getResource(new ResourceLocation("cobalt", "fonts/" + name + ".ttf"))
                .getInputStream();
    }
}
