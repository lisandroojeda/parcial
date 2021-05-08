package ar.unrn.modelo;

import java.time.LocalDateTime;

public abstract class Combustible {
    
    protected float precio;
    protected String nombre;
    
    
    
    public Combustible (String nombre, float precio) {
	if (nombre == null || nombre.isEmpty())
            throw new RuntimeException("Debe cargar un nombre");
	if (precio < 0) {
	    throw new RuntimeException("Debe cargar un monto valido");
	}
	
	
	this.nombre = nombre;
	this.precio = precio;
	
    }
    
    public float obtenerPrecio() {
	return this.precio;
    }
    
    public String obtenerNombre() {
	return this.nombre;
    }
    
    public abstract float Descuento(LocalDateTime fechaDeCarga);

}
