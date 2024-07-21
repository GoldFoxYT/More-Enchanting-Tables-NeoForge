package net.goldfoxyt.met.block.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static java.lang.Math.PI;

public class ColoredEnchantingTableRenderer implements BlockEntityRenderer<ColoredEnchantingTableBlockEntity> {
    public static final ResourceLocation BOOK_TEXTURE = ResourceLocation.withDefaultNamespace("textures/entity/enchanting_table_book.png");
    private final BookModel bookModel;

    public ColoredEnchantingTableRenderer(BlockEntityRendererProvider.Context context) {
        this.bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }

    @Override
    public void render(ColoredEnchantingTableBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0.75D, 0.5D);
        float f = (float)blockEntity.time + partialTick;
        poseStack.translate(0.0D, 0.1F + Mth.sin(f * 0.1F) * 0.01F, 0.0D);

        float f1;
        for(f1 = blockEntity.rot - blockEntity.oRot; f1 >= (float) PI; f1 -= ((float) PI * 2F)) {
        }

        while(f1 < -(float) PI) {
            f1 += ((float) PI * 2F);
        }

        float f2 = blockEntity.oRot + f1 * partialTick;
        poseStack.mulPose(Axis.YP.rotation(-f2));
        poseStack.mulPose(Axis.ZP.rotationDegrees(80.0F));
        float f3 = Mth.lerp(partialTick, blockEntity.oFlip, blockEntity.flip);
        float f4 = Mth.frac(f3 + 0.25F) * 1.6F - 0.3F;
        float f5 = Mth.frac(f3 + 0.75F) * 1.6F - 0.3F;
        float f6 = Mth.lerp(partialTick, blockEntity.oOpen, blockEntity.open);
        this.bookModel.setupAnim(f, Mth.clamp(f4, 0.0F, 1.0F), Mth.clamp(f5, 0.0F, 1.0F), f6);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entitySolid(BOOK_TEXTURE));
        this.bookModel.render(poseStack, vertexconsumer, packedLight, packedOverlay, -1);

        poseStack.popPose();
    }
}