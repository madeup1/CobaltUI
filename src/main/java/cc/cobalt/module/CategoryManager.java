package cc.cobalt.module;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager
{
    private final List<Category> categories;

    public CategoryManager()
    {
        this.categories = new ArrayList<>();
    }

    public Category make(String name)
    {
        Category category = new Category(name);
        categories.add(category);

        return category;
    }

    public List<Category> getCategories()
    {
        return categories;
    }
}
