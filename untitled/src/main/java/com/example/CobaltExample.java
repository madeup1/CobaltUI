package com.example;

import com.example.commands.GuiCommand;
import git.madeup.CobaltGraphics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = "examplemod", name = "cbexmpl", version = "0.0.1")
public class CobaltExample
{
    public static Minecraft mc;
    public static GuiScreen screen;

    public CobaltExample()
    {

    }

    @Mod.EventHandler
    public void fmlPreInit(FMLPreInitializationEvent event)
    {
        mc = Minecraft.getMinecraft();

        MinecraftForge.EVENT_BUS.register(new CobaltExample());

        ClientCommandHandler.instance.registerCommand(new GuiCommand());

        CobaltGraphics.init(CobaltGraphics.DEFAULT);
    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event)
    {
        if (screen != null)
            mc.displayGuiScreen(screen);
    }
}
