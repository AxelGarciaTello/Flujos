import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class LectorObjectInputStream {
    private String archivo;
    private FileInputStream fis;
    private ObjectInputStream ois;
    
    public LectorObjectInputStream(String archivo){
        this.archivo=archivo;
        fis=null;
        ois=null;
    }
    
    private boolean abrirFlujo(){
        boolean abierto=false;
        try{
            fis=new FileInputStream(archivo);
            ois=new ObjectInputStream(fis);
            abierto=true;
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return abierto;
    }
    
    private boolean cerrarFlujo(){
        boolean cerradoOis=false;
        boolean cerradoFis=false;
        if(ois!=null){
            try{
                ois.close();
                cerradoOis=true;
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
            try{
                fis.close();
                cerradoFis=true;
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return cerradoOis && cerradoFis;
    }
    
    public LinkedList<Object> leerObjetos(){
        LinkedList <Object> lista=new LinkedList<>();
        if(abrirFlujo()){
            try{
                lista=(LinkedList<Object>) ois.readObject();
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
            catch(ClassNotFoundException cnfe){
                cnfe.printStackTrace();
            }
            finally{
                if(cerrarFlujo()){
                    System.out.println("Cerrado correctamente.");
                }
                else{
                    System.out.println("Ocurrio un error al cerrar el flujo");
                }
            }
        }
        return lista;
    }
    
}
