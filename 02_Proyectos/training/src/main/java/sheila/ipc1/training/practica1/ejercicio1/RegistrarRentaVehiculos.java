package sheila.ipc1.training.practica1.ejercicio1;

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
    private String tipoVehiculo;
    private boolean agregarSeguro = true;
    private int cantidadDiasRenta = 0;
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

    public void iniciar() {
    
        iniciarRegistro();
    
        mostrarReportes();
    }
    
    public void iniciarRegistro() {
        
        boolean continuarRegistro = true;
        
        do {
            registrarDatos();
            calcularDatos();
	
            mostrarRegistroActual();
		
            System.out.println("Continuar con el registro (SI/NO): ");
		
            totalRentasRealizadas = totalRentasRealizadas + 1;
		
            rentaMayor();
            
        } while (continuarRegistro);
    
    }
    
    public void registrarDatos() {
        
    }
    
    public void calcularDatos() {
        
        int subtotalSeguro = 0;
        int total = 0;
        
        if (agregarSeguro) {
            subtotalSeguro = cantidadDiasRenta * COSTO_ADICIONAL_SEGURO;
        }
        
        switch(tipoVehiculo) {
            case "Sedan":
                total = PRECIO_BASE_SEDAN * cantidadDiasRenta + subtotalSeguro;
                
                sedanRentados = sedanRentados + 1;
                diasRentadosSedan = diasRentadosSedan + cantidadDiasRenta; 
                
                break;
                
            case "Pickup":
                total = PRECIO_BASE_PICKUP * cantidadDiasRenta + subtotalSeguro;
                
                pickupRentados = pickupRentados + 1;
                diasRentadosPickup = diasRentadosPickup + cantidadDiasRenta;
                
                break;
            
            case "Motocicleta":
                total = PRECIO_BASE_MOTO * cantidadDiasRenta + subtotalSeguro;
                
                motoRentadas = motoRentadas + 1;
                diasRentadosMoto = diasRentadosMoto + cantidadDiasRenta;
                
                break;
             
            case "Camion":
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
    
    public int calcularPromedioSedan() {
        return diasRentadosSedan / sedanRentados;
    }
    
    public int calcularPromedioPickup() {
        return diasRentadosPickup / pickupRentados;
    }
    
    public int calcularPromedioMoto() {
        return diasRentadosMoto / motoRentadas;
    }
    
    public int calcularPromedioCamion() {
        return diasRentadosCamion / camionRentados;
    }
    
    public void mostrarRegistroActual() {
        
        
        
    }
    
    public void rentaMayor() {
        if (rentaMasGrande < precioTotalRegistroActual) {
            
            rentaMasGrande = precioTotalRegistroActual;
            
            nombreClienteRentaGrande = nombreCliente;
        }
    }
    
    public void mostrarReportes() {
        
        
        
    }
}
