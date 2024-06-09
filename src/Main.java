import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
    	
    	// CREAR EQUIPOS
        Equipo Racing = new Equipo("Racing", "Avellaneda");
        Equipo Independiente = new Equipo("Independiente", "Avellaneda");
        
        LinkedList<Jugador> jugadoresRacing = new LinkedList<>();
        jugadoresRacing.add(new Jugador("Gabriel Arias", "Arquero", 1, 33));
        jugadoresRacing.add(new Jugador("Leonardo Sigali", "Defensor", 5, 34));
        jugadoresRacing.add(new Jugador("Eugenio Mena", "Defensor", 3, 32));
        jugadoresRacing.add(new Jugador("Mauricio Martínez", "Mediocampista", 8, 28));
        jugadoresRacing.add(new Jugador("Matías Rojas", "Mediocampista", 10, 25));
        jugadoresRacing.add(new Jugador("Carlos Alcaraz", "Mediocampista", 22, 19));
        jugadoresRacing.add(new Jugador("Darío Cvitanich", "Delantero", 20, 37));
        jugadoresRacing.add(new Jugador("Javier Correa", "Delantero", 27, 28));
        jugadoresRacing.add(new Jugador("Lisandro López", "Delantero", 15, 37));
        jugadoresRacing.add(new Jugador("Enzo Copetti", "Delantero", 9, 25));
        jugadoresRacing.add(new Jugador("Tomás Chancalay", "Delantero", 28, 23));

        
        LinkedList<Jugador> jugadoresIndependiente = new LinkedList<>();
        jugadoresIndependiente.add(new Jugador("Sebastián Sosa", "Arquero", 1, 34));
        jugadoresIndependiente.add(new Jugador("Sergio Barreto", "Defensor", 24, 22));
        jugadoresIndependiente.add(new Jugador("Lucas Rodríguez", "Defensor", 6, 27));
        jugadoresIndependiente.add(new Jugador("Juan Insaurralde", "Defensor", 33, 36));
        jugadoresIndependiente.add(new Jugador("Fabricio Bustos", "Defensor", 16, 25));
        jugadoresIndependiente.add(new Jugador("Alan Velasco", "Mediocampista", 10, 19));
        jugadoresIndependiente.add(new Jugador("Domingo Blanco", "Mediocampista", 23, 26));
        jugadoresIndependiente.add(new Jugador("Andrés Roa", "Mediocampista", 7, 28));
        jugadoresIndependiente.add(new Jugador("Lucas Romero", "Mediocampista", 29, 27));
        jugadoresIndependiente.add(new Jugador("Jonathan Menéndez", "Delantero", 26, 27));
        jugadoresIndependiente.add(new Jugador("Silvio Romero", "Delantero", 18, 32));

        // CREAR GESTOR DE EQUIPOS
        GestorEquipos gestor = new GestorEquipos();

        // AGREGAR EQUIPOS AL GESTOR
        gestor.getEquipos().add(Racing);
        gestor.getEquipos().add(Independiente);
        
        // AGREGAR JUGADORES
        Racing.setJugadores(jugadoresRacing);
        Independiente.setJugadores(jugadoresIndependiente);

        // MOSTRAR LA CANTIDAD DE EQUIPOS
        JOptionPane.showMessageDialog(null, "Cantidad de equipos: " + gestor.obtenerCantidadEquipos());
        
        int opcionEliminarEquipo = JOptionPane.showConfirmDialog(null, "¿Desea eliminar un equipo?", "Eliminar Equipo", JOptionPane.YES_NO_OPTION);
        if (opcionEliminarEquipo == JOptionPane.YES_OPTION) {
            // ELIMINAR UN EQUIPO
            String nombreEquipoEliminar = JOptionPane.showInputDialog("Ingrese el nombre del equipo a eliminar:");
            if (nombreEquipoEliminar != null && !nombreEquipoEliminar.isEmpty()) {
                gestor.eliminarEquipo(nombreEquipoEliminar);
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de equipo inválido.");
            }
        }

        // BUSCAR UN EQUIPO POR NOMBRE
        String nombreEquipoBuscado = JOptionPane.showInputDialog("Ingrese el nombre del equipo a buscar:");
        if (nombreEquipoBuscado != null && !nombreEquipoBuscado.isEmpty()) {
            Equipo equipoBuscado = gestor.buscarEquipo(nombreEquipoBuscado);
            if (equipoBuscado != null) {
                JOptionPane.showMessageDialog(null, "Equipo encontrado: " + equipoBuscado);
                gestor.jugarPartido(Racing, Independiente);
                // BUSCAR UN JUGADOR POR NOMBRE
                String nombreJugadorBuscado = JOptionPane.showInputDialog("Quien fue para vos el jugador del partido?");
                if (nombreJugadorBuscado != null && !nombreJugadorBuscado.isEmpty()) {
                    Jugador jugadorBuscado = equipoBuscado.buscarJugador(nombreJugadorBuscado);
                    if (jugadorBuscado != null) {
                        JOptionPane.showMessageDialog(null, "Jugador encontrado: " + jugadorBuscado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de jugador inválido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de equipo inválido.");
        }
    }
}
