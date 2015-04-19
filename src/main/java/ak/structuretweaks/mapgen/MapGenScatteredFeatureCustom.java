package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by A.K. on 14/07/30.
 */
public class MapGenScatteredFeatureCustom extends MapGenScatteredFeature {
    private static List<BiomeGenBase> biomelist = Arrays.asList(BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland);

    /** contains possible spawns for scattered features */
    private List<BiomeGenBase.SpawnListEntry> scatteredFeatureSpawnList = new ArrayList<>();

    public MapGenScatteredFeatureCustom() {
        this.scatteredFeatureSpawnList.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, ST.spawnChanceWitch, ST.minGroupWitch, ST.maxGroupWitch));
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        if (!ST.canGenerateScatteredFeature) {
            return false;
        }
        int k = chunkX;
        int l = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= ST.maxScatteredFeatureDistance - 1;
        }

        if (chunkZ < 0)
        {
            chunkZ -= ST.maxScatteredFeatureDistance - 1;
        }

        int i1 = chunkX / ST.maxScatteredFeatureDistance;
        int j1 = chunkZ / ST.maxScatteredFeatureDistance;
        Random random = this.worldObj.setRandomSeed(i1, j1, 14357617);
        i1 *= ST.maxScatteredFeatureDistance;
        j1 *= ST.maxScatteredFeatureDistance;
        i1 += random.nextInt(ST.maxScatteredFeatureDistance - ST.minScatteredFeatureDistance);
        j1 += random.nextInt(ST.maxScatteredFeatureDistance - ST.minScatteredFeatureDistance);

        if (k == i1 && l == j1)
        {
            BiomeGenBase biomegenbase = this.worldObj.getWorldChunkManager().getBiomeGenAt(k * 16 + 8, l * 16 + 8);
            for (BiomeGenBase biomeGenBase1 : biomelist) {
                if (biomegenbase == biomeGenBase1)
                {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List getScatteredFeatureSpawnList() {
        return this.scatteredFeatureSpawnList;
    }
}
