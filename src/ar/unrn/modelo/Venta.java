package ar.unrn.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venta {
    
    private LocalDateTime fechaDeCarga;
    private int cantidadLitros;
    //ps.setTimestamp(3, java.sql.Timestamp.valueOf(notificacion.getFechaHora()));
    private Combustible combustible;
    
    
    public Venta (LocalDateTime fechaCarga,int cantidadLitros, Combustible combustible) {
	
	if (fechaCarga == null)// || fechaCarga.isEmpty())
            throw new RuntimeException("Debe ingresar una fecha");
	if (cantidadLitros < 0) {
	    throw new RuntimeException("Debe cargar una cantidad de litros validad");
	}
	if (combustible == null)
	    throw new RuntimeException("Debe ingresar un combustible valido");

	
	this.fechaDeCarga = fechaCarga;
	this.cantidadLitros = cantidadLitros;
	this.combustible = combustible;
    }
    
    public float montoVenta() {
	return cantidadLitros + combustible.Descuento(this.fechaDeCarga);
    }
    
    public String obtenerFechaCarga() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	return this.fechaDeCarga.format(formatter);
	
    }
    
    public String obtenerTipoCombustible() {
	return this.combustible.obtenerNombre();
    }
   
    
    
    
}
