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
public class RecogerPeriodico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City prague=new City();
        
      // crear_linea_muros(prague, 2, 1, 5, Direction.NORTH,Direction.EAST);
        //crear_linea_muros(prague, 2, 1, 1, Direction.SOUTH, Direction.EAST);
        //crear_linea_muros(prague, 2, 1, 2, Direction.NORTH, Direction.EAST);
        crear_linea_muros(prague, 1, 1, 2, Direction.WEST, Direction.SOUTH);
       // Wall mimuro=new Wall(prague,2,1,Direction.NORTH);
        crear_linea_muros(prague, 1, 1, 2, Direction.NORTH, Direction.EAST);
        crear_linea_muros(prague, 2,1 , 1, Direction.EAST, Direction.SOUTH);
        crear_linea_muros(prague, 1, 2, 1, Direction.SOUTH, Direction.WEST);
        crear_linea_muros(prague, 2, 1, 1, Direction.SOUTH, Direction.EAST);
        Robot karel=new Robot(prague,1,2,Direction.WEST);
        Thing periodico=new Thing(prague,2,2);
        salir_y_regresar(karel);
        
    }
    public static void crear_linea_muros(City ciudad,int inicialx,int inicialy,int numero_muros,Direction direccion_a_la_que_mira,Direction hacia_donde_va_la_fila){
    Wall []muros=new Wall[numero_muros];
    int nummuros=0;
    
    if(hacia_donde_va_la_fila==Direction.EAST||hacia_donde_va_la_fila==Direction.WEST){
    for(int i=inicialy;hacia_donde_va_la_fila==Direction.EAST?i<inicialy+numero_muros:i>inicialy-numero_muros;i=hacia_donde_va_la_fila==Direction.EAST?i+1:i-1){
    muros[nummuros]=new Wall(ciudad,inicialx,i,direccion_a_la_que_mira);
    nummuros++;
    }
    }else if(hacia_donde_va_la_fila==Direction.NORTH||hacia_donde_va_la_fila==Direction.SOUTH){
    for(int i=inicialy;hacia_donde_va_la_fila==Direction.SOUTH?i<inicialy+numero_muros:i>inicialy-numero_muros;i=hacia_donde_va_la_fila==Direction.SOUTH?i+1:i-1){
    muros[nummuros]=new Wall(ciudad,i,inicialx,direccion_a_la_que_mira);
    nummuros++;
    }
    }else{
        
    }}
public static void salir_y_regresar(Robot robot){

Direction direccion=robot.getDirection();
boolean recogido=false;
boolean hayalgo;
int xinicial=robot.getAvenue();
int yinicial=robot.getStreet();
while(!recogido){
if(robot.frontIsClear()){
robot.move();
hayalgo=robot.canPickThing();
if(hayalgo){
robot.pickThing();
recogido=true;
}

}else{
robot.turnLeft();
}
}
boolean llegar_al_inicio=false;
while(!llegar_al_inicio){
llegar_al_inicio=robot.getAvenue()==xinicial&&robot.getStreet()==yinicial;
if(!llegar_al_inicio){
dargiro(robot);

}
}
}
public static void dargiro(Robot robot){
    robot.turnLeft();
if(robot.frontIsClear()){
robot.move();
robot.turnLeft();
robot.turnLeft();


}
}
}
