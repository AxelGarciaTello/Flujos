import java.util.LinkedList;

public class PruebaObjetos {
    
    public static void main(String[] args) {
        Object caramelo;
        LinkedList<Object> lista=new LinkedList<>();
        LectorObjectInputStream lector=new LectorObjectInputStream("/home/axel/Escritorio/dulce.txt");
        lista=lector.leerObjetos();
        caramelo=lista.getFirst();
        if(caramelo instanceof Candy){
            System.out.println(caramelo.toString());
        }
    }
    
}
