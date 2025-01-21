import HAL.GridsAndAgents.AgentSQ2D;

public class Cell extends AgentSQ2D<Grid> {

    int color;
    int type;
    int length = 0;
    int ticksSinceLastGrowth;
    int x;
    int y;
    double VEGF;
    boolean isTipCell;

    public void init(int color, int type, double VEGF, boolean isTipCell, int x, int y) {
        this.color = color;
        this.type = type;
        this.ticksSinceLastGrowth = 0;
        this.x = x;
        this.y = y;
        this.VEGF = VEGF;
        this.isTipCell = isTipCell;
    }

    public void step() {
        this.ticksSinceLastGrowth += 1;
        if (this.type == Constants.endothelial) {
            endoGrow();
        }
        if (this.type == Constants.epithelial) {
            epiGrow();
        }
    }

    public void endoGrow() {
        if (this.ticksSinceLastGrowth >= Constants.endoBranchDelayTime * Constants.ticksPerHour && this.VEGF >= Constants.endoBranchingVEGFThreshold) {

        }
    }

    public void epiGrow() {
        
    }

    public void stop() {

    }

}