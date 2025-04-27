package cc.cobalt.fonts;

import java.awt.*;

public interface ICobaltFontRenderer
{
    int drawStringWithShadow(String text, double x, double y, int color);
    int drawSmoothStringWithShadow(String text, double x, double y, int color);
    int drawSmoothCenteredStringWithShadow(String text, double x, double y, int color);
    int drawString(String text, double x, double y, int color);
    int drawNoBSString(String text, double x, double y, int color);
    double drawSmoothString(String text, double x, double y, int color);
    double drawSmoothCenteredString(String text, double x, double y, int color);
    double drawCenteredString(String text, double x, double y, int color);
    double drawNoBSCenteredString(String text, double x, double y, int color);
    double drawCenteredStringWithShadow(String text, double x, double y, int color);
    double drawString(String text, double x, double y, int color, boolean shadow, double kerning);
    double drawSmoothString(String text, double x, double y, int color, boolean shadow);
    double drawSmoothCenteredString(String text, double x, double y, int topColor, int bottomColor);
    double drawSmoothMultiColoredStringTB(final String text, double x, double y, final int topColor, final int bottomColor, final boolean shadow);
    double drawSmoothMultiColoredStringLR(final String text, double x, double y, final int topColor, final int rightColor);
    double drawNoBSString(String text, double x, double y, int color, boolean shadow);
    double getStringWidth(String text);
    double getStringWidth(String text, float kerning);
    int getHeight();
    void setAntiAlias(boolean antiAlias);
    void setFractionalMetrics(boolean value);
}
