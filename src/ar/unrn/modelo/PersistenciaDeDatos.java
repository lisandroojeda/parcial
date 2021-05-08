package ar.unrn.modelo;

import java.util.ArrayList;
import java.time.LocalDateTime;

public interface PersistenciaDeDatos  {
    void nuevaVenta(Venta venta);
    void nuevoCombustible (Combustible combustible,int tipo);
    ArrayList<Venta> listaDeVentas(String fechaInicioConsulta,String fechaFinConsulta);
    Combustible obtenerCombustible(int codigo);
}
