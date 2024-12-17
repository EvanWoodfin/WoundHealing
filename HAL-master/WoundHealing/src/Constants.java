import HAL.Util;

import static HAL.Util.RGB;

public class Constants {

    public static double radius = 100;
    public static boolean diabetic = false;
    public static final int ticksPerHour = 100;
    public static final int runtimeHours = 72;
    public static final int runtime = ticksPerHour * runtimeHours;

    public static final int numEndosStart = (int) (radius * 10);
    public static final int numFibrosStart = (int) (radius * 5);

    public static final int endoBranchDelayTime = 6;//Hours
    public static final double endoSightRadiusMicrons = 200; //How far away (in microns) can endos see VEGF
    public static final double endoMigrationRate = 50; //microns per hour
    public static final double endoBranchProbability = 0.55; // Probability when VEGF is above a certain theshold
    public static final double endoBranchingVEGFThreshold = 0.05; //Threshold of VEGF required to branch
    public static final double endoVEGFIntake = 0.001; //Amount of VEGF consumed by a blood vessel cell present in a patch
    public static final double endoVEGFSensetivity = 0.025; //Minimum VEGF amount to be sensed by EC

    public static double fibroVEGFProducedPGPerML = 0.0;

    public static final double epiMigrationRate = 40;
    public static final double diffusionCoefficient = 0.733;

    public static final int endothelial = 0;
    public static final int epithelial = 1;
    public static final int fibroblast = 2;

    public static final int endoColor = Util.RED;
    public static final int epiColor = Util.WHITE;
    public static final int fibroColor = Util.GREEN;

    public static final int x = 200;
    public static final int y = 200;

}
