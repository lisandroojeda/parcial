package ar.unrn.main;

import ar.unrn.db.JdbcMysql;
import ar.unrn.ui.PantallaPrincipal;

public class Main {
    public static void main(String [] args) {

	PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(new JdbcMysql());
	pantallaPrincipal.mostrarPantallaPrincipal();
    }
}
