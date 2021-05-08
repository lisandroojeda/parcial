package ar.unrn.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ar.unrn.modelo.PersistenciaDeDatos;
import ar.unrn.modelo.Venta;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class ListadoDeVentasEnFechas extends JFrame {

    private JPanel contentPane;

	private JTable tVentas;
	DefaultTableModel modelo;
	private JTextField tfFechaIni;
	private JTextField txfFechaFIn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

    public ListadoDeVentasEnFechas(PersistenciaDeDatos persistenciaDeDatos) {
    	setTitle("ListadoVentas");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 733, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	JPanel panel2 = new JPanel();
	panel2.setBounds(249, 0, 434, 261);
	contentPane.add(panel2);
	panel2.setLayout(null);
	setLocationRelativeTo(null);
	String[] titulos = { "FECHA", "MONTO","COMBUSTIBLE"};
	modelo = new DefaultTableModel(new Object[][] {}, titulos);
	
	List<Venta> listadoVentas;
	try {
	    	
	        String fechaInicioConsulta =tfFechaIni.getText();
                String fechaFinConsulta = txfFechaFIn.getText();
		listadoVentas  = persistenciaDeDatos.listaDeVentas(fechaInicioConsulta, fechaFinConsulta);
		
		for (Venta v : listadoVentas) {
		    modelo.addRow(new Object[] {v.obtenerFechaCarga(),v.montoVenta(),v.obtenerTipoCombustible()});
		}

		contentPane.add(panel2,BorderLayout.CENTER);
		
		
		tVentas = new JTable();
		tVentas.setBounds(29, 11, 395, 227);
		panel2.add(tVentas);
		tVentas.setModel(modelo);
		
		tfFechaIni = new JTextField();
		tfFechaIni.setBounds(10, 40, 154, 30);
		contentPane.add(tfFechaIni);
		tfFechaIni.setColumns(10);
		
		txfFechaFIn = new JTextField();
		txfFechaFIn.setBounds(10, 103, 154, 30);
		contentPane.add(txfFechaFIn);
		txfFechaFIn.setColumns(10);
		
		lblNewLabel = new JLabel("Fecha Inicio");
		lblNewLabel.setBounds(10, 11, 99, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Fecha fin");
		lblNewLabel_1.setBounds(10, 81, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Liberation Sans", Font.BOLD, 18));
		btnNewButton.setBounds(10, 168, 154, 41);
		contentPane.add(btnNewButton);
	}catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

	}
    }

}
