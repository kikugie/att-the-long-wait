package com.bawnorton.allthetrims.mixin.client.compat.jei;

import com.bawnorton.allthetrims.client.implementation.jei.JeiPluginImpl;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import mezz.jei.library.plugins.vanilla.anvil.SmithingRecipeCategory;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.SmithingRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;

@Pseudo
@Mixin(SmithingRecipeCategory.class)
public abstract class SmithingRecipeCategoryMixin {
    @ModifyReturnValue(method = "isHandled(Lnet/minecraft/recipe/RecipeEntry;)Z", at = @At("RETURN"))
    private boolean onlyHandleTransformations(boolean original, @Local(argsOnly = true) RecipeEntry<SmithingRecipe> recipe) {
        return !JeiPluginImpl.isTrimmingRecipe(recipe.value());
    }
}
