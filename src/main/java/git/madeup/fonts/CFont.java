package git.madeup.fonts;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class CFont
{
    float imgSize;
    CharData[] charData;
    Font font;
    boolean antiAlias;
    boolean fractionalMetrics;
    int fontHeight;
    int charOffset;
    DynamicTexture tex;

    public CFont(final Font font, final boolean antiAlias, final boolean fractionalMetrics) {
        this.imgSize = 512.0f;
        this.charData = new CharData[256];
        this.fontHeight = -1;
        this.charOffset = 0;
        this.font = font;
        this.antiAlias = antiAlias;
        this.fractionalMetrics = fractionalMetrics;
        this.tex = this.setupTexture(font, antiAlias, fractionalMetrics, this.charData);
    }

    protected DynamicTexture setupTexture(final Font font, final boolean antiAlias, final boolean fractionalMetrics, final CharData[] chars) {
        final BufferedImage img = this.generateFontImage(font, antiAlias, fractionalMetrics, chars);
        try {
            return new DynamicTexture(img);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected BufferedImage generateFontImage(final Font font, final boolean antiAlias, final boolean fractionalMetrics, final CharData[] chars) {
        final int imgSize = (int)this.imgSize;
        final BufferedImage bufferedImage = new BufferedImage(imgSize, imgSize, 2);
        final Graphics2D graphics = (Graphics2D)bufferedImage.getGraphics();
        graphics.setFont(font);
        graphics.setColor(new Color(255, 255, 255, 0));
        graphics.fillRect(0, 0, imgSize, imgSize);
        graphics.setColor(Color.WHITE);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, fractionalMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antiAlias ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        final FontMetrics fontMetrics = graphics.getFontMetrics();
        int charHeight = 0;
        int positionX = 0;
        int positionY = 1;
        for (int index = 0; index < chars.length; ++index) {
            final char c = (char)index;
            final CharData charData = new CharData();
            final Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(c), graphics);
            charData.width = dimensions.getBounds().width + 8;
            charData.height = dimensions.getBounds().height;
            if (positionX + charData.width >= imgSize) {
                positionX = 0;
                positionY += charHeight;
                charHeight = 0;
            }
            if (charData.height > charHeight) {
                charHeight = charData.height;
            }
            charData.storedX = positionX;
            charData.storedY = positionY;
            if (charData.height > this.fontHeight) {
                this.fontHeight = charData.height;
            }
            chars[index] = charData;
            graphics.drawString(String.valueOf(c), positionX + 2, positionY + fontMetrics.getAscent());
            positionX += charData.width;
        }
        return bufferedImage;
    }

    public void drawChar(final CharData[] chars, final char c, final double x, final double y) throws ArrayIndexOutOfBoundsException {
        if (chars[c] == null) {
            return;
        }
        this.drawQuad(x, y, chars[c].width, chars[c].height, chars[c].storedX, chars[c].storedY, chars[c].width, chars[c].height);
    }

    protected void drawQuad(final double x2, final double y2, final double width, final double height, final double srcX, final double srcY, final double srcWidth, final double srcHeight) {
        final double renderSRCX = srcX / this.imgSize;
        final double renderSRCY = srcY / this.imgSize;
        final double renderSRCWidth = srcWidth / this.imgSize;
        final double renderSRCHeight = srcHeight / this.imgSize;
        GL11.glTexCoord2f((float) (renderSRCX + renderSRCWidth), (float) renderSRCY);
        GL11.glVertex2d(x2 + width, y2);
        GL11.glTexCoord2f((float) renderSRCX, (float) renderSRCY);
        GL11.glVertex2d(x2, y2);
        GL11.glTexCoord2f((float) renderSRCX, (float) (renderSRCY + renderSRCHeight));
        GL11.glVertex2d(x2, y2 + height);
        GL11.glTexCoord2f((float) renderSRCX, (float) (renderSRCY + renderSRCHeight));
        GL11.glVertex2d(x2, y2 + height);
        GL11.glTexCoord2f((float) (renderSRCX + renderSRCWidth), (float) (renderSRCY + renderSRCHeight));
        GL11.glVertex2d(x2 + width, y2 + height);
        GL11.glTexCoord2f((float) (renderSRCX + renderSRCWidth), (float) renderSRCY);
        GL11.glVertex2d(x2 + width, y2);
    }

    public void drawMultiColoredCharTB(final CharData[] chars, final char c, final double x, final double y, final int topColor, final int bottomColor) throws ArrayIndexOutOfBoundsException {
        if (chars[c] == null) {
            return;
        }
        this.drawQuadTB(x, y, chars[c].width, chars[c].height, chars[c].storedX, chars[c].storedY, chars[c].width, chars[c].height, topColor, bottomColor);
    }

    public void drawMulticoloredCharLR(final CharData[] chars, final char c, final double x, final double y, final int leftColor, final int rightColor) throws ArrayIndexOutOfBoundsException {
        if (chars[c] == null) {
            return;
        }
        this.drawQuadLR(x, y, (double)chars[c].width, (double)chars[c].height, (double)chars[c].storedX, (float) chars[c].storedY, (float) chars[c].width, (float) chars[c].height, leftColor, rightColor);
    }

    protected void drawQuadTB(final double x2, final double y2, final double width, final double height, final double srcX, final double srcY, final double srcWidth, final double srcHeight, final int topColor, final int bottomColor) {
        final double renderSRCX = srcX / this.imgSize;
        final double renderSRCY = srcY / this.imgSize;
        final double renderSRCWidth = srcWidth / this.imgSize;
        final double renderSRCHeight = srcHeight / this.imgSize;
        GlStateManager.color((topColor >> 16 & 0xFF) / 255.0f, (topColor >> 8 & 0xFF) / 255.0f, (topColor & 0xFF) / 255.0f);
        GL11.glTexCoord2f((float) (renderSRCX + renderSRCWidth), (float) renderSRCY);
        GL11.glVertex2d(x2 + width, y2);
        GL11.glTexCoord2f((float) renderSRCX, (float) renderSRCY);
        GL11.glVertex2d(x2, y2);
        GlStateManager.color((bottomColor >> 16 & 0xFF) / 255.0f, (bottomColor >> 8 & 0xFF) / 255.0f, (bottomColor & 0xFF) / 255.0f);
        GL11.glTexCoord2f((float) renderSRCX, (float) (renderSRCY + renderSRCHeight));
        GL11.glVertex2d(x2, y2 + height);
        GL11.glTexCoord2f((float) renderSRCX, (float) (renderSRCY + renderSRCHeight));
        GL11.glVertex2d(x2, y2 + height);
        GL11.glTexCoord2f((float) (renderSRCX + renderSRCWidth), (float) (renderSRCY + renderSRCHeight));
        GL11.glVertex2d(x2 + width, y2 + height);
        GlStateManager.color((topColor >> 16 & 0xFF) / 255.0f, (topColor >> 8 & 0xFF) / 255.0f, (topColor & 0xFF) / 255.0f);
        GL11.glTexCoord2f((float) (renderSRCX + renderSRCWidth), (float) renderSRCY);
        GL11.glVertex2d(x2 + width, y2);
    }

    protected void drawQuadLR(final double x2, final double y2, final double width, final double height, final double srcX, final float srcY, final float srcWidth, final float srcHeight, final int leftColor, final int rightColor) {
        final float renderSRCX = (float) (srcX / this.imgSize);
        final float renderSRCY = srcY / this.imgSize;
        final float renderSRCWidth = srcWidth / this.imgSize;
        final float renderSRCHeight = srcHeight / this.imgSize;
        GlStateManager.color((rightColor >> 16 & 0xFF) / 255.0f, (rightColor >> 8 & 0xFF) / 255.0f, (rightColor & 0xFF) / 255.0f);
        GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
        GL11.glVertex2d(x2 + width, y2);
        GlStateManager.color((leftColor >> 16 & 0xFF) / 255.0f, (leftColor >> 8 & 0xFF) / 255.0f, (leftColor & 0xFF) / 255.0f);
        GL11.glTexCoord2f(renderSRCX, renderSRCY);
        GL11.glVertex2d(x2, y2);
        GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
        GL11.glVertex2d(x2, y2 + height);
        GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
        GL11.glVertex2d(x2, y2 + height);
        GlStateManager.color((rightColor >> 16 & 0xFF) / 255.0f, (rightColor >> 8 & 0xFF) / 255.0f, (rightColor & 0xFF) / 255.0f);
        GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
        GL11.glVertex2d(x2 + width, y2 + height);
        GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
        GL11.glVertex2d(x2 + width, y2);
    }

    public void setAntiAlias(final boolean antiAlias) {
        if (this.antiAlias != antiAlias) {
            this.antiAlias = antiAlias;
            this.tex = this.setupTexture(this.font, antiAlias, this.fractionalMetrics, this.charData);
        }
    }

    public boolean isFractionalMetrics() {
        return this.fractionalMetrics;
    }

    public void setFractionalMetrics(final boolean fractionalMetrics) {
        if (this.fractionalMetrics != fractionalMetrics) {
            this.fractionalMetrics = fractionalMetrics;
            this.tex = this.setupTexture(this.font, this.antiAlias, fractionalMetrics, this.charData);
        }
    }

    public void setFont(final Font font) {
        this.font = font;
        this.tex = this.setupTexture(font, this.antiAlias, this.fractionalMetrics, this.charData);
    }

    protected static class CharData
    {
        public int width;
        public int height;
        public int storedX;
        public int storedY;
    }
}
