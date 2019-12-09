
import java.io.Serializable;

public class Candy implements Serializable {
    private String sabor;
    private int precio;
    
    public Candy(String sabor, int precio){
        this.sabor=sabor;
        this.precio=precio;
    }
    
    @Override
    public String toString(){
        return "Sabor "+sabor+"\nPrecio "+precio;
    }
    
}
