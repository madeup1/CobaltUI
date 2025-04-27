package git.madeup.fonts;

import git.madeup.exceptions.CobaltFontException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class CobaltFontManager
{
    private HashMap<String, CobaltFontRenderer> fontMap = new HashMap<>();

    public void init()
    {
        this.fontMap.put("arial", new CobaltFontRenderer(Font.getFont("arial").deriveFont(19f), true, true));
    }

    public void put(String fontName, float fontSize, boolean antiAlias, boolean fractional)
    {
        try
        {
            fontMap.put(fontName, this.createFontRenderer(fontName, fontSize, antiAlias, fractional));
        } catch (Exception e)
        {
            fontMap.put(fontName, new CobaltFontRenderer(Font.getFont("arial").deriveFont(fontSize), antiAlias, fractional));

            new CobaltFontException("Failed to find/or make CobaltFontRenderer! Font was likely not found and null.\n\n" + e).printStackTrace();
        }
    }

    public CobaltFontRenderer createFontRenderer(String name, float fontSize, boolean antiAlias, boolean fractional) throws Exception
    {
        InputStream stream = this.getStream(name);

        if (stream == null)
        {
            return null;
        }

        Font font = Font.createFont(0, stream);
        font.deriveFont(fontSize);

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
