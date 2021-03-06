package com.mineaurion.aurionvotelistener.sponge.commands;

import com.mineaurion.aurionvotelistener.sponge.AurionVoteListener;
import com.mineaurion.aurionvotelistener.sponge.config.Config;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

public class VoteCommand implements CommandExecutor {
    private AurionVoteListener plugin;

    public VoteCommand(AurionVoteListener plugin){
        this.plugin = plugin;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args){
        Config config = plugin.getConfig();
        if(config.settings.vote.command){
            for(String message: config.settings.vote.message){
                src.sendMessage(plugin.getUtils().formatJoinMessage(message, src.getName()));
            }
        }
        return CommandResult.success();
    }
}
