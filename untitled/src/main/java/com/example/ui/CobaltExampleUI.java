package com.example.ui;

import cc.cobalt.elements.impl.ModuleListElement;
import cc.cobalt.input.keyboard.impl.KeyboardPressInput;
import cc.cobalt.ui.CobaltUI;
import com.example.CobaltExample;
import com.example.modules.Categories;
import com.example.ui.elements.WatermarkElement;
import org.lwjgl.input.Keyboard;

public class CobaltExampleUI extends CobaltUI
{
    public CobaltExampleUI()
    {
        super("Example UI");
    }

    @Override
    public void init()
    {
        System.out.println("com.example.CobaltExampleUI:init():16");

        this.addElement(new WatermarkElement());
        this.addElement(new ModuleListElement(Categories.TEST, 300, 300));

        this.addKeyboardHook(k -> {
            switch (k.getPressType())
            {
                case Press:
                    this.handlePress(k);
            }
        });
    }

    public void handlePress(KeyboardPressInput input)
    {
        if (input.getKeyCode() == Keyboard.KEY_ESCAPE)
            CobaltExample.mc.displayGuiScreen(null);
    }

    @Override
    public void postInit()
    {

    }
}
