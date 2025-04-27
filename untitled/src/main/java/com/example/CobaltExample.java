package com.example;

import cc.cobalt.CobaltGraphics;
import cc.cobalt.fonts.CobaltFontRenderer;
import cc.cobalt.fonts.ICobaltFontRenderer;
import com.example.commands.GuiCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = "cobalt", name = "Cobalt Example", version = "0.0.1")
public class CobaltExample
{
    public static Minecraft mc;
    public static GuiScreen screen;

    public CobaltExample()
    {

    }

    @Mod.EventHandler
    public void fmlPreInit(FMLPreInitializationEvent event) throws Exception
    {
        mc = Minecraft.getMinecraft();

        MinecraftForge.EVENT_BUS.register(new CobaltExample());
        ClientCommandHandler.instance.registerCommand(new GuiCommand());

        CobaltGraphics.init(CobaltGraphics.DEFAULT);

        CobaltFontRenderer font = CobaltGraphics.getFontManager().createFontRenderer("bold", 19, true, false);
        CobaltGraphics.getFontManager().setDefault(font);
        CobaltGraphics.getFontManager().put("bold", font);
    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event)
    {
        if (screen != null)
        {
            mc.displayGuiScreen(screen);

            screen = null;
        }
    }
}
