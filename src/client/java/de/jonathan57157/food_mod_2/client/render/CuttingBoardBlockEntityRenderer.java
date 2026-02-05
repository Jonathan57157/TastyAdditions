package de.jonathan57157.food_mod_2.client.render;

import de.jonathan57157.food_mod_2.block.entity.custom.CuttingBoardBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class CuttingBoardBlockEntityRenderer
        implements BlockEntityRenderer<CuttingBoardBlockEntity> {

    public CuttingBoardBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(
            CuttingBoardBlockEntity entity,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            int overlay
    ) {

        ItemStack stack = entity.getItems().get(0);

        if (stack.isEmpty()) {
            return;
        }

        matrices.push();

        matrices.translate(0.5, 0.08, 0.5);
        matrices.scale(0.5f, 0.5f, 0.5f);

        MinecraftClient.getInstance()
                .getItemRenderer()
                .renderItem(
                        stack,
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
