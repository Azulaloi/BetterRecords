package com.codingforcookies.betterrecords.src.client.models;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.codingforcookies.betterrecords.src.StaticInfo;
import com.codingforcookies.betterrecords.src.client.BetterEventHandler;
import com.codingforcookies.betterrecords.src.client.ClientProxy;
import com.codingforcookies.betterrecords.src.items.TileEntityStrobeLight;

public class BlockStrobeLightRenderer extends TileEntitySpecialRenderer {
	public BlockStrobeLightRenderer() { }

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		if(!(te instanceof TileEntityStrobeLight))
			return;

		TileEntityStrobeLight tileEntityStrobeLight = (TileEntityStrobeLight)te;
		
		GL11.glPushMatrix();
		{
			GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			
			bindTexture(StaticInfo.modelStrobeLightRes);
			StaticInfo.modelStrobeLight.render((Entity)null, 0F, 0F, 0F, 0.0F, 0.0F, 0.0625F);

			GL11.glTranslatef(0.0F, 1.0F, 0.0F);
			
			if(tileEntityStrobeLight.bass != 0 && ClientProxy.flashyMode > 0) {
				float incr = (float) (2 * Math.PI / 10);
				
				GL11.glPushMatrix();
				{
		            GL11.glRotatef(RenderManager.instance.playerViewY - 180F, 0F, 1F, 0F);
		            GL11.glRotatef(RenderManager.instance.playerViewX, 1F, 0F, 0F);

					GL11.glDisable(GL11.GL_DEPTH_TEST);
					GL11.glDisable(GL11.GL_LIGHTING);
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					GL11.glEnable(GL11.GL_BLEND);
					
					for(float trans = .2F; trans < .6F; trans += .2F) {
						GL11.glScalef(.9F, .9F, 1F);
						GL11.glRotatef(20F, 0F, 0F, 1F);
						GL11.glBegin(GL11.GL_TRIANGLE_FAN);
						{
							GL11.glColor4f(1F, 1F, 1F, trans / (ClientProxy.flashyMode == 1 ? 3F : 1F));
							GL11.glVertex2f(0F, 0F);
							
							for(int i = 0; i < 10; i++) {
								float angle = incr * i;
								float xx = (float)Math.cos(angle) * tileEntityStrobeLight.bass;
								float yy = (float)Math.sin(angle) * tileEntityStrobeLight.bass;
								
								GL11.glVertex2f(xx, yy);
							}
							
							GL11.glVertex2f(tileEntityStrobeLight.bass, 0F);
						}
						GL11.glEnd();
					}
					
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_TEXTURE_2D);
					GL11.glEnable(GL11.GL_LIGHTING);
					GL11.glEnable(GL11.GL_DEPTH_TEST);
				}
				GL11.glPopMatrix();
				
				GL11.glColor4f(1F, 1F, 1F, 1F);
				
				if(ClientProxy.flashyMode > 1) {
					Minecraft mc = Minecraft.getMinecraft();
					float dist = (float)Math.sqrt(Math.pow(tileEntityStrobeLight.xCoord - mc.thePlayer.posX, 2) + Math.pow(tileEntityStrobeLight.yCoord - mc.thePlayer.posY, 2) + Math.pow(tileEntityStrobeLight.zCoord - mc.thePlayer.posZ, 2));
					if(dist < 4 * tileEntityStrobeLight.bass) {
						float newStrobe = Math.abs(dist - 4F * tileEntityStrobeLight.bass) / 100F;
						if(newStrobe > 0F && BetterEventHandler.strobeLinger < newStrobe)
							BetterEventHandler.strobeLinger = newStrobe;
					}
				}
			}
		}
		GL11.glPopMatrix();
	}
}