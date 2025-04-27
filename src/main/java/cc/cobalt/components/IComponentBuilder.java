package cc.cobalt.components;

import cc.cobalt.settings.Setting;

public interface IComponentBuilder<T extends Setting<T>>
{
    IComponent build(T setting);
}
