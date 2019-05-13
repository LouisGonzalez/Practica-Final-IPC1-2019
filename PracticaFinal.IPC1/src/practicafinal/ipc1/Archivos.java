package practicafinal.ipc1;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author luisGonzalez
 */
public class Archivos implements Serializable {
    
    public void guardarArchivos(NuevoAvatar<NombreJugador> jugador){
        String fichero = "Jugadores.dat";
        try{
            ObjectOutputStream objetoArchivo = new ObjectOutputStream(new FileOutputStream(fichero));
            objetoArchivo.writeObject(jugador);
            objetoArchivo.flush();
            objetoArchivo.close();
        } catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "bvc");
        } catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "No hay archivos por el momento");
        }
    }
    
    public NuevoAvatar<NombreJugador> leerArchivo() {     
            NuevoAvatar<NombreJugador> miLista = new NuevoAvatar<>();
        try{
            
                try (ObjectInputStream salidaArchivo = new ObjectInputStream(new FileInputStream("Jugadores.dat"))) {
                    miLista = (NuevoAvatar<NombreJugador>) salidaArchivo.readObject();
                }
        }   catch(ClassNotFoundException ex){
                ex.printStackTrace();
        
        }   catch(IOException ioe){
                JOptionPane.showMessageDialog(null, "No hay archivos por el momento");
         }   
        return miLista;
    }
}
