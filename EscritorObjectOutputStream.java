import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class EscritorObjectOutputStream {
    private String archivo;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    
    public EscritorObjectOutputStream(String archivo){
        this.archivo=archivo;
        fos=null;
        oos=null;
    }
    
    private boolean abrirFlujo(){
        boolean abierto=false;
        try{
            fos=new FileOutputStream(archivo);
            oos=new ObjectOutputStream(fos);
            abierto=true;
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();;
        }
        return abierto;
    }
    
    private boolean cerrarFlujo(){
        boolean cerradoOos=false;
        boolean cerradoFos=false;
        if(oos!=null){
            try{
                oos.close();
                cerradoOos=true;
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        if(fos!=null){
            try{
                fos.close();
                cerradoFos=true;
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return cerradoOos && cerradoFos;
    }
    
    public void escribirObjetos(LinkedList<Object> lista){
        if(abrirFlujo()){
            try{
                oos.writeObject(lista);
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
    
}
