package com.example.ui;

import com.example.ui.elements.WatermarkElement;
import git.madeup.ui.CobaltUI;

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
    }

    @Override
    public void postInit()
    {

    }
}
