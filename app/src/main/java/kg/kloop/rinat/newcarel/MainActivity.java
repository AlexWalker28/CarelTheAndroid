package kg.kloop.rinat.newcarel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CarelGrid grid;
    private GameCanvas canvas;
    private Carel carel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        //Здесь пишем, что Карел должен делать.********************








        //Дальше ничего не меняем.*********************************




    }//Здесь пишем новые методы.***********************************

    private void makeRightDiagonal() {
        while (true){
            if (!isBeeper()) {
                dropBeeper();
            }
            if(isFrontClear()){
                move();
            } else break;
            turnLeft();
            if(isFrontClear()){
                move();
            }else break;
            turnRight();
        }
    }

    private void goToRightCornerOfX() {
        turnAround();
        moveToWall();
        turnLeft();
        move();
    }

    private void moveToWall() {
        while (isFrontClear()){
            move();
        }
    }

    private void makeLeftDiagonal() {
        while (true) {
            if (!isBeeper()) {
                dropBeeper();
            }
            if (isFrontClear()) {
                move();
            } else break;
            turnRight();
            if (isFrontClear()) {
                move();
            } else break;
            turnLeft();
        }
    }

    private void makeChessField(){
        while (true){
            makeChessLine();
            if(isBeeper()){
                turnRight();
                if(isFrontClear()){
                    move();
                }else break;
                turnRight();
                move();
            } else if (!isBeeper()){
                turnRight();
                if(isFrontClear()){
                    move();
                } else break;
                turnRight();
            }
            makeChessLine();
            turnLeft();
            if(isFrontClear()){
                move();
            } else break;
            turnLeft();
        }
    }

    private void makeChessLine() {
        while (true){
            dropBeeper();
            if(isFrontClear()){
                move();
            } else break;
            if(isFrontClear()){
                move();
            } else break;
        }
    }


    private void makeChessBoard(){
        while (true) {
            makeFirstLine();
            goBack();
            turnLeft();
            if (isFrontClear()) {
                move();
            } else break;
            turnLeft();
            makeSecondLine();
            goBack();
            turnLeft();
            if (isFrontClear()) {
                move();
            } else break;
            turnLeft();
        }
    }

    private void makeFirstLine() {
        while(true){
            dropBeeper();
            if(isFrontClear()){
                move();
            } else break;
            if(isFrontClear()){
                move();
            } else break;
        }
    }

    private void makeSecondLine() {
        while (true){
            if(isFrontClear()){
                move();
            } else break;
            dropBeeper();
            if(isFrontClear()){
                move();
            }else break;
        }
    }

    private void goBack() {
        turnAround();
        goToWall();
    }

    private void goToWall() {
        while (isFrontClear()){
            move();
        }
    }

    private void turnAround() {
        turnLeft();
        turnLeft();
    }



    public void cleanField(){
        while(true){
            removeLineOfBeepers();
            turnRight();
            if(isFrontClear()){
                move();
            } else break;
            turnRight();
            removeLineOfBeepers();
            turnLeft();
            if(isFrontClear()){
                move();
            } else break;
            turnLeft();
        }
    }


    private void removeLineOfBeepers() {
        while (isFrontClear()){
            if(isBeeper()){
                collectBeeper();
            }
            move();
        }
        if(isBeeper()){
            collectBeeper();
        }
    }

    private void fillFieldWithBeepers() {
        while(true){
            makeLineOfBeepers();
            turnRight();
            if(isFrontClear()){
                move();
            } else break;
            turnRight();
            makeLineOfBeepers();
            turnLeft();
            if(isFrontClear()){
                move();
            } else break;
            turnLeft();
        }
    }

    private void turnRight() {
        for(int i = 0; i<3; i++){
            turnLeft();
        }
    }

    private void makeLineOfBeepers() {
        while (isFrontClear()){
            dropBeeper();
            move();
        }
        dropBeeper();
    }


    //Дальше ничего не меняем.*************************************





    private void move(){
        carel.move();
    }

    private void turnLeft(){
        carel.turnLeft();
    }

    private void collectBeeper(){
        carel.collectBeeper();
    }

    private void dropBeeper(){
        carel.dropBeeper();
    }

    private boolean isFrontClear(){
        return carel.isFrontClear();
    }

    private boolean isBeeper(){
        return carel.isBeeper();
    }


    private void init() {
        textView = (TextView)findViewById(R.id.textView);
        grid = new CarelGrid();
        canvas = new GameCanvas(textView);
        carel = new Carel(canvas, grid);
    }
}