package kg.kloop.rinat.newcarel;


import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Этот класс содержит методы для отрисовки поля и Карела
 */
public class GameCanvas extends Object {
    public GameCanvas(TextView textView) {
        view = textView;
    }

    public void draw(CarelGrid grid) {
        changeCanvas(grid);

    }

    public void changeCanvas(CarelGrid grid) {
        view.setText("");
        drawWall(grid);
        view.append("\n");
        for (int i = 0; i < grid.getHeight(); i++) {
            view.append("|");
            for (int j = 0; j < grid.getWidth(); j++) {
                String sector = "";
                if (j == grid.getCarelX() && i == grid.getCarelY()) {
                    sector = drawCarel(Integer.toString(grid.getBeepersNumber(j, i)), grid);
                } else if (grid.getBeepersNumber(j,i) < 0){
                    sector = grid.buildWallBlock();
                } else {
                    sector = "    " + Integer.toString(grid.getBeepersNumber(j, i)) + "    ";
                }
                view.append(sector);
            }
            view.append("|");
            view.append("\n");
            if (i <= grid.getHeight() - 2) {
                view.append("\n");
            }
        }
        drawWall(grid);
    }

    private void drawWall(CarelGrid grid) {
        for (int i = 0; i < grid.getWidth(); i++) {
            view.append(" _____");
        }
        Log.v("CarelDebug", view.getText().toString());
    }

    private String drawCarel(String text, CarelGrid grid) {
        String carel = "";

        if (!grid.isCarelDead()) carel = "',(" + text + "):";
        else carel = "',(" + text + ")%";

        String carelHead = "";

        if (grid.getCarelDirectionX() == 1) carelHead = ">";
        else if (grid.getCarelDirectionX() == (-1)) carelHead = "<";
        else if (grid.getCarelDirectionY() == 1) carelHead = "^";
        else if (grid.getCarelDirectionY() == -1) carelHead = "v";

        return carel + carelHead;
    }

    private TextView view = null;
}
