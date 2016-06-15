package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenNetherBridge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.K. on 14/07/30.
 */
public class MapGenNetherBridgeCustom extends MapGenNetherBridge {

    private List<BiomeGenBase.SpawnListEntry> spawnList = new ArrayList<>();

    public MapGenNetherBridgeCustom() {
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityBlaze.class, ST.spawnChanceBlazeInNB, ST.minGroupBlazeInNB, ST.maxGroupBlazeInNB));
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, ST.spawnChancePigZombieInNB, ST.minGroupPigZombieInNB, ST.maxGroupPigZombieInNB));
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, ST.spawnChanceSkeletonInNB, ST.minGroupSkeletonInNB, ST.maxGroupSkeletonInNB));
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, ST.spawnChanceMagmaCubeInNB, ST.minGroupMagmaCubeInNB, ST.maxGroupMagmaCubeInNB));
    }

    @Override
    public List getSpawnList() {
        return spawnList;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        int k = chunkX >> 4;
        int l = chunkZ >> 4;
        this.rand.setSeed((long)(k ^ l << 4) ^ this.worldObj.getSeed());
        this.rand.nextInt();
        return ST.canGenerateNetherBridge && this.rand.nextInt(ST.genChanceNetherBridge) == 0 && chunkX == (k << 4) + 4 + this.rand.nextInt(8) && chunkZ == (l << 4) + 4 + this.rand.nextInt(8);
    }
}
