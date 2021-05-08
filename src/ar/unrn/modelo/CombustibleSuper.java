package ar.unrn.modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class CombustibleSuper extends Combustible{


    private final float porcentajeDescuentoDel10 = (float) 0.10;
    private final float porcentajeDescuentoDel12 = (float) 0.12;
    
    public CombustibleSuper(String nombre, float precio) {
	super(nombre, precio);
    }

    @Override
    public float Descuento(LocalDateTime fechaDeCarga) {
	
	if (esDomingo(fechaDeCarga))
	    return this.precio*porcentajeDescuentoDel10;
	
	if (esSabado(fechaDeCarga))
	    return this.precio*porcentajeDescuentoDel12;
	
	return 0;
    }
    
    public boolean esDomingo(LocalDateTime fechaDeCarga) {
	return fechaDeCarga.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
    

    public boolean esSabado(LocalDateTime fechaDeCarga) {
	return fechaDeCarga.getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }

}
