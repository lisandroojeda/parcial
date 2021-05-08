package ar.unrn.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.unrn.modelo.PersistenciaDeDatos;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

    private JPanel contentPane;
    
    private PersistenciaDeDatos persistenciaDeDatos;
    /**
     * Launch the application.
     
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PersistenciaDeDatos persistenciaDeDatos = new PersistenciaDeDatos();
		    PantallaPrincipal frame = new PantallaPrincipal(persistenciaDeDatos);
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    
    
    public PantallaPrincipal(PersistenciaDeDatos persistenciaDeDatos) {
	this.persistenciaDeDatos = persistenciaDeDatos;
	    cargarVentana();
	
    }
    //ver sino sacarlo
    public void mostrarPantallaPrincipal() {
	this.setVisible(true);
    }
    
    //public PantallaPrincipal(PersistenciaDeDatos persistenciaDeDatos) {
	private void cargarVentana() {
    	setResizable(false);
    	setTitle("Estacion de Servicio YPZW");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	
	JPanel panel = new JPanel();
	panel.setBounds(21, 11, 392, 239);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JButton btnCarga = new JButton("Nueva Carga");
	btnCarga.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    CargaCombustible cargarCombustible = new CargaCombustible(persistenciaDeDatos);
		    cargarCombustible.setVisible(true);
		}
	});
	btnCarga.setFont(new Font("Liberation Sans", Font.PLAIN, 24));
	btnCarga.setBounds(0, 0, 193, 239);
	panel.add(btnCarga);
	
	JButton btnListadoVentas = new JButton("Listar Ventas");
	btnListadoVentas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    ListadoDeVentasEnFechas listadoDeVentasEnFechas = new ListadoDeVentasEnFechas(persistenciaDeDatos);
		    listadoDeVentasEnFechas.setVisible(true); 
		}
	});
	btnListadoVentas.setFont(new Font("Liberation Sans", Font.PLAIN, 24));
	btnListadoVentas.setBounds(199, 0, 193, 239);
	panel.add(btnListadoVentas);
    }
}
