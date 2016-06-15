package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenCavesHell;

/**
 * Created by A.K. on 14/07/31.
 */
public class MapGenCavesHellCustom extends MapGenCavesHell {
    @Override
    protected void func_151538_a(World world, int chunkX, int chunkZ, int baseChunkX, int baseChunkZ, Block[] blocks) {
        if (!ST.canGenerateNetherCave) {
            return;
        }
        int i1 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(ST.genParamNetherCave01) + 1) + 1);

        if (this.rand.nextInt(ST.genParamNetherCave02) != 0)
        {
            i1 = 0;
        }

        for (int j1 = 0; j1 < i1; ++j1)
        {
            double d0 = (double)(chunkX * 16 + this.rand.nextInt(16));
            double d1 = (double)this.rand.nextInt(128);
            double d2 = (double)(chunkZ * 16 + this.rand.nextInt(16));
            int k1 = 1;

            if (this.rand.nextInt(ST.genParamNetherCave03) == 0)
            {
                this.func_151544_a(this.rand.nextLong(), baseChunkX, baseChunkZ, blocks, d0, d1, d2);
                k1 += this.rand.nextInt(ST.genParamNetherCave04);
            }

            for (int l1 = 0; l1 < k1; ++l1)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();
                this.func_151543_a(this.rand.nextLong(), baseChunkX, baseChunkZ, blocks, d0, d1, d2, f2 * 2.0F, f, f1, 0, 0, 0.5D);
            }
        }
    }
}
