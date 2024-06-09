import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	private String nombre;
	private String ciudad;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();

	public Equipo(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", jugadores=" + jugadores + "]";
	}

	//AGREGAR UN JUGADOR A LA LISTA
	public void agregarJugador(Jugador jugador) {
		if (jugador == null) {
			JOptionPane.showMessageDialog(null, "Agregue un jugador");
			return;
		}
		jugadores.add(jugador);
		JOptionPane.showMessageDialog(null, "Jugador agregado: " + jugador.getNombre());
	}

	
	//BUSCAR UN JUGADOR POR EL NOMBRE
	public Jugador buscarJugador(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre del jugador no puede ser nulo o vacío.");
			return null;
		}
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equals(nombre)) {
				return jugador;
			}
		}
		return null;
	}

	//ELIMINAR UN JUGADOR DE LA LISTA
	public void eliminarJugador(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Agregue un jugador valido");
			return;
		}
		Jugador jugador = buscarJugador(nombre);
		if (jugador == null) {
			JOptionPane.showMessageDialog(null, "El jugador no existe.");
		} else {
			jugadores.remove(jugador);
			JOptionPane.showMessageDialog(null, "Jugador eliminado: " + nombre);
		}
	}

	
	
	public int obtenerCantidadJugadores() {
		return jugadores.size();
	}

	public LinkedList<Jugador> obtenerListaJugadores() {
		return jugadores;
	}
}

