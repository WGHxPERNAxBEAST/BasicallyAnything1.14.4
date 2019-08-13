package WGHxPERNAxBEAST.BasicallyAnything.client.render;

import WGHxPERNAxBEAST.BasicallyAnything.entities.TutEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class TutRenderRegistry {
	
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TutEntity.class, new TutEntityRender.RenderFactory());
	}
}
