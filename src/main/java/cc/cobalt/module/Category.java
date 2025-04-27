package cc.cobalt.module;

import java.util.ArrayList;
import java.util.List;

public class Category
{
    private List<Module> modules = new ArrayList<>();
    private final String name;

    public Category(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public List<Module> getModules()
    {
        return modules;
    }

    public void addModule(Module module)
    {
        this.modules.add(module);
    }
}
