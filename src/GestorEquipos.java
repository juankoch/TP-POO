import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GestorEquipos {
	
    private LinkedList<Equipo> equipos = new LinkedList<Equipo>();

    
	public GestorEquipos() {
		this.equipos = equipos;
	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}


	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}


	// METODO PARA JUGAR UN PARTIDO CONTRA OTRO EQUIPO
	 public void jugarPartido(Equipo equipo1, Equipo equipo2) {
	        int golesEquipo1 = (int) (Math.random() * 5);
	        int golesEquipo2 = (int) (Math.random() * 5);

	        // ASEGURAR QUE NO HAYA EMPATE
	        if (golesEquipo1 == golesEquipo2) {
	            if (Math.random() > 0.5) {
	                golesEquipo1++;
	            } else {
	                golesEquipo2++;
	            }
	        }

	        JOptionPane.showMessageDialog(null, "Resultado del partido:\n" +
	                equipo1.getNombre() + " " + golesEquipo1 + " - " +
	                equipo2.getNombre() + " " + golesEquipo2);
	    }
	
	 
    // METODO PARA AGREGAR UN EQUIPO A LA LISTA
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    // METODO PARA ELIMINAR UN EQUIPO DE LA LISTA
    public void eliminarEquipo(String nombreEquipo) {
        boolean equipoEncontrado = false;
        
        for (Equipo equipo : equipos) {
          
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                
                equipos.remove(equipo);
                equipoEncontrado = true;
             
                break;
            }
        }
       
        if (equipoEncontrado) {
            JOptionPane.showMessageDialog(null, "Equipo eliminado correctamente.");
        } else {
           
            JOptionPane.showMessageDialog(null, "No se encontró el equipo con el nombre: " + nombreEquipo);
        }
    }


    // METODO PARA BUSCAR UN EQUIPO POR SU NOMBRE
    public Equipo buscarEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
    return null;    
    }

    // METODO PARA OBTENER LA CANTIDAD TOTAL DE EQUIPOS
    public int obtenerCantidadEquipos() {
        return equipos.size();
    }

    // METODO PARA OBTENER LA LISTA DE EQUIPOS
    public LinkedList<Equipo> obtenerListaEquipos() {
        return equipos;
    }
}