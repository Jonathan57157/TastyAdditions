package de.jonathan57157.food_mod_2.client.renderer;

import de.jonathan57157.food_mod_2.block.entity.custom.CuttingBoardBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;

public class CuttingBoardBlockEntityRenderer
        implements BlockEntityRenderer<CuttingBoardBlockEntity> {

    public CuttingBoardBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(CuttingBoardBlockEntity entity,
                       float tickDelta,
                       MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers,
                       int light,
                       int overlay) {

        if (entity.isEmpty()) return;

        matrices.push();

        // 📍 Position: Mitte des Blocks, leicht über dem Brett
        matrices.translate(0.5, 0.08, 0.5);

        // 🔄 Flach hinlegen
        matrices.multiply(
                net.minecraft.util.math.RotationAxis.POSITIVE_X.rotationDegrees(90)
        );

        // 📏 Skalierung
        matrices.scale(0.6f, 0.6f, 0.6f);

        MinecraftClient.getInstance()
                .getItemRenderer()
                .renderItem(
                        entity.getStack(),
                        ModelTransformationMode.FIXED,
                        light,
                        overlay,
                        matrices,
                        vertexConsumers,
                        entity.getWorld(),
                        0
                );

        matrices.pop();
    }
}
