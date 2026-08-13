package io.github.seggan.automation.items

import io.github.seggan.metis.runtime.intrinsics.NativeLibrary
import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType
import com.github.drakescraft_labs.slimefun4.implementation.items.blocks.UnplaceableBlock
import org.bukkit.inventory.ItemStack

class Peripheral(
    group: ItemGroup,
    item: SlimefunItemStack,
    val lib: NativeLibrary,
    recipeType: RecipeType,
    recipe: Array<out ItemStack>
) : UnplaceableBlock(group, item, recipeType, recipe)