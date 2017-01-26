package kg.kloop.rinat.newcarel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Этот класс предназначен для указания команд Карелу
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CarelGrid grid;
    private GameCanvas canvas;
    private Carel carel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);
        canvas = new GameCanvas(textView);
        grid = new CarelGrid(6, 4); // здесь изменяется размер поля (x,y)
        carel = new Carel(canvas, grid);
        Button turnLeftButton = (Button)findViewById(R.id.turnLeftbutton);
        Button turnRightButton = (Button)findViewById(R.id.turnRightbutton);
        Button turnAroundButton = (Button)findViewById(R.id.turnAroundButton);
        Button moveButton = (Button)findViewById(R.id.moveButton);



        turnLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnLeft();
            }
        });

        turnRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnRight();
            }
        });

        turnAroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnAround();
            }
        });

        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move();
            }
        });

        /* Задания:
        * 1) Поворот направо
        * 2) Разворот
        * 3) Дойти до стены и не умереть
        * 4) Вернуться на начальную клетку из любой другой (Карел смотрит на восток)
        * 5) Заполнить поле биперами по периметру
        * 6) Заполнить поле биперами через одну строку
        * 7) Линия биперов по диагонали
        * 8) Шахматная доска из биперов
        * 9) Заполнить всё поле биперами (убрав те, которые уже есть),
        * причем в каждой следующей клетке на 1 бипер больше, чем в предыдущей
        * 10) Переложить биперы на 1 клетку вперед
        * 11) На начальной клетке выложить сумму (*произведение) всех биперов на поле
        * 12) Подсчет количества клеток до произвольного бипера
        * 13) Бипер в центре поля
        * 14) Буква "А" из биперов
        * 15) Спираль из биперов
        * 16) Квадрат из биперов с возможностью задать размеры
        * 17) Выход из лабиринта
        * 18) Кнопки для основных фукций Карела
        * 19) Исправить методы так, чтобы они работали на полях разного размера (5х6, 1х1, 6х1, 1х6)
        * 20) Сделайте что-нибудь крутое
        * */

        //Ниже идут команды Карелу.


   // goToWall();
    //turnAround();
    //turnRight();
    //goHome();
    //fillLine();
    //fillEdge();
    //fillAfterOneRow();
    //filldiagonal();
        //Команды Карелу закончились.

    }


    //Здесь пишем новые методы.


    //Новые методы закончились.

    private void move() {
        carel.move();
    }

    private void turnLeft() {
        carel.turnLeft();
    }

    //1
    private void turnRight(){
        carel.turnLeft();
        carel.turnLeft();
        carel.turnLeft();
    }

    //2
    private void turnAround(){
        carel.turnLeft();
        carel.turnLeft();
    }

    //3
    private void goToWall(){
        while(isFrontClear()){
            move();
        }
    }

    //4
    private void goHome(){
        turnAround();
        goToWall();
        turnAround();
    }

    //5
    private void fillEdge(){
       for(int i=0;i<4;i++){
           fillLine();
           turnRight();


        }
    }


    private void fillLine() {
        while(true){
            if(isBeeper()){
                if(isFrontClear()) {
                    move();
                } else break;
            } else {
            dropBeeper();
            }
        }
    }

    //6
    private void fillAfterOneRow(){

        while(true) {
            fillLine();
            goHome();
            goDown();
            turnRight();
            if (isFrontClear()) {
                move();
                turnLeft();
            }else {
                turnLeft();
                break;
            }
        }
    }

    //7
    private void filldiagonal() {
        while (true) {
            fillCell();
            if(isFrontClear()){
            move();
            goDown();
            }else break;
        }
    }

    private void fillCell() {
        if(!isBeeper()){dropBeeper();
        }
    }

    //8
    private void fillChess(){
        while(true){
            fillCell();
        }
    }

    private void goDown() {
        turnRight();
        if(isFrontClear()){
            move();
            turnLeft();
        }
    }


    private void goUp() {
        turnLeft();
        if(isFrontClear())move();
        turnRight();
    }

    private void saveMove() {
        if(isFrontClear()) move();
    }

    private void collectBeeper() {
        carel.collectBeeper();
    }

    private void dropBeeper() {
        carel.dropBeeper();
    }

    private boolean isFrontClear() {
        return carel.isFrontClear();
    }

    private boolean isBeeper() {
        return carel.isBeeper();
    }

}
