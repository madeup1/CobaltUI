package com.example.commands;

import com.example.CobaltExample;
import com.example.ui.CobaltExampleUI;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class GuiCommand extends CommandBase
{

    @Override
    public String getCommandName() {
        return "gui";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException
    {
        // This is where I want it to send something in chat.

        CobaltExample.screen = new CobaltExampleUI();
    }

}
