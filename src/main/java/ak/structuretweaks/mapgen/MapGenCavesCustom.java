package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenCaves;

/**
 * Created by A.K. on 14/07/31.
 */
public class MapGenCavesCustom extends MapGenCaves {
    @Override
    protected void func_151538_a(World world, int chunkX, int chunkZ, int baseChunkX, int baseChunkZ, Block[] blocks) {
        if (!ST.canGenerateCave) {
            return;
        }
        int i1 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(ST.genParamCave01) + 1) + 1);

        if (this.rand.nextInt(ST.genParamCave02) != 0)
        {
            i1 = 0;
        }

        for (int j1 = 0; j1 < i1; ++j1)
        {
            double d0 = (double)(chunkX * 16 + this.rand.nextInt(16));
            double d1 = (double)this.rand.nextInt(this.rand.nextInt(120) + 8);
            double d2 = (double)(chunkZ * 16 + this.rand.nextInt(16));
            int k1 = 1;

            if (this.rand.nextInt(ST.genParamCave03) == 0)
            {
                this.func_151542_a(this.rand.nextLong(), baseChunkX, baseChunkZ, blocks, d0, d1, d2);
                k1 += this.rand.nextInt(ST.genParamCave04);
            }

            for (int l1 = 0; l1 < k1; ++l1)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();

                if (this.rand.nextInt(ST.genParamCave05) == 0)
                {
                    f2 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
                }

                this.func_151541_a(this.rand.nextLong(), baseChunkX, baseChunkZ, blocks, d0, d1, d2, f2, f, f1, 0, 0, 1.0D);
            }
        }
    }
}
