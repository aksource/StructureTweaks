package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenRavine;

/**
 * Created by A.K. on 14/07/31.
 */
public class MapGenRavineCustom extends MapGenRavine {
    @Override
    protected void func_151538_a(World world, int chunkX, int chunkZ, int baseChunkX, int baseChunkZ, Block[] blocks) {
        if (ST.canGenerateRavine && this.rand.nextInt(ST.genChanceRavine) == 0)
        {
            double d0 = (double)(chunkX * 16 + this.rand.nextInt(16));
            double d1 = (double)(this.rand.nextInt(this.rand.nextInt(40) + 8) + 20);
            double d2 = (double)(chunkZ * 16 + this.rand.nextInt(16));
            byte b0 = 1;

            for (int i1 = 0; i1 < b0; ++i1)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;
                this.func_151540_a(this.rand.nextLong(), baseChunkX, baseChunkZ, blocks, d0, d1, d2, f2, f, f1, 0, 0, 3.0D);
            }
        }
    }
}
