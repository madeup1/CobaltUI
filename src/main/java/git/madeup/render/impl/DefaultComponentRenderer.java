package git.madeup.render.impl;

import git.madeup.components.CobaltComponent;
import git.madeup.render.ComponentRenderer;
import git.madeup.settings.impl.ClickableSetting;

public class DefaultComponentRenderer extends ComponentRenderer
{

    @Override
    public void init()
    {
        this.create(ClickableSetting.class, setting -> {
            return new CobaltComponent(46, 20, (comp, ctx) -> {
                if (!setting.isVisible())
                    return;

                ctx.drawRect(comp.getX(), comp.getY(), comp.getWidth(), comp.getHeight());
            });
        });
    }
}
