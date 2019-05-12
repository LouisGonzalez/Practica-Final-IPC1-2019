package practicafinal.ipc1;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author luisGonzalez
 */
public class Archivos {
    
    FileOutputStream archivoJugadores = null;
    ObjectOutputStream objetoArchivo;
    FileInputStream archivoSalida;
    
    public void guardarArchivos(NuevoAvatar jugador){
        try{
            archivoJugadores = new FileOutputStream("Jugadores.dat");
            objetoArchivo = new ObjectOutputStream(archivoJugadores);
            objetoArchivo.writeObject(jugador);
        } catch(IOException e){
        }
    }
    
    public NuevoAvatar leerArchivo(){     
        NuevoAvatar<NombreJugador> miLista = new NuevoAvatar<>();
        try{
            archivoSalida = new FileInputStream("Jugadores.dat");
            ObjectInputStream salidaArchivo = new ObjectInputStream(archivoSalida);
            miLista = (NuevoAvatar<NombreJugador>) salidaArchivo.readObject();
        }
            catch(ClassNotFoundException | IOException ex){
                    
            }
        return miLista;
    }
}
