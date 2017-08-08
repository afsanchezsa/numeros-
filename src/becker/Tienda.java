/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;
import java.util.*;
/**
 *
 * @author USUARIO
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada=new Scanner(System.in);
        String [][]catalogo={{"1","Algoritmica y Programacion","57000"},{"2","Programacion en Java","75000"},
            {"3","El lenguaje UML","43500"},{"4","Usando JUnit","63092"},{"5","Programacion en C#","65432"}};
        System.out.print("ISBN"+"\t"+"         Titulo"+"\t"+"      Precio"+"\n");
        for(int i=0;i<5;i++){
        for(int j=0;j<3;j++){
            System.out.print(catalogo[i][j]+"\t");
        }
            System.out.println("\n");
        }
        System.out.println("desea continuar en la tienda? (1/0)");
        int seguir_en_tienda=entrada.nextInt();
        while(seguir_en_tienda==1){
            System.out.println("desea adicionar un libro a su carrito?(1/0)");
           int adicionar=entrada.nextInt();
           Carrito micarro=new Carrito();
           
        if(adicionar==1){
            System.out.println("INSERTE EL ISBN");
            int ISBN=entrada.nextInt();
             System.out.println("INSERTE EL NOMBRE");
        String nombre=entrada.next();
        int precio=entrada.nextInt();
        micarro.agregar_libro(ISBN, nombre, precio);
        
        }else{
            System.out.println("DESEA VER EL SUBTOTAL POR LIBRO O EL TOTAL GENERAL? (1/0)");
              if(entrada.nextInt()==1){
                  System.out.println("escriba el ISBN del libro");
                  int ISBNBUSCAR=entrada.nextInt();
                  System.out.println("el subtotal de ejemplares del libro "+ISBNBUSCAR+" es "+micarro.subtotal(ISBNBUSCAR));
              }else if(entrada.nextInt()==0){
              
              }
        }
        }
    
    
    }
    
}

class Libro{
public int ISBN;
public String titulo;
public int precio;
public Libro(int ISBN_,String titulo_,int precio_){
ISBN=ISBN_;
titulo=titulo_;
precio=precio_;
}

}
class Carrito{
private static int  i=0;
Libro mislibros[]=new Libro[40]; 
public Carrito(){
}
public void agregar_libro(int ISBN,String Titulo,int Precio){
mislibros[i]=new Libro(ISBN,Titulo,Precio);
i++;
}
public int subtotal(int ISBNBUSCAR){
int subtotal=0;
    for(int n=0;n<i;n++){
if(mislibros[n].ISBN==ISBNBUSCAR){
subtotal+=mislibros[n].precio;
}
}
return subtotal;
}
}