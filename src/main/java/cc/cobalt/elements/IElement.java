package cc.cobalt.elements;

import cc.cobalt.input.keyboard.impl.KeyboardPressInput;
import cc.cobalt.input.mouse.impl.MouseInput;
import cc.cobalt.render.IDrawable;
import cc.cobalt.ui.CobaltUI;

public interface IElement extends IDrawable
{
    void init(CobaltUI ui);

    int getX();
    int getY();
    void setX(int x);
    void setY(int y);

    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);

    void mouseInput(MouseInput input);
    void keyboardInput(KeyboardPressInput input);
    String getName();

    boolean isVisible();

    default boolean isHovered(int mouseX, int mouseY)
    {
        return mouseX >= this.getX()
                && mouseX <= this.getX() + this.getWidth()
                && mouseY >= this.getY()
                && mouseY <= this.getY() + this.getHeight();
    }
}
