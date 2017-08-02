package becker;

import becker.robots.*;

public class DeliverParcel
{
   public static void main(String[] args)
   {  
     // Set up the initial situation
      City prague = new City();
      Thing parcel = new Thing(prague, 1, 2);
      Robot karel = new Robot(prague, 6, 2, Direction.NORTH,5);
      Wall muros[]=new Wall[40];
     int nummuro=0;
          for(int i=1;i<6;i++){
              for(int j=1;j<10;j+=3){
                  
                 
      muros[nummuro]=new Wall(prague,i,j,Direction.WEST);
                  
              nummuro++;
              }
              
              
          }
          for(int m=1;m<6;m++){
          muros[nummuro]=new Wall(prague,m,9,Direction.EAST);
          nummuro++;
          }
          for(int n=1;n<=9;n++){
          muros[nummuro]=new Wall(prague,0,n,Direction.SOUTH);
          nummuro++;
          
          }
          for(int n=1;n<=9;n++){
              if(n!=2 && n!=5&&n!=8){
          muros[nummuro]=new Wall(prague,5,n,Direction.SOUTH);
          nummuro++;
              }
           
           
          }
          Thing cosas[]=new Thing[40];
          int numcosas=0;
          for(int s=0;s<10;s++){
          if(s==1||s==3||s==7||s==9){
          for(int p=1;p<6;p++){
              
          cosas[numcosas]=new Thing(prague,p,s);
          numcosas++;
          }
          }
          }
          cosas[numcosas]=new Thing(prague,5,2);
          numcosas++;
          cosas[numcosas]=new Thing(prague,5,8);
          numcosas++;
          cosas[numcosas]=new Thing(prague,1,8);
          numcosas++;
          for(int j=4;j<7;j++){
          for(int i=1;i<6;i+=2){
          cosas[numcosas]=new Thing(prague,i,j);
          numcosas++;
          }
          }
          int i=1;
        while(i<4){
        cosas[numcosas]=new Thing(prague,i,4);
          numcosas++;
          i++;
        } 
       
        cosas[numcosas]=new Thing(prague,4,6);
          numcosas++;
          
        boolean matriz[][]=new boolean [5][3];
       recorrer_cuarto(matriz,karel,1); 
  int numero1=comparar_matrices(matriz);
  salir_del_cuarto(karel);
  recorrer_cuarto(matriz,karel,4);
  int numero2=comparar_matrices(matriz);
    salir_del_cuarto(karel);
    recorrer_cuarto(matriz,karel,7);
  int numero3=comparar_matrices(matriz);
  System.out.println("los numeros en los cuartos son "+numero1+""+numero2+""+numero3);
  
 
       
        
       
     
    
      // Direct the robot to the final situation
      /*karel.move();
      karel.move();
      karel.pickThing();
      karel.move();
      karel.turnLeft();	// start turning right as three turn lefts
      karel.turnLeft();
      karel.turnLeft();	// finished turning right
      karel.move();
      
     // karel.putThing();
      karel.move();*/
      
      //System.out.println(karel.countThingsInBackpack());
   }
      public static void llenarmatriz(boolean [][]matriz){
      for(int i=0;i<5;i++){
      for(int j=0;j<3;j++){
      matriz[i][j]=false;
      }
     
      }
      
      }
      public static void identificar_numero(boolean [][]matriz, Robot robot,int corrimiento){
      robot.move();
      if(robot.canPickThing()){
      matriz[robot.getStreet()-1][robot.getAvenue()-corrimiento]=true;
      robot.pickThing();
      }
      
      }
      public static void recorrer_pasillo(boolean [][]matriz, Robot robot, int corrimiento){
     for(int i=0;i<4;i++){
          identificar_numero(matriz, robot,corrimiento);
      }
      }
      public static void imprimir_matriz(boolean [][]matriz){
      for(int i=0;i<5;i++){
      for(int j=0;j<3;j++){
          int entero=0;
          if(matriz[i][j]==true){
          entero=1;
          }
          
          System.out.print(entero);
      }
      System.out.println("");
      }
      
      }
      public static void recorrer_cuarto(boolean [][]matriz, Robot robot,int corrimiento){
      llenarmatriz(matriz);
          identificar_numero(matriz,robot,corrimiento);
      recorrer_pasillo(matriz,robot,corrimiento);
       robot.turnLeft();
       identificar_numero(matriz,robot,corrimiento);
       robot.turnLeft();
       recorrer_pasillo(matriz,robot,corrimiento);
       robot.turnLeft();
       identificar_numero(matriz,robot,corrimiento);
       identificar_numero(matriz,robot,corrimiento);
       robot.turnLeft();
       recorrer_pasillo(matriz,robot,corrimiento);
       robot.turnLeft();
       identificar_numero(matriz,robot,corrimiento);
       robot.turnLeft();
       recorrer_pasillo(matriz,robot,corrimiento);
       
      // imprimir_matriz(matriz);
      }
      public static int  comparar_matrices(boolean [][]matriz){
     // boolean [][]matriz0=new boolean[5][3];
      boolean matriz0[][]={{true,true,true},{true,false,true},{true,false,true},{true,false,true},{true,true,true}};
      boolean matriz1[][]={{false,false,true},{false,false,true},{false,false,true},{false,false,true},{false,false,true}};
      boolean matriz2[][]={{true,true,true},{false,false,true},{true,true,true},{true,false,false},{true,true,true}};
      boolean matriz3[][]={{true,true,true},{false,false,true},{true,true,true},{false,false,true},{true,true,true}};
      boolean matriz4[][]={{true,false,true},{true,false,true},{true,true,true},{false,false,true},{false,false,true}};
      boolean matriz5[][]={{true,true,true},{true,false,false},{true,true,true},{false,false,true},{true,true,true}};
      boolean matriz6[][]={{true,true,true},{true,false,false},{true,true,true},{true,false,true},{true,true,true}};
      boolean matriz7[][]={{true,true,true},{false,false,true},{false,false,true},{false,false,true},{false,false,true}};
      boolean matriz8[][]={{true,true,true},{true,false,true},{true,true,true},{true,false,true},{true,true,true}};
      boolean matriz9[][]={{true,true,true},{true,false,true},{true,true,true},{false,false,true},{false,false,true}};
      
      if(matrices_iguales(matriz,matriz0)){
      return 0;
      }else if(matrices_iguales(matriz,matriz1)){
      return 1;
      }else if(matrices_iguales(matriz,matriz2)){
      return 2;
      }else if(matrices_iguales(matriz,matriz3)){
      return 3;
      }else if(matrices_iguales(matriz,matriz4)){
      return 4;
      }else if(matrices_iguales(matriz,matriz5)){
      return 5;
      }else if(matrices_iguales(matriz,matriz6)){
      return 6;
      }else if(matrices_iguales(matriz,matriz7)){
      return 7;
      }else if(matrices_iguales(matriz,matriz8)){
      return 8;
      }else if(matrices_iguales(matriz,matriz9)){
      return 9;
      }
      return -1;
      }
      public static boolean matrices_iguales(boolean [][]matriz_generada, boolean [][]matriz_numero){
      boolean son_iguales=true;
      for(int i=0;i<5;i++){
      for(int j=0;j<3;j++){
      if(matriz_generada[i][j]!=matriz_numero[i][j]){
      son_iguales=false;
      }
      }
      }  
      return son_iguales;
      }
      public static void salir_del_cuarto(Robot robot){
     robot.move();
     robot.turnLeft();
     robot.move();
     robot.move();
     robot.move();
     robot.turnLeft();
     
      }
      
}
