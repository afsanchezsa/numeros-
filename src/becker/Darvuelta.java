/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;
import becker.robots.*;

/**
 *
 * @author USUARIO
 */
public class Darvuelta {
public static int posicioninicialx;
public static int posicioninicialy;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           City prague = new City();
      
      Robot karel = new Robot(prague, 0, 2, Direction.WEST,5);
      Wall muros[]=new Wall[8];
      int nummuros=0;
      Direction direccion=Direction.NORTH;
    for(int i=1;i<3;i++){
    for(int j=1;j<3;j++){
    muros[nummuros]=new Wall(prague,i,j,direccion);
    nummuros++;
     
    }
      direccion=Direction.SOUTH;
    }
    direccion=Direction.WEST;
      for(int j=1;j<3;j++){
    for(int i=1;i<3;i++){
    muros[nummuros]=new Wall(prague,i,j,direccion);
    nummuros++;
     
    }
      direccion=Direction.EAST;
    }
    rodear_cuarto(karel,karel.getAvenue(),karel.getStreet(),0);
    }
    public static void rodear_cuarto(Robot robot, int posicionx, int posiciony, int iteracion){

        if(iteracion==0){
         posicioninicialx =posicionx;
         posicioninicialy =posiciony;
        
        }
        if( posicioninicialx==posicionx && posicioninicialy==posiciony && iteracion==0){
        Direction direccion;
        direccion=robot.getDirection();
        robot.turnLeft();
        boolean frente_libre=false;
        frente_libre=robot.frontIsClear();
        if(frente_libre){
        robot.move();
        rodear_cuarto(robot,robot.getAvenue(),robot.getStreet(),iteracion+1);
        }else{
        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
         rodear_cuarto(robot,robot.getAvenue(),robot.getStreet(),iteracion+1);
        }}
        
         if( (posicioninicialx!=posicionx || posicioninicialy!=posiciony )){
        Direction direccion;
        direccion=robot.getDirection();
        robot.turnLeft();
        boolean frente_libre=false;
        frente_libre=robot.frontIsClear();
        if(frente_libre){
        robot.move();
        rodear_cuarto(robot,robot.getAvenue(),robot.getStreet(),iteracion+1);
        }else{
        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
         rodear_cuarto(robot,robot.getAvenue(),robot.getStreet(),iteracion+1);
        }}else{
         return;
         }
        
    }
    
    
}
