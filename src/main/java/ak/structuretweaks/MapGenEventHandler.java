package ak.structuretweaks;

import ak.structuretweaks.mapgen.*;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.structure.*;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

/**
 * Created by A.K. on 14/07/30.
 */
public class MapGenEventHandler {

    @SubscribeEvent
    public void mapGenEvent(InitMapGenEvent event) {
        if (event.type == InitMapGenEvent.EventType.CAVE && event.originalGen.getClass() == MapGenCaves.class) {
            FMLLog.info("[StructureTweaks]Change MapGenCaves");
            event.newGen = new MapGenCavesCustom();
            return;
        }

        if (event.type == InitMapGenEvent.EventType.MINESHAFT && event.originalGen.getClass() == MapGenMineshaft.class) {
            FMLLog.info("[StructureTweaks]Change MapGenMineshaft");
            event.newGen = new MapGenMineshaftCustom();
            return;
        }

        if (event.type == InitMapGenEvent.EventType.NETHER_BRIDGE && event.originalGen.getClass() == MapGenNetherBridge.class) {
            FMLLog.info("[StructureTweaks]Change MapGenNetherBridge");
            event.newGen = new MapGenNetherBridgeCustom();
            return;
        }

        if (event.type == InitMapGenEvent.EventType.NETHER_CAVE && event.originalGen.getClass() == MapGenCavesHell.class) {
            FMLLog.info("[StructureTweaks]Change MapGenCavesHell");
            event.newGen = new MapGenCavesHellCustom();
            return;
        }

        if (event.type == InitMapGenEvent.EventType.RAVINE && event.originalGen.getClass() == MapGenRavine.class) {
            FMLLog.info("[StructureTweaks]Change MapGenRavine");
            event.newGen = new MapGenRavineCustom();
            return;
        }

        if (event.type == InitMapGenEvent.EventType.SCATTERED_FEATURE && event.originalGen.getClass() == MapGenScatteredFeature.class) {
            FMLLog.info("[StructureTweaks]Change MapGenScatteredFeature");
            event.newGen = new MapGenScatteredFeatureCustom();
            return;
        }

        if (event.type == InitMapGenEvent.EventType.STRONGHOLD && event.originalGen.getClass() == MapGenStronghold.class) {
            FMLLog.info("[StructureTweaks]Change MapGenStronghold");
            event.newGen = new MapGenStrongholdCustom();
            return;
        }

        if (event.type == InitMapGenEvent.EventType.VILLAGE && event.originalGen.getClass() == MapGenVillage.class) {
            FMLLog.info("[StructureTweaks]Change MapGenVillage");
            event.newGen = new MapGenVillageCustom();
        }
    }
}
