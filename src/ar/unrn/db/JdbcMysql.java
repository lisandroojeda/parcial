package ar.unrn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import ar.unrn.modelo.Combustible;
import ar.unrn.modelo.CombustibleComun;
import ar.unrn.modelo.CombustibleSuper;
import ar.unrn.modelo.PersistenciaDeDatos;
import ar.unrn.modelo.Venta;

public class JdbcMysql implements PersistenciaDeDatos {

    public Connection getConnection() {
	try {
	    String clave = "";
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:parcial:root:" + clave);
	    return connection;
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}

    }

    @Override
    public void nuevaVenta(Venta venta) {
	try (Connection conn = getConnection();
		PreparedStatement statement = conn
			.prepareStatement("insert into Venta (fecha,fk_combustible,litros) values (?,?,?)");) {
	    statement.setString(1, venta.obtenerFechaCarga());
	    statement.setInt(2, 1);
	    statement.setInt(3, 10);

	} catch (SQLException ex) {
	    throw new RuntimeException(ex);
	}

    }

    @Override
    public void nuevoCombustible(Combustible combustible,int tipo) {
	try (Connection conn = getConnection();
		PreparedStatement statement = conn
			.prepareStatement("insert into Combustible (nombre,monto,tipo) values (?,?,?)");) {
	    statement.setString(1, combustible.obtenerNombre());
	    statement.setFloat(2, combustible.obtenerPrecio());
	    statement.setFloat(3, tipo);

	} catch (SQLException ex) {
	    throw new RuntimeException(ex);
	}

    }

    @Override
    public ArrayList<Venta> listaDeVentas(String fechaInicioConsulta, String fechaFinConsulta) {

	ArrayList<Venta> listado = new ArrayList<>();
	try (Connection conn = getConnection();
		PreparedStatement statement = conn
			.prepareStatement("Select fecha,litros,combustible.nombre,combustible.monto,combustible.tipo from venta join combustible on combustible.codigo = venta.fk_combustible"
				+ "where venta.fecha between ? and ?");) {
	    statement.setString(1, fechaInicioConsulta);
	    statement.setString(2,fechaFinConsulta);
	    ResultSet rs = statement.executeQuery();
	    while (rs.next()) {
		 Combustible combustible = null;
		if (rs.getInt("combustible.tipo")==0)
		    combustible = new CombustibleComun(rs.getString("combustible.nombre"),rs.getFloat("combustible.monto"));
		if (rs.getInt("combustible.tipo")==1)
		    combustible = new CombustibleSuper(rs.getString("combustible.nombre"),rs.getFloat("combustible.monto"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(rs.getString("fecha"), formatter);

		Venta venta = new Venta(dateTime,rs.getInt("litros"),combustible);
		listado.add(venta);
	}
	    return listado;
	} catch (SQLException ex) {
	    throw new RuntimeException(ex);
	}
    }

    @Override
    public Combustible obtenerCombustible(int codigo) {
	try (Connection conn = getConnection();
		PreparedStatement statement = conn
			.prepareStatement("Select nombre,monto from combustible where codigo = ?");) {
	    statement.setInt(1, codigo);
	    ResultSet rs = statement.executeQuery();
	    if (rs.next()) {
		Combustible combustible = new CombustibleSuper(rs.getString("nombre"), rs.getFloat("monto"));
	    } else {
		throw new RuntimeException("No se encontro el registro");
	    }
	} catch (SQLException ex) {
	    throw new RuntimeException(ex);
	}
	return null;
    }


}
