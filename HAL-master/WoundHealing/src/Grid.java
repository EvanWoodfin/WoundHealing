import HAL.GridsAndAgents.PDEGrid2D;
import HAL.GridsAndAgents.AgentGrid2D;
import HAL.Gui.GridWindow;
import HAL.Util;

import static java.awt.geom.Point2D.distance;


public class Grid extends AgentGrid2D<Cell> {

    PDEGrid2D VEGF;

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

    public void DrawModel(GridWindow win) {
        for (int x = 0; x < Constants.x; x++) {
            for (int y = 0; y < Constants.y; y++) {
                int color = Util.BLACK;
                if (GetAgent(x, y) != null) {
                    Cell cell = GetAgent(x, y);
                    color = cell.color;
                }
                win.SetPix(x, y, color);
            }
        }
    }
    public void DrawRadius() {
        final int numEndos = 20;
        final int radius = (int) (Constants.x / 2.2);
        for (int i = 0; i < numEndos; i++) {
            int angle = i * 360 / numEndos;
            int x = (int) (Constants.x / 2.0 + radius * Math.cos(angle));
            int y = (int) (Constants.y / 2.0 + radius * Math.sin(angle));
            Cell endo = NewAgentSQ(x, y);
            VEGF.Add(x, y, 0.5);
            VEGF.Diffusion(0.25);
            endo.init(Constants.endoColor, Constants.endothelial, VEGF.Get(x, y), true, x, y);
            System.out.println(endo.VEGF);
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





