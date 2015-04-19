package ak.structuretweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by A.K. on 14/07/29.
 */
@Mod(modid = "StructureTweaks", name = "StructureTweaks")
public class ST {

    @Mod.Instance("StructureTweaks")
    public static ST INSTANCE;

    //Cave
    public static final String CategoryCave = "Cave";
    public static boolean canGenerateCave = true;
    public static int genParamCave01 = 15;
    public static int genParamCave02 = 7;
    public static int genParamCave03 = 4;
    public static int genParamCave04 = 4;
    public static int genParamCave05 = 10;

    //NetherCave
    public static final String CategoryNetherCave = "NetherCave";
    public static boolean canGenerateNetherCave = true;
    public static int genParamNetherCave01 = 10;
    public static int genParamNetherCave02 = 5;
    public static int genParamNetherCave03 = 4;
    public static int genParamNetherCave04 = 4;

    //Ravine
    public static final String CategoryRavine = "Ravine";
    public static boolean canGenerateRavine = true;
    public static int genChanceRavine = 50;

    //MineShaft
    public static final String CategoryMineShaft = "MineShaft";
    public static boolean canGenerateMineShaft = true;
    public static double genChanceMineShaft = 0.004D;

    //Village
    public static final String CategoryVillage = "Village";
    public static boolean canGenerateVillage = true;
    public static int defaultVillageDistance = 32;
    public static int minVillageDistance = 8;

    //NetherBridge
    public static final String CategoryNetherBridge = "NetherBridge";
    public static boolean canGenerateNetherBridge = true;
    public static int genChanceNetherBridge = 3;
    public static int spawnChanceBlazeInNB = 10;
    public static int minGroupBlazeInNB = 2;
    public static int maxGroupBlazeInNB = 3;
    public static int spawnChancePigZombieInNB = 5;
    public static int minGroupPigZombieInNB = 4;
    public static int maxGroupPigZombieInNB = 4;
    public static int spawnChanceSkeletonInNB = 10;
    public static int minGroupSkeletonInNB = 4;
    public static int maxGroupSkeletonInNB = 4;
    public static int spawnChanceMagmaCubeInNB = 3;
    public static int minGroupMagmaCubeInNB = 4;
    public static int maxGroupMagmaCubeInNB = 4;

    //Stronghold
    public static final String CategoryStronghold = "Stronghold";
    public static boolean canGenerateStronghold = true;
    public static double defaultStrongholdDistance = 32.0D;
    public static int defaultStrongholdSpread = 3;

    //ScatteredFeature
    public static final String CategoryScatteredFeature = "ScatteredFeature";
    public static boolean canGenerateScatteredFeature = true;
    public static int maxScatteredFeatureDistance = 32;
    public static int minScatteredFeatureDistance = 8;
    public static int spawnChanceWitch = 1;
    public static int minGroupWitch = 1;
    public static int maxGroupWitch= 1;

    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        canGenerateCave = config.get(CategoryCave, "CaveGenerate", canGenerateCave, "洞窟を生成するかどうか").getBoolean();
        genParamCave01 = config.get(CategoryCave, "CaveGenerateParam01Value", genParamCave01, "洞窟生成パラメータその１：生成処理のFor文を回す回数を決定する因子").getInt();
        genParamCave02 = config.get(CategoryCave, "CaveGenerateParam02Value", genParamCave02, "洞窟生成パラメータその２：このパラメータ分の１の確率で生成処理を行う").getInt();
        genParamCave03 = config.get(CategoryCave, "CaveGenerateParam03Value", genParamCave03, "洞窟生成パラメータその３：このパラメータ分の１の確率で生成処理その１を行う").getInt();
        genParamCave04 = config.get(CategoryCave, "CaveGenerateParam04Value", genParamCave04, "洞窟生成パラメータその４：１～このパラメータのランダムな回数で生成処理その２を行う").getInt();
        genParamCave05 = config.get(CategoryCave, "CaveGenerateParam05Value", genParamCave05, "洞窟生成パラメータその５：このパラメータ分の１の確率で乱数処理を追加で行う").getInt();

        canGenerateNetherCave = config.get(CategoryNetherCave, "NetherCaveGenerate", canGenerateNetherCave, "ネザー洞窟を生成するかどうか").getBoolean();
        genParamNetherCave01 = config.get(CategoryNetherCave, "NetherCaveGenerateParam01Value", genParamNetherCave01, "ネザー洞窟生成パラメータその１：生成処理のFor文を回す回数を決定する因子").getInt();
        genParamNetherCave02 = config.get(CategoryNetherCave, "NetherCaveGenerateParam02Value", genParamNetherCave02, "洞窟生成パラメータその２：このパラメータ分の１の確率で生成処理を行う").getInt();
        genParamNetherCave03 = config.get(CategoryNetherCave, "NetherCaveGenerateParam03Value", genParamNetherCave03, "洞窟生成パラメータその３：このパラメータ分の１の確率で生成処理その１を行う").getInt();
        genParamNetherCave04 = config.get(CategoryNetherCave, "NetherCaveGenerateParam04Value", genParamNetherCave04, "洞窟生成パラメータその４：１～このパラメータのランダムな回数で生成処理その２を行う").getInt();

        canGenerateRavine = config.get(CategoryRavine, "RavineGenerate", canGenerateRavine, "渓谷を生成するかどうか").getBoolean();
        genChanceRavine = config.get(CategoryRavine, "RavineGenerateChanceValue", genChanceRavine, "渓谷生成パラメータ").getInt();

        canGenerateMineShaft = config.get(CategoryMineShaft, "MineShaftGenerate", canGenerateMineShaft, "廃坑を生成するかどうか").getBoolean();
        genChanceMineShaft = config.get(CategoryMineShaft, "MineShaftGenerateChanceValue", genChanceMineShaft, "廃坑生成パラメータ").getDouble();

        canGenerateVillage = config.get(CategoryVillage, "VillageGenerate", canGenerateVillage, "村を生成するかどうか").getBoolean();
        defaultVillageDistance = config.get(CategoryVillage, "VillageGenerateDistance", defaultVillageDistance, "村の生成距離").getInt();
        minVillageDistance = config.get(CategoryVillage, "VillageGenerationMinimalDistance", minVillageDistance, "村の最小生成距離").getInt();

        canGenerateNetherBridge = config.get(CategoryNetherBridge, "NetherBridgeGenerate", canGenerateNetherBridge, "ネザー要塞を生成するかどうか").getBoolean();
        genChanceNetherBridge = config.get(CategoryNetherBridge, "NetherBridgeGenerateChanceValue", genChanceNetherBridge, "要塞生成パラメータ").getInt();
        spawnChanceBlazeInNB = config.get(CategoryNetherBridge, "NetherBridgeBlazeSpawnChanceValue", spawnChanceBlazeInNB, "ブレイズのスポーンウエイト").getInt();
        minGroupBlazeInNB = config.get(CategoryNetherBridge, "NetherBridgeBlazeSpawnMinimalGroup", minGroupBlazeInNB, "ブレイズの最小同時スポーン数").getInt();
        maxGroupBlazeInNB = config.get(CategoryNetherBridge, "NetherBridgeBlazeSpawnMaximalGroup", maxGroupBlazeInNB, "ブレイズの最大同時スポーン数").getInt();
        spawnChancePigZombieInNB = config.get(CategoryNetherBridge, "NetherBridgePigZombieSpawnChanceValue", spawnChancePigZombieInNB, "ゾンビピッグマンのスポーンウエイト").getInt();
        minGroupPigZombieInNB = config.get(CategoryNetherBridge, "NetherBridgePigZombieSpawnMinimalGroup", minGroupPigZombieInNB, "ゾンビピッグマンの最小同時スポーン数").getInt();
        maxGroupPigZombieInNB = config.get(CategoryNetherBridge, "NetherBridgePigZombieSpawnMaximalGroup", maxGroupPigZombieInNB, "ゾンビピッグマンの最大同時スポーン数").getInt();
        spawnChanceSkeletonInNB = config.get(CategoryNetherBridge, "NetherBridgeSkeletonSpawnChanceValue", spawnChanceSkeletonInNB, "スケルトンのスポーンウエイト").getInt();
        minGroupSkeletonInNB = config.get(CategoryNetherBridge, "NetherBridgeSkeletonSpawnMinimalGroup", minGroupSkeletonInNB, "スケルトンの最小同時スポーン数").getInt();
        maxGroupSkeletonInNB = config.get(CategoryNetherBridge, "NetherBridgeSkeletonSpawnMaximalGroup", maxGroupSkeletonInNB, "スケルトンの最大同時スポーン数").getInt();
        spawnChanceMagmaCubeInNB = config.get(CategoryNetherBridge, "NetherBridgeSkeletonSpawnChanceValue", spawnChanceMagmaCubeInNB, "マグマキューブのスポーンウエイト").getInt();
        minGroupMagmaCubeInNB = config.get(CategoryNetherBridge, "NetherBridgeSkeletonSpawnMinimalGroup", minGroupMagmaCubeInNB, "マグマキューブの最小同時スポーン数").getInt();
        maxGroupMagmaCubeInNB = config.get(CategoryNetherBridge, "NetherBridgeSkeletonSpawnMaximalGroup", maxGroupMagmaCubeInNB, "マグマキューブの最大同時スポーン数").getInt();

        canGenerateStronghold = config.get(CategoryStronghold, "StrongholdGenerate", canGenerateStronghold, "遺跡を生成するかどうか").getBoolean();
        defaultStrongholdDistance = config.get(CategoryStronghold, "StrongholdDefaultDistance", defaultStrongholdDistance, "遺跡の生成距離").getDouble();
        defaultStrongholdSpread = config.get(CategoryStronghold, "StrongholdDefaultSpread", defaultStrongholdSpread, "遺跡の生成広さ").getInt();

        canGenerateScatteredFeature = config.get(CategoryScatteredFeature, "ScatteredFeatureGenerate", canGenerateScatteredFeature, "ピラミッド・寺院・魔女の家を生成するかどうか").getBoolean();
        maxScatteredFeatureDistance = config.get(CategoryScatteredFeature, "ScatteredFeatureMaximalDistance", maxScatteredFeatureDistance, "ピラミッド・寺院・魔女の家の最大生成距離").getInt();
        minScatteredFeatureDistance = config.get(CategoryScatteredFeature, "ScatteredFeatureMinimalDistance", minScatteredFeatureDistance, "ピラミッド・寺院・魔女の家の最小生成距離").getInt();
        spawnChanceWitch = config.get(CategoryScatteredFeature, "ScatteredFeatureWitchSpawnChanceValue", spawnChanceWitch, "ウィッチのスポーンウエイト").getInt();
        minGroupWitch = config.get(CategoryScatteredFeature, "ScatteredFeatureWitchSpawnMinimalGroup", minGroupWitch, "ウィッチの最小同時スポーン数").getInt();
        maxGroupWitch = config.get(CategoryScatteredFeature, "ScatteredFeatureWitchSpawnMaximalGroup", maxGroupWitch, "ウィッチの最大同時スポーン数").getInt();

        config.save();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.TERRAIN_GEN_BUS.register(new MapGenEventHandler());
    }
}
