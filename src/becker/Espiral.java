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
public class Espiral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   City prague=new City();
        Robot karel=new Robot(prague,1,0,Direction.EAST);
    karel.move();
    karel.move();
    Thing cosa=new Thing(prague,karel.getStreet(),karel.getAvenue());
    recorrer_espiral(prague,karel,5,0);
    }
    public static void recorrer_espiral(City ciudad,Robot robot,int tamano, int disparador){

        int inicialx=robot.getAvenue();
    int inicialy=robot.getStreet();
     Thing cosa1=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    if(disparador==0){
    for(int i=inicialx;i<inicialx+tamano-disparador;i++){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
    robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    for(int i=inicialy+disparador;i<inicialy+tamano;i++){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
    robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    for(int i=robot.getAvenue();i>inicialx;i--){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
    disparador++;
      robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    for(int i=robot.getStreet();i>inicialy+disparador;i--){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
      robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    robot.move();
    
    recorrer_espiral(ciudad,robot,tamano-1,disparador);
    
        
    }else{
    inicialx=robot.getAvenue();
    inicialy=robot.getStreet();
    
    Thing cosa2=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    for(int i=inicialx;i<inicialx+tamano-disparador;i++){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
    robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    for(int i=inicialy+disparador;i<inicialy+tamano;i++){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
    robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    for(int i=robot.getAvenue();i>inicialx;i--){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
    disparador++;
      robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    for(int i=robot.getStreet();i>inicialy+1;i--){
    robot.move();
    Thing cosa=new Thing(ciudad,robot.getStreet(),robot.getAvenue());
    }
      robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    robot.move();
    
    recorrer_espiral(ciudad,robot,tamano-1,disparador);
    
        
    }
    } 
}
