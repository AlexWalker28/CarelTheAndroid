package kg.kloop.rinat.newcarel;


import java.util.Random;

/**
 * Этот класс содержит данные поля */
public class CarelGrid extends Object {

    public CarelGrid() {
        map = new int[6][4];
        if (getWidth() >= 4 && getHeight() >= 4) {
            map[1][1] = 1;
            map[3][3] = 1;
            map[3][2] = 1;
        }
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    public int getCarelX() {
        return carelX;
    }

    public int getCarelY(){
        return carelY;
    }

    public int getCarelDirectionX(){
        return carelDirectionX;
    }

    public int getCarelDirectionY(){
        return carelDirectionY;
    }

    public boolean isCarelDead() {
        return carelDead;
    }

    // public int setWidth() {}

    // public int setHeight() {}

    public void setCarelX(int x) {
        carelX = x;
    }

    public void setCarelY(int y){
        carelY = y;
    }

    public void setCarelDirectionX(int x){
        carelDirectionX = x;
    }

    public void setCarelDirectionY(int y){
        carelDirectionY = y;
    }

    public void setCarelDead(boolean dead) {
        carelDead = dead;
    }



    public void placeBeeper(int x, int y) {
        map[x][y] = map[x][y] + 1;
    }

    public void removeBeeper(int x, int y){
        map[x][y] = map[x][y] - 1;
    }

    public boolean isBeeper(int x, int y) {
        if (map[x][y] <= 0) return false;

        return true;
    }

    public int getBeepersNumber(int x, int y) {
        return map[x][y];
    }

    private int[][] map = null;

    private int carelX = 0;

    private int carelY = 0;

    private int carelDirectionX = 1;

    private int carelDirectionY = 0;

    private boolean carelDead = false;

    Random random = new Random();
}
