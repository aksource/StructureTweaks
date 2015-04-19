package ak.structuretweaks.mapgen;

import ak.structuretweaks.ST;
import net.minecraft.world.gen.structure.MapGenMineshaft;

/**
 * Created by A.K. on 14/07/30.
 */
public class MapGenMineshaftCustom extends MapGenMineshaft {
    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        return ST.canGenerateMineShaft && this.rand.nextDouble() < ST.genChanceMineShaft && this.rand.nextInt(80) < Math.max(Math.abs(chunkX), Math.abs(chunkZ));
    }
}
