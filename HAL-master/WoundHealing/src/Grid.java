import HAL.GridsAndAgents.PDEGrid2D;
import HAL.GridsAndAgents.AgentGrid2D;
import HAL.Gui.GridWindow;
import HAL.Util;

import static java.awt.geom.Point2D.distance;


public class Grid extends AgentGrid2D<Cell> {

    public final PDEGrid2D VEGF;

    public Grid(int x, int y, PDEGrid2D VEGF) {

        super(x, y, Cell.class);
        this.VEGF = VEGF;

        DrawRadius();
    }

    public static void main(String[] args){

        GridWindow window = new GridWindow(Constants.x, Constants.y, 4);
        PDEGrid2D VEGF = new PDEGrid2D(Constants.x, Constants.y);
        Grid grid = new Grid(Constants.x, Constants.y, VEGF);
        window.SetActive(true);
        grid.Run(window);

    }

    public void DrawModel(GridWindow win){
        for (int i = 0; i < win.length; i++) {
            int color = Util.BLACK;
            if (GetAgent(i) != null) {
                Cell cell = GetAgent(i);
                color = cell.color;
            }
            win.SetPix(i, color);
        }
    }

    public void DrawRadius() {
        int i = 0;
        for (int x = 0; x < Constants.x; x++) {
            for (int y = 0; y < Constants.y; y++) {
                double dist = distance(x, y, (double) Constants.x / 2, (double) Constants.y / 2);
                if (dist > Constants.radius) {
                    Cell agent = NewAgentSQ(x, y);
                    agent.init(Constants.epiColor, Constants.epithelial, 0, x, y);
                } else if (Math.abs(dist - Constants.radius) <= 1 && dist < Constants.radius) {
                    Cell agent = NewAgentSQ(x, y);
                    if (i % 20 == 0) {
                        agent.init(Constants.endoColor, Constants.endothelial, 0, x, y);
                } else {
                        agent.init(Constants.epiColor, Constants.epithelial, 0, x, y);
                    }
                    i++;
            }
        }

        }
    }

        public void Run (GridWindow window) {
            for (int i = 0; i < Constants.runtime; i++) {
                for (Cell a : this) {
                    a.step();
                }
                DrawModel(window);
            }
        }
    }





