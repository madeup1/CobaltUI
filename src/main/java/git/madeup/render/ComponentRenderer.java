package git.madeup.render;

import git.madeup.components.IComponentBuilder;
import git.madeup.settings.Setting;

import java.util.HashMap;

public abstract class ComponentRenderer
{
    private final HashMap<Class<? extends Setting<?>>, IComponentBuilder<?>> builders = new HashMap<>();



    /**
     * REGISTER ALL RENDER FUNCS HERE PLEASE
     */
    public abstract void init();


    public <T extends Setting<T>> void create(Class<? extends Setting<?>> clasz, IComponentBuilder<T> builder)
    {
        this.builders.put(clasz, builder);
    }
}
