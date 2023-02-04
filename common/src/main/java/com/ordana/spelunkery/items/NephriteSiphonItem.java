package com.ordana.spelunkery.items;

import com.ordana.spelunkery.configs.ClientConfigs;
import com.ordana.spelunkery.utils.TranslationUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class NephriteSiphonItem extends BlockItem {
    public NephriteSiphonItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag context) {
        if (ClientConfigs.ENABLE_TOOLTIPS.get()) {
            if (!Screen.hasShiftDown()) {
                tooltip.add(TranslationUtils.CROUCH.component());
            }
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("tooltip.spelunkery.nephrite_siphon_1").setStyle(Style.EMPTY.applyFormat(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("tooltip.spelunkery.nephrite_siphon_2").setStyle(Style.EMPTY.applyFormat(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("tooltip.spelunkery.nephrite_siphon_3").setStyle(Style.EMPTY.applyFormat(ChatFormatting.GRAY)));
            }
        }
    }
}