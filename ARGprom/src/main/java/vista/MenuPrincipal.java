package vista;
import java.util.Scanner;
import java.time.LocalDateTime;
import controladores.*;
import modelos.EstadoIncidente;
public class MenuPrincipal {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	ServicioControlador servicio = new ServicioControlador();
	ProblemaControlador problema = new ProblemaControlador();
	TecnicoControlador tecnico = new TecnicoControlador();
	ClienteControlador cliente = new ClienteControlador();
	OperadorControlador operador = new OperadorControlador();
	RecursosHumanosControlador rrhh = new RecursosHumanosControlador();
	EspecialidadControlador especialidad = new EspecialidadControlador();
	IncidenteControlador incidente = new IncidenteControlador();
	
	
	
	
	
	int opcion;
	
	
	
	
    do {
        System.out.println("Menú Principal");
        System.out.println("1.Crear Operador");
        System.out.println("2.Ver un Operador");
        System.out.println("3.Ver todos los Operadores");
        System.out.println("4.Actualizar Operador");
        System.out.println("5.Eliminar Operador");
        System.out.println("------------------------------");
        System.out.println("6.Crear Técnico");
        System.out.println("7.Ver Técnico");
        System.out.println("8.Ver todos los Técnicos");
        System.out.println("9.Actualizar Técnico");
        System.out.println("10.Eliminar Técnico");
        System.out.println("------------------------------");
        System.out.println("11.Crear Recursos Humanos");
        System.out.println("12.Ver Recursos Humanos");
        System.out.println("13.Ver todos los Recursos Humanos");
        System.out.println("14.Actualizar Recursos Humanos");
        System.out.println("15.Eliminar Recursos Humanos");
        System.out.println("------------------------------");
        System.out.println("16.Crear Cliente");
        System.out.println("17.Ver Cliente");
        System.out.println("18.Ver todos los Clientes");
        System.out.println("19.Actualizar Client");
        System.out.println("20.Eliminar Client");
        System.out.println("------------------------------");
        System.out.println("21.Crear Especialidad");
        System.out.println("22.Ver Especialidad");
        System.out.println("23.Ver todas las Especialidades");
        System.out.println("24.Actualizar Especialidad");
        System.out.println("25.Eliminar Especialidad");
        System.out.println("------------------------------");
        System.out.println("26.Crear Problema");
        System.out.println("27.Ver Problema");
        System.out.println("28.Ver todos los Problemas");
        System.out.println("29.Actualizar Problema");
        System.out.println("30.Eliminar Problema");
        System.out.println("------------------------------");
        System.out.println("31.Crear Servicio");
        System.out.println("32.Ver Servicio");
        System.out.println("33.Ver todos los Servicios");
        System.out.println("34.Actualizar Servicio");
        System.out.println("35.Eliminar Servicio");
        System.out.println("------------------------------");
        System.out.println("36.Crear Incidente");
        System.out.println("37.Ver Incidente");
        System.out.println("38.Ver todos los Incidentes");
        System.out.println("39.Actualizar Incidente");
        System.out.println("40.Eliminar Incidente");
        System.out.println("------------------------------");
        System.out.println("41. Salir");
        System.out.println("------------------------------");
        System.out.print("Seleccione una opción: ");

        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
            	operador.CrearOperador("José", "Dominguez", "403338520", "eljosesito@gmail.com", "+543515152");
                break;
            case 2:
            	operador.VerOperador(1);
                break;
            case 3:
                operador.MostrarTodosLosOperadores();
                break;
            case 4:
                operador.ActualizarOperador(1, "Rubén", "Salguero", "41000254", "rubsal@gmail.com", "+5466622123");
                break;
            case 5:
                operador.EliminarOperador(1);
                break;
            case 6:
                tecnico.CrearTecnico("Paula", "Quiroga", "36543210", "pauli@gmail.com", "+5477895210");
                break;
            case 7:
                tecnico.VerTécnico(2);
                break;
            case 8:
                tecnico.MostrarTodosLosTecnicos();
                break;
            case 9:
            	tecnico.ActualizarTecnico(1, "Mauricio", "Martinez", "38951357", "elmauri@hotmail.com", "+5454643424"); 
            	break;
            case 10:
            	tecnico.EliminarTecnico(2);
            	break;
            case 11:
            	rrhh.CrearRecursosHumanos("Aaron", "Gutierrez", "33210564", "aaron@outlook.com", "+54565632");
            	break;
            case 12:
            	rrhh.VerRecursosHumanos(2);
            	break;
            case 13:
            	rrhh.MostrarTodosLosRecursosHumanos();
            	break;
            case 14:
            	rrhh.ActualizarRecursosHumanos(1, "Lucas", "Medina", "29938546", "luki@gmail.com", "+5420212223");
            	break;
            case 15:
            	rrhh.EliminarRecursosHumanos(2);
            	break;
            case 16:
            	cliente.CrearCliente("Bunge", "5-657412-9", "bunge@outlook.com", "+5466686978");
            	break;
            case 17:
            	cliente.VerCliente(1);
            	break;
            case 18:
            	cliente.MostrarTodosLosClientes();
            	break;
            case 19:
            	cliente.ActualizarServicio(1, "Intel", "6-52035214-7", "intel@gmail.com", "+545555555");
            	break;
            case 20:
            	cliente.EliminarCliente(2);
            	break;
            case 21:
            	especialidad.CrearEspecialidad("Microservicios", 2);
            	break;
            case 22:
            	especialidad.VerEspecialidad(1);
            	break;
            case 23:
            	especialidad.MostrarEspecialidades();
            	break;
            case 24:
            	especialidad.ActualizarEspecialidad(1, "Reparación de PC",1);
            	break;
            case 25:
            	especialidad.EliminarEspecialidad(2);
            	break;
            case 26:
            	problema.CrearProblema("No anda el mause", "20min");
            	break;
            case 27:
            	problema.VerProblema(1);
            	break;
            case 28:
            	problema.MostrarProblemas();
            	break;
            case 29:
            	problema.ActualizarProblema(2, "No prende el monitor", "10min");
            	break;
            case 30:
            	problema.EliminarProblema(1);
            	break;
            case 31:
            	servicio.CrearServicio("Ubuntu");
            	break;
            case 32:
            	servicio.VerServicio(3);
            	break;
            case 33:
            	servicio.MostrarServicios();
            	break;
            case 34:
            	servicio.ActualizarServicio(1, "Windows 11");
            	break;
            case 35:
            	servicio.EliminarServicio(2);
            	break;
            case 36:
            	incidente.CrearIncidente(LocalDateTime.of(2020, 10, 15, 10, 53, 02), LocalDateTime.now(), 1, 2, 3, 3, "Sin observaciones", EstadoIncidente.Finalizado);
            	break;
            case 37:
            	incidente.VerIncidente(1);
            	break;
            case 38:
            	incidente.MostrarTodosLosIncidentes();
            	break;
            case 39:
            	incidente.ActualizarIncidente(1,LocalDateTime.of(2022, 10, 11, 10, 53, 22), LocalDateTime.now(), 1, 1, 1, 3, "Sin observaciones", EstadoIncidente.EnCurso);
            	break;
            case 40:
            	incidente.EliminarIncidente(2);
            	break;
            case 41:
            	System.out.println("Saliendo del programa. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
        }
    } while (opcion != 41);

    scanner.close();
}
}
