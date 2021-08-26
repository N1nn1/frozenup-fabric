package net.teamdraco.frozenup.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.teamdraco.frozenup.FrozenUp;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(EntityModelLayers.class)
public class EntityModelLayersMixin {
    @Inject(method = "create", at = @At("HEAD"), cancellable = true)
    private static void create(String id, String layer, CallbackInfoReturnable<EntityModelLayer> cir) {
        Identifier identifier = Identifier.tryParse(id);
        if (identifier != null && identifier.getNamespace().equals(FrozenUp.MOD_ID)) {
            cir.setReturnValue(new EntityModelLayer(identifier, layer));
        }
    }
}