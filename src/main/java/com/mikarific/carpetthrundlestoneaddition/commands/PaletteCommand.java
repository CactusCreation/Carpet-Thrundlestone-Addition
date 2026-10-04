package com.mikarific.carpetthrundlestoneaddition.commands;

import carpet.utils.CommandHelper;
import carpet.utils.Messenger;
import com.mikarific.carpetthrundlestoneaddition.CarpetThrundlestoneSettings;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;

public class PaletteCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext buildContext) {
        dispatcher.register(Commands.literal("palette")
                .requires((player) -> CommandHelper.canUseCommand(player, CarpetThrundlestoneSettings.commandPalette))
                .then(Commands.literal("bits").executes((context) -> getBits(context.getSource(), context.getSource().getPlayerOrException().blockPosition()))
                        .then(Commands.argument("pos", BlockPosArgument.blockPos()).executes((context) -> getBits(context.getSource(), BlockPosArgument.getLoadedBlockPos(context, "pos"))))
                )
                .then(Commands.literal("size").executes((context) -> getSize(context.getSource(), context.getSource().getPlayerOrException().blockPosition()))
                        .then(Commands.argument("pos", BlockPosArgument.blockPos()).executes((context) -> getSize(context.getSource(), BlockPosArgument.getLoadedBlockPos(context, "pos"))))
                )
                .then(Commands.literal("posInfo")
                        .then(Commands.argument("pos", BlockPosArgument.blockPos()).executes((context) -> posInfo(context.getSource(), BlockPosArgument.getLoadedBlockPos(context, "pos"), false, null))
                                .then(Commands.literal("full").executes((context) -> posInfo(context.getSource(), BlockPosArgument.getLoadedBlockPos(context, "pos"), true, null))
                                        .then(Commands.argument("block", BlockStateArgument.block(buildContext)).executes((context) -> posInfo(context.getSource(), BlockPosArgument.getLoadedBlockPos(context, "pos"), true, BlockStateArgument.getBlock(context, "block").getState())))
                                )
                                .then(Commands.literal("normal").executes((context) -> posInfo(context.getSource(), BlockPosArgument.getLoadedBlockPos(context, "pos"), false, null))
                                        .then(Commands.argument("block", BlockStateArgument.block(buildContext)).executes((context) -> posInfo(context.getSource(), BlockPosArgument.getLoadedBlockPos(context, "pos"), false, BlockStateArgument.getBlock(context, "block").getState())))
                                )
                        )
                )
        );
    }

    private static int getBits(CommandSourceStack source, BlockPos blockPos) throws CommandSyntaxException {
        ServerLevel level = source.getLevel();
        LevelChunk chunk = level.getChunkAt(blockPos);

        // TODO: Get bits
        int bits = 0;

        Messenger.m(source, "w Palette bit size: ", Messenger.s(String.valueOf(bits), "t"));
        return 1;
    }

    private static int getSize(CommandSourceStack source, BlockPos blockPos) throws CommandSyntaxException {
        ServerLevel level = source.getLevel();
        LevelChunk chunk = level.getChunkAt(blockPos);

        // TODO: Get size
        int size = 0;

        if (true) {
            Messenger.m(source, "w Palette size: ", Messenger.s(String.valueOf(size), "t"));
        } else {
            Messenger.m(source, "w Palette size MAX aka ", Messenger.s(String.valueOf(size), "t"));
        }
        return 1;
    }

    private static int posInfo(CommandSourceStack source, BlockPos blockPos, boolean isFull, BlockState blockState) throws CommandSyntaxException {
        ServerLevel level = source.getLevel();
        LevelChunk chunk = level.getChunkAt(blockPos);

        // TODO: posInfo
        return 1;
    }
}
