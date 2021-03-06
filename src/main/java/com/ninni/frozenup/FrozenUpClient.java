package com.ninni.frozenup;

import com.google.common.collect.ImmutableMap;
import com.ninni.frozenup.block.FrozenUpBlocks;
import com.ninni.frozenup.client.model.ChillooEntityModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import com.ninni.frozenup.client.client.init.FrozenUpEntityModelLayers;
import com.ninni.frozenup.client.renderer.ChillooEntityRenderer;
import com.ninni.frozenup.entity.FrozenUpEntities;

@Environment(EnvType.CLIENT)
public class FrozenUpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(FrozenUpEntities.CHILLOO, ChillooEntityRenderer::new);

        ImmutableMap.<EntityModelLayer, EntityModelLayerRegistry.TexturedModelDataProvider>of(
            FrozenUpEntityModelLayers.CHILLOO, ChillooEntityModel::getTexturedModelData
        ).forEach(EntityModelLayerRegistry::registerModelLayer);

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getCutout(),

            FrozenUpBlocks.EMPTY_MUG,
            FrozenUpBlocks.MUG_OF_MILK,
            FrozenUpBlocks.MUG_OF_CHOCOLATE_MILK,
            FrozenUpBlocks.MUG_OF_TRUFFLE_HOT_CHOCOLATE
        );
    }

    public static Identifier texture(String path) {
        return new Identifier(FrozenUp.MOD_ID, "textures/" + path + ".png");
    }
}
