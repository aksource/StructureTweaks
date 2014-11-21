package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.gen.structure.MapGenStronghold;

import java.util.Random;

/**
 * Created by A.K. on 14/07/30.
 */
public class MapGenStrongholdCustom extends MapGenStronghold {

    private double distance;
    private int spread;
    /**
     * is spawned false and set true once the defined BiomeGenBases were compared with the present ones
     */
    private boolean ranBiomeCheck;
    private ChunkCoordIntPair[] structureCoords;

    public MapGenStrongholdCustom() {
        this.structureCoords = new ChunkCoordIntPair[3];
        this.distance = ST.defaultStrongholdDistance;
        this.spread = ST.defaultStrongholdSpread;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        if (!this.ranBiomeCheck && ST.canGenerateStronghold)
        {
            Random random = new Random();
            random.setSeed(this.worldObj.getSeed());
            double d0 = random.nextDouble() * Math.PI * 2.0D;
            int l = 1;

            for (int i1 = 0; i1 < this.structureCoords.length; ++i1)
            {
                double d1 = (1.25D * (double)l + random.nextDouble()) * this.distance * (double)l;
                int j1 = (int)Math.round(Math.cos(d0) * d1);
                int k1 = (int)Math.round(Math.sin(d0) * d1);
                ChunkPosition chunkposition = this.worldObj.getWorldChunkManager().findBiomePosition((j1 << 4) + 8, (k1 << 4) + 8, 112, this.field_151546_e, random);

                if (chunkposition != null)
                {
                    j1 = chunkposition.chunkPosX >> 4;
                    k1 = chunkposition.chunkPosZ >> 4;
                }

                this.structureCoords[i1] = new ChunkCoordIntPair(j1, k1);
                d0 += (Math.PI * 2D) * (double)l / (double)this.spread;

                if (i1 == this.spread)
                {
                    l += 2 + random.nextInt(5);
                    this.spread += 1 + random.nextInt(2);
                }
            }

            this.ranBiomeCheck = true;
        }

        ChunkCoordIntPair[] achunkcoordintpair = this.structureCoords;

        for (ChunkCoordIntPair chunkcoordintpair : achunkcoordintpair)
        {
            if (chunkX == chunkcoordintpair.chunkXPos && chunkZ == chunkcoordintpair.chunkZPos)
            {
                return true;
            }
        }

        return false;
    }
}
