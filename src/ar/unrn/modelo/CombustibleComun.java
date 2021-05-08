package ar.unrn.modelo;

import java.time.LocalDateTime;

public class CombustibleComun extends Combustible {

    
    private final float porcentajeDescuentoDel5 = (float) 0.05;    
    private final int horaInicioPromo = 8;
    private final int horaFinPromo = 10;
    
    public CombustibleComun(String nombre, float precio) {
	super(nombre, precio);
    }

    @Override
    public float Descuento(LocalDateTime fechaDeCarga) {
	
	if (enHorarioDePromo(fechaDeCarga))
	    return this.precio*porcentajeDescuentoDel5;

	return 0;
    }
    
    public boolean enHorarioDePromo(LocalDateTime fechaDeCarga) {
	return fechaDeCarga.getHour()>= horaInicioPromo && fechaDeCarga.getHour()<=horaFinPromo;
    }

}
