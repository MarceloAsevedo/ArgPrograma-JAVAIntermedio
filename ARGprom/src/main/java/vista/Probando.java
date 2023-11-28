package vista;

import controladores.ProblemaControlador;

import controladores.ServicioControlador;
import controladores.TecnicoControlador;

import java.time.LocalDateTime;

import controladores.ClienteControlador;
import controladores.EspecialidadControlador;
import controladores.RecursosHumanosControlador;
import controladores.OperadorControlador;
import controladores.IncidenteControlador;
import modelos.*;

public class Probando {
	public static void main(String[] args) {
		//ServicioControlador servicio1 = new ServicioControlador();
		ProblemaControlador problemita = new ProblemaControlador();
		//TecnicoControlador tec = new TecnicoControlador();
		//ClienteControlador client = new ClienteControlador();
		//OperadorControlador operador = new OperadorControlador();
		//RecursosHumanosControlador rrhh = new RecursosHumanosControlador();
		//EspecialidadControlador esp = new EspecialidadControlador();
		//IncidenteControlador incident = new IncidenteControlador();
		
		
		//tec.CrearTecnico("Raúl", "Rodriguez", "353338520", "elraulr@gmail.com", "+5455566887");
		//servicio1.CrearServicio("Puppy Linux"); 
		problemita.CrearProblema("No le toma las particiones de memoria", "3hs"); 
		//client.CrearCliente("Renault", "7-159874111-9", "renault@gmail.com", "+548885552");
		//operador.CrearOperador("Julian", "Perez", "41688755", "jp@gmail.com", "+5466622274");
		//rrhh.CrearRecursosHumanos("Romina", "Sanchez", "30680201", "romi@gmail.com", "+542789103");
		//esp.CrearEspecialidad("Máquinas Virtuales", 2);
		//incident.CrearIncidente(LocalDateTime.of(2022, 10, 15, 10, 43, 02), LocalDateTime.now(), 1, 2, 3, 3, "Sin observaciones", EstadoIncidente.Finalizado);
		
		
		//servicio1.VerServicio(3);
		//servicio1.ActualizarServicio(2, "Windows XP");
		//System.out.println("---------------\n" + servicio1.VerServicio(3));
		//servicio1.MostrarServicios();		
	}
}