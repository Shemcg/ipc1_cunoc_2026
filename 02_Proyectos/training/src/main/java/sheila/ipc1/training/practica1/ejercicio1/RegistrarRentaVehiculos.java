package sheila.ipc1.training.practica1.ejercicio1; 

import java.util.Scanner;

public class RegistrarRentaVehiculos {

    //CONSTANTES
    private static final int PRECIO_BASE_SEDAN = 180;
    private static final int PRECIO_BASE_PICKUP = 250;
    private static final int PRECIO_BASE_MOTO = 120;
    private static final int PRECIO_BASE_CAMION = 400;
    private static final int COSTO_ADICIONAL_SEGURO = 35;

    //VARIABLES GLOBALES 
    private String nombreCliente;
    private String nombreClienteRentaGrande;
    private int tipoVehiculo = 0;
    private int cantidadDiasRenta = 0;
    private int agregarSeguro = 0;
    private int sedanRentados = 0;
    private int diasRentadosSedan = 0;
    private int pickupRentados = 0;
    private int diasRentadosPickup = 0;
    private int motoRentadas = 0;
    private int diasRentadosMoto = 0;
    private int camionRentados = 0;
    private int diasRentadosCamion = 0;
    private int gananciaTotal = 0;
    private int totalRentasRealizadas = 0;
    private int rentaMasGrande = 0;
    private int precioTotalRegistroActual = 0;
    private int indice = 0;
    
    //CODIGO ANSI
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_NEGRITA = "\u001b[1m";
    private static final String ANSI_ROJO = "\u001B[31m";
    private static final String ANSI_VERDE = "\u001B[32m";
    private static final String ANSI_AMARILLO = "\u001B[33m";
    private static final String ANSI_MORADO = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
            
        iniciarRegistro();
    
        mostrarReportes();
        
    }
    
    private void iniciarRegistro() {
                
            indice = 1;
            
        do {
            
            registrarDatos();
            calcularDatos();
            
            mostrarRegistroActual();
            
            rentaMayor();
            
            totalRentasRealizadas = totalRentasRealizadas + 1;
            indice = indice + 1;
		            
        } while (pedirDecision() == 1);
    
    }
    
    private void registrarDatos() {
        
        pedirNombreCliente();
                
        pedirTipoVehiculo();
        
        pedirCantidadDiasRenta();
        
        pedirAgregarSeguro();
        
    }
    
    private void calcularDatos() {
        
        int subtotalSeguro = 0;
        int total = 0;
        
        if (agregarSeguro == 1) {
            subtotalSeguro = cantidadDiasRenta * COSTO_ADICIONAL_SEGURO;
        }
        
        switch(tipoVehiculo) {
            case 1:
                total = PRECIO_BASE_SEDAN * cantidadDiasRenta + subtotalSeguro;
                
                sedanRentados = sedanRentados + 1;
                diasRentadosSedan = diasRentadosSedan + cantidadDiasRenta; 
                
                break;
                
            case 2:
                total = PRECIO_BASE_PICKUP * cantidadDiasRenta + subtotalSeguro;
                
                pickupRentados = pickupRentados + 1;
                diasRentadosPickup = diasRentadosPickup + cantidadDiasRenta;
                
                break;
            
            case 3:
                total = PRECIO_BASE_MOTO * cantidadDiasRenta + subtotalSeguro;
                
                motoRentadas = motoRentadas + 1;
                diasRentadosMoto = diasRentadosMoto + cantidadDiasRenta;
                
                break;
             
            case 4:
                total = PRECIO_BASE_CAMION * cantidadDiasRenta + subtotalSeguro;
                
                camionRentados = camionRentados + 1;
                diasRentadosCamion = diasRentadosCamion + cantidadDiasRenta;
                
                break;
                
            default:
                System.out.println("Ingrese un vehículo disponible");
        }
        
        precioTotalRegistroActual = total;
        gananciaTotal = gananciaTotal + total;
    }
    
    private int calcularPromedioSedan() {
        
        if (sedanRentados == 0) {
            sedanRentados = 1;
        }
        
        return diasRentadosSedan / sedanRentados;
    }
    
    private int calcularPromedioPickup() {
        
        if (pickupRentados == 0) {
            pickupRentados = 1;
        }
        
        return diasRentadosPickup / pickupRentados;
    }
    
    private int calcularPromedioMoto() {
        
        if (motoRentadas == 0) {
            motoRentadas = 1;
        }
        
        return diasRentadosMoto / motoRentadas;
    }
    
    private int calcularPromedioCamion() {
        
        if (camionRentados == 0) {
            camionRentados = 1;
        }
        
        return diasRentadosCamion / camionRentados;
    }
    
    private void mostrarRegistroActual() {
        
        mostrarTituloPrograma();
        mostrarRegistroCompletado();
        
        mostrarNombreClienteActual();
        mostrarTipoVehiculoActual();
        mostrarCantidadDiasRentado();
        mostrarDecisionAgregarSeguro();
        
    }
    
    private void mostrarRegistroCompletado() {
        
        String registroActual = ANSI_NEGRITA + ANSI_AMARILLO + "---- Registro #" + indice + " Completado" + ANSI_RESET + "\n";
        System.out.println(registroActual);
                
    }
    
    private void mostrarNombreClienteActual() {
        
        String nombreClienteActual = ANSI_NEGRITA + ANSI_MORADO + "---- NOMBRE DEL CLIENTE: " + ANSI_RESET + ANSI_VERDE + nombreCliente + ANSI_RESET;
        System.out.println(nombreClienteActual);
        
    }
    
    private void mostrarTipoVehiculoActual() {
        
        String tipoVehiculoActual = ANSI_NEGRITA + ANSI_CYAN + "---- TIPO DE VEHÍCULO QUE RENTÓ: " + ANSI_RESET + ANSI_VERDE + tipoVehiculo + ANSI_RESET;
        System.out.println(tipoVehiculoActual);
        
    }
    
    private void mostrarCantidadDiasRentado() {
        
        String cantidadDiasRentado = ANSI_NEGRITA + ANSI_MORADO + "---- CANTIDAD DE DÍAS QUE RENTO EL VEHICULO: " + ANSI_RESET + ANSI_VERDE + cantidadDiasRenta + ANSI_RESET;
        System.out.println(cantidadDiasRentado);
        
    }
    
    private void mostrarDecisionAgregarSeguro() {
        
        String decisionAgregarSeguro = ANSI_NEGRITA + ANSI_CYAN + "---- CUENTA CON SEGURO: " + ANSI_RESET + ANSI_VERDE + agregarSeguro + ANSI_RESET;
        System.out.println(decisionAgregarSeguro);
        
    }
    
    private void rentaMayor() {
        
        if (rentaMasGrande < precioTotalRegistroActual) {
            
            rentaMasGrande = precioTotalRegistroActual;
            
            nombreClienteRentaGrande = nombreCliente;
        }
    }
    
    private void mostrarReportes() {
        
        System.out.println("REPORTES");
        
        System.out.println("Cantidad total de rentas realizadas: " + totalRentasRealizadas);
        System.out.println("Total de dinero recaudado en el día: " + gananciaTotal);
        System.out.println("Cantidad de vehículos de cada tipo que fueron rentados: ");
        System.out.println("SEDAN: " + sedanRentados);
        System.out.println("PICKUP: " + pickupRentados);
        System.out.println("MOTOCICLETA: " + motoRentadas);
        System.out.println("CAMION: " + camionRentados);
        System.out.println("Promedio de días de renta por vehículo: ");
        System.out.println("SEDAN: " + calcularPromedioSedan());
        System.out.println("PICKUP: " + calcularPromedioPickup());
        System.out.println("MOTOCICLETA: " + calcularPromedioMoto());
        System.out.println("CAMION: " + calcularPromedioCamion());
        System.out.println("La renta más cara del día: " + nombreClienteRentaGrande + ": " + rentaMasGrande);
        
    }
    
    private void mostrarTituloPrograma() {
        
        limpiarPantalla();
        
        String titulo = ANSI_NEGRITA + ANSI_CYAN + "REGISTRO DE RENTA DE VEHICULOS" + ANSI_RESET;
        
        System.out.println("------------------------------");
        System.out.println(titulo);
        System.out.println("------------------------------\n");
                
    }
    
    private void mostrarNumeroRegistro() {
        
            String registro = ANSI_NEGRITA + ANSI_AMARILLO + "Registro #" + ANSI_VERDE + indice + ANSI_RESET + "\n\n";

            System.out.println(registro);
            
    }
    
    private void pedirNombreCliente() {
        
        mostrarTituloPrograma();
        mostrarNumeroRegistro();
        
        String pedirNombreCliente = ANSI_MORADO + "Escriba el nombre del cliente: " + ANSI_RESET;
        
        System.out.println(pedirNombreCliente);
        nombreCliente = leerEntrada();
        
    }
    
    private void pedirTipoVehiculo() {
        
        mostrarTituloPrograma();
        mostrarNumeroRegistro();
        
        String pedirTipoVehiculo = ANSI_AMARILLO + "Escriba el tipo del vehículo (1-4): " + ANSI_RESET;
        String sedan = ANSI_NEGRITA + "  1. " + ANSI_CYAN + "SEDAN" + ANSI_RESET;
        String pickup = ANSI_NEGRITA + "  2. " + ANSI_CYAN + "PICKUP" + ANSI_RESET;
        String motocicleta = ANSI_NEGRITA + "  3. " + ANSI_CYAN + "MOTOCICLETA" + ANSI_RESET;
        String camion = ANSI_NEGRITA + "  4. " + ANSI_CYAN + "CAMION" + ANSI_RESET;
        
        System.out.println(pedirTipoVehiculo);
        System.out.println(sedan);
        System.out.println(pickup);
        System.out.println(motocicleta);
        System.out.println(camion);
        tipoVehiculo = Integer.valueOf(leerEntrada());
        
    }
    
    private void pedirCantidadDiasRenta() {
        
        mostrarTituloPrograma();
        mostrarNumeroRegistro();
        
        String pedirCantidadDiasRenta = ANSI_MORADO + "Cantidad de dias que se rentará el vehículo (en números): " + ANSI_RESET;
        
        System.out.println(pedirCantidadDiasRenta);
        cantidadDiasRenta = Integer.valueOf(leerEntrada());
        
    }
    
    private void pedirAgregarSeguro() {
        
        mostrarTituloPrograma();
        mostrarNumeroRegistro();
        
        String decisionSeguro = ANSI_AMARILLO + "Desea agregar seguro (1-2): " + ANSI_RESET;
        String si = ANSI_NEGRITA + "  1. " + ANSI_VERDE + "SI" + ANSI_RESET;
        String no = ANSI_NEGRITA + "  2. " + ANSI_VERDE + "NO" + ANSI_RESET;
        
        System.out.println(decisionSeguro);
        System.out.println(si);
        System.out.println(no);
        agregarSeguro = Integer.valueOf(leerEntrada());
        
    }
    
    private int pedirDecision() {
        
        String decisionRegistro = "\n" + ANSI_ROJO + "Continuar con el registro (1-2): " + ANSI_RESET;
        String si = ANSI_NEGRITA + "  1. " + ANSI_VERDE + "SI" + ANSI_RESET;
        String no = ANSI_NEGRITA + "  2. " + ANSI_VERDE + "NO" + ANSI_RESET;
        
        System.out.println(decisionRegistro);
        System.out.println(si);
        System.out.println(no);
        
        return Integer.valueOf(leerEntrada());
        
    }
    
    private String leerEntrada() {
        
        String flecha = ANSI_NEGRITA + "--> " + ANSI_RESET;
        
        System.out.print(flecha); 
        String entrada = scanner.nextLine();
        
        return entrada;
        
    }
    
    public void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    
}
