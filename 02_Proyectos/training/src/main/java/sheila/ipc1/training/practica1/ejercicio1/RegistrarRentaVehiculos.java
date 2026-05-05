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
    
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
    
        System.out.println("Ejecutando...");
        
        iniciarRegistro();
    
        mostrarReportes();
        
    }
    
    private void iniciarRegistro() {
        
        int continuarRegistro;
        
        do {
            registrarDatos();
            calcularDatos();
	
            mostrarRegistroActual();
		
            System.out.println("Continuar con el registro (SI/NO): ");
            continuarRegistro = Integer.valueOf(leerEntrada());
            
            rentaMayor();
		
            totalRentasRealizadas = totalRentasRealizadas + 1;
		            
        } while (continuarRegistro == 1);
    
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
    
    private void mostrarTitulo() {
        
        System.out.println("REGISTRO DE RENTA DE VEHICULOS");
        
    }
    
    private void mostrarNumeroRegistro() {
        
        System.out.println("Registro #");
        
    }
    
    private void pedirNombreCliente() {
        
        System.out.println("Escriba el nombre del cliente: ");
        nombreCliente = leerEntrada();
        
    }
    
    private void pedirTipoVehiculo() {
        
        System.out.println("Escriba el tipo del vehículo (1-4): ");
        System.out.println("1. SEDAN");
        System.out.println("2. PICKUP");
        System.out.println("3. MOTOCICLETA");
        System.out.println("4. CAMION");
        tipoVehiculo = Integer.valueOf(leerEntrada());
        
    }
    
    private void pedirCantidadDiasRenta() {
        
        System.out.println("Cantidad de dias que se rentará el vehículo (en números): ");
        cantidadDiasRenta = Integer.valueOf(leerEntrada());
        
    }
    
    private void pedirAgregarSeguro() {
        
        System.out.println("Desea agregar seguro: ");
        System.out.println("1. SI");
        System.out.println("2. NO");
        agregarSeguro = Integer.valueOf(leerEntrada());
        
    }
    
    private String leerEntrada() {
        
        System.out.print("-->"); 
        String entrada = scanner.nextLine();
        
        return entrada;
        
    }
}
