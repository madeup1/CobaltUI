package git.madeup.components;

import git.madeup.settings.Setting;

public interface IComponentBuilder<T extends Setting<T>>
{
    CobaltComponent build(T setting);
}
