import HAL.GridsAndAgents.AgentSQ2D;

public class Cell extends AgentSQ2D<Grid> {

    int color;
    int type;
    int length = 0;
    int ticksSinceLastGrowth;
    int x;
    int y;
    int VEGF;

    public void init(int color, int type, int VEGF, int x, int y) {
        this.color = color;
        this.type = type;
        this.ticksSinceLastGrowth = 0;
        this.x = x;
        this.y = y;
        this.VEGF = VEGF;
    }

    public void step() {
        this.ticksSinceLastGrowth += 1;
        if (this.type == Constants.endothelial) {
            endoGrow(this);
        }
        if (this.type == Constants.epithelial) {
            epiGrow(this);
        }
    }

    public void endoGrow(Cell cell) {
        if (this.ticksSinceLastGrowth >= Constants.endoBranchDelayTime * Constants.ticksPerHour && this.VEGF >= Constants.endoBranchingVEGFThreshold) {

        }
    }

    public void epiGrow(Cell cell) {
        
    }

}