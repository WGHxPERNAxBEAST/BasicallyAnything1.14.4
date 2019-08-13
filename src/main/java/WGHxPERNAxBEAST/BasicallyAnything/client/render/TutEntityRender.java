package WGHxPERNAxBEAST.BasicallyAnything.client.render;

import WGHxPERNAxBEAST.BasicallyAnything.main;
import WGHxPERNAxBEAST.BasicallyAnything.client.models.TutEntityModel;
import WGHxPERNAxBEAST.BasicallyAnything.entities.TutEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class TutEntityRender extends LivingRenderer<TutEntity, TutEntityModel>{

	public TutEntityRender(EntityRendererManager manager) {
		super(manager, new TutEntityModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(TutEntity entity) {
		return main.location("textures/entity/tut_entity.png");
	}
	
	public static class RenderFactory implements IRenderFactory<TutEntity>{

		@Override
		public EntityRenderer<? super TutEntity> createRenderFor(EntityRendererManager manager) {
			return new TutEntityRender(manager);
		}
		
	}

}
