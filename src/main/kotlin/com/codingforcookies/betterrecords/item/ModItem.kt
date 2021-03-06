package com.codingforcookies.betterrecords.item

import com.codingforcookies.betterrecords.BetterRecords
import com.codingforcookies.betterrecords.ID
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry

open class ModItem(val name: String): Item() {

    fun register() = this.apply {
        GameRegistry.register(this.setRegistryName(name))
        unlocalizedName = "$ID.$name"
        creativeTab = BetterRecords.creativeTab
    }

    fun registerRender() {
        Minecraft.getMinecraft().renderItem.itemModelMesher.register(this, 0, ModelResourceLocation("$ID:$name", "inventory"))
    }
}
