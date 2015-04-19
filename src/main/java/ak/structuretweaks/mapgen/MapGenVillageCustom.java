package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.world.gen.structure.MapGenVillage;

import java.util.Random;

/**
 * Created by A.K. on 14/07/30.
 */
public class MapGenVillageCustom extends MapGenVillage {
    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        if (!ST.canGenerateVillage) {
            return false;
        }
        int k = chunkX;
        int l = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= ST.defaultVillageDistance - 1;
        }

        if (chunkZ < 0)
        {
            chunkZ -= ST.defaultVillageDistance - 1;
        }

        int i1 = chunkX / ST.defaultVillageDistance;
        int j1 = chunkZ / ST.defaultVillageDistance;
        Random random = this.worldObj.setRandomSeed(i1, j1, 10387312);
        i1 *= ST.defaultVillageDistance;
        j1 *= ST.defaultVillageDistance;
        i1 += random.nextInt(ST.defaultVillageDistance - ST.minVillageDistance);
        j1 += random.nextInt(ST.defaultVillageDistance - ST.minVillageDistance);

        if (k == i1 && l == j1)
        {
            boolean flag = this.worldObj.getWorldChunkManager().areBiomesViable(k * 16 + 8, l * 16 + 8, 0, villageSpawnBiomes);

            if (flag)
            {
                return true;
            }
        }

        return false;
    }
}
