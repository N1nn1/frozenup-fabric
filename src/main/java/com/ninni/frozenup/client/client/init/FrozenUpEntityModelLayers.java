package com.ninni.frozenup.client.client.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import com.ninni.frozenup.FrozenUp;
import com.ninni.frozenup.mixin.client.EntityModelLayersInvoker;

@Environment(EnvType.CLIENT)
public class FrozenUpEntityModelLayers {
    public static final EntityModelLayer CHILLOO = registerMain("chilloo");

    private static EntityModelLayer registerMain(String id) { return EntityModelLayersInvoker.register(new Identifier(FrozenUp.MOD_ID, id).toString(), "main"); }
}