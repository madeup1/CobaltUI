package cc.cobalt.ui;

import cc.cobalt.CobaltGraphics;
import cc.cobalt.elements.IElement;
import cc.cobalt.exceptions.CobaltInitException;
import cc.cobalt.hook.IHook;
import cc.cobalt.hook.IKeyboardHook;
import cc.cobalt.hook.IMouseHook;
import cc.cobalt.hook.IRenderHook;
import cc.cobalt.input.keyboard.KeyboardInputType;
import cc.cobalt.input.keyboard.impl.KeyboardPressInput;
import cc.cobalt.input.mouse.MouseInputType;
import cc.cobalt.input.mouse.impl.MouseInput;
import net.minecraft.client.gui.GuiScreen;

import java.util.*;

public abstract class CobaltUI extends GuiScreen
{
    private String name;
    private List<IElement> elements = new ArrayList<>();
    private final boolean[] mouseState = new boolean[3];
    private HashMap<String, Object> objectMap = new HashMap<>();
    private LinkedList<IRenderHook> renderHooks = new LinkedList<>();
    private LinkedList<IKeyboardHook> keyboardHooks = new LinkedList<>();
    private LinkedList<IMouseHook> mouseHooks = new LinkedList<>();

    public CobaltUI(String name)
    {
        if (!CobaltGraphics.isInited())
        {
            throw new CobaltInitException("Failed due to no init call!");
        }

        this.init();

        // do what i want with elements to init
        elements.forEach(c -> {
            System.out.println("Element: " + c.getName());

            c.init(this);
        });

        this.postInit();
    }

    // abstract stuff

    /**
     * This is where you register all your elements.
     */
    public abstract void init();
    public abstract void postInit();

    public List<IElement> getElements()
    {
        return elements;
    }

    public void addKeyboardHook(IKeyboardHook hook)
    {
        this.keyboardHooks.add(hook);
    }

    public void addMouseHook(IMouseHook hook)
    {
        this.mouseHooks.add(hook);
    }

    public void addRenderHook(IRenderHook hook)
    {
        this.renderHooks.add(hook);
    }

    public void hook(IHook hook)
    {
        hook.hook();
    }

    public Object getObject(String key)
    {
        if (objectMap.containsKey(key))
            return objectMap.get(key);
        return null;
    }

    public boolean hasKey(String key)
    {
        return objectMap.containsKey(key);
    }

    public void setObject(String key, Object object)
    {
        objectMap.put(key, object);
    }

    public Object getSelected()
    {
        return objectMap.get("selected");
    }

    public boolean isSomethingSelected()
    {
        return objectMap.containsKey("selected");
    }

    public void setSelected(Object object)
    {
        if (object == null)
        {
            this.objectMap.remove("selected");

            return;
        }

        this.objectMap.put("selected", object);
    }

    public void addElement(IElement element)
    {
        this.elements.add(element);
    }

    public void addElements(IElement... elements)
    {
        Arrays.stream(elements)
                .forEach(this::addElement);
    }

    @Override
    public void initGui()
    {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.renderHooks.forEach(c -> {
            c.render(mouseX, mouseY, partialTicks);
        });

        this.elements
                .stream()
                .filter(IElement::isVisible)
                .forEach(c -> {
                    if (c.isHovered(mouseX, mouseY))
                    {
                        for (int i = 0; i < 3; i++)
                        {
                            if (!mouseState[i])
                                continue;

                            c.mouseInput(new MouseInput(mouseX, mouseY, i, MouseInputType.Hold));
                        }

                        c.mouseInput(new MouseInput(mouseX, mouseY, 0, MouseInputType.Hover));
                    }

                    c.draw(mouseX, mouseY);
                });
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        this.mouseHooks.forEach(c -> {
            c.mouseInput(new MouseInput(mouseX, mouseY, mouseButton, MouseInputType.Press));
        });

        this.elements
                .stream()
                .filter(IElement::isVisible)
                .filter(c -> c.isHovered(mouseX, mouseY))
                .findFirst()
                .ifPresent(c -> {
                    c.mouseInput(new MouseInput(mouseX, mouseY, mouseButton, MouseInputType.Press));
                });

        mouseState[mouseButton] = true;
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton)
    {
        this.mouseHooks.forEach(c -> {
            c.mouseInput(new MouseInput(mouseX, mouseY, mouseButton, MouseInputType.Release));
        });

        this.elements
                .stream()
                .filter(IElement::isVisible)
                .filter(c -> c.isHovered(mouseX, mouseY))
                .findFirst()
                .ifPresent(c -> {
                    c.mouseInput(new MouseInput(mouseX, mouseY, mouseButton, MouseInputType.Release));
                });

        mouseState[mouseButton] = false;
    }

    @Override
    public void keyTyped(char typedChar, int keyCode)
    {
        this.keyboardHooks.forEach(c -> {
            c.keyboardInput(new KeyboardPressInput(keyCode, typedChar, KeyboardInputType.Press));
        });

        this.elements
                .stream()
                .filter(IElement::isVisible)
                .forEach(c -> {
                    c.keyboardInput(new KeyboardPressInput(keyCode, typedChar, KeyboardInputType.Press));
                });
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public String getName()
    {
        return this.name;
    }
}
