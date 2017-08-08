/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;

/**
 *
 * @author USUARIO
 */
public class AdivinarNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   String playagain="y";
   while(!(playagain!="y")){
       GuessingName();
       System.out.println("Would you like to play another game(y/n)");
       java.util.Scanner entrada=new java.util.Scanner(System.in);
       playagain=entrada.next();
   }
    
    }
   public static void GuessingName(){
   int answer =(int) Math.floor((Math.random())+1);
   int guess=0;
   int numGuesses;
   for( numGuesses=1;numGuesses>7||(guess==answer);numGuesses=numGuesses+1){
       System.out.println("Guess a number");
       java.util.Scanner entrada=new java.util.Scanner(System.in);
       guess=entrada.nextInt();
       if(guess<answer){
           System.out.println("Higher...");
       }else{
       if(guess>answer){
           System.out.println("Lower...");
       }else{
           System.out.println("You Win");
       }
       }
   }
   if(numGuesses>7){
       System.out.println("You Loser...");
   }
   } 
}
