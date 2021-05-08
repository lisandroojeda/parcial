package ar.unrn.ui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import ar.unrn.modelo.*;

public class CargaCombustible extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     * 
     * public static void main(String[] args) { EventQueue.invokeLater(new
     * Runnable() { public void run() { try { CargaCombustible frame = new
     * CargaCombustible(); frame.setVisible(true); } catch (Exception e) {
     * e.printStackTrace(); } } }); }
     * 
     * /** Create the frame.
     */
    public CargaCombustible(PersistenciaDeDatos persistenciaDeDatos) {
	setTitle("Carga");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);

	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 434, 261);
	contentPane.add(panel);
	panel.setLayout(null);

	JLabel lblCantidadDeLitros = new JLabel("Litros");
	lblCantidadDeLitros.setFont(new Font("Liberation Sans", Font.BOLD, 18));
	lblCantidadDeLitros.setBounds(10, 22, 124, 20);
	panel.add(lblCantidadDeLitros);

	JLabel lblNewLabel_1 = new JLabel("Tipo Nafta");
	lblNewLabel_1.setFont(new Font("Liberation Sans", Font.BOLD, 18));
	lblNewLabel_1.setBounds(10, 82, 124, 21);
	panel.add(lblNewLabel_1);

	textField = new JTextField();
	textField.setFont(new Font("Liberation Sans", Font.BOLD, 18));
	textField.setBounds(190, 22, 165, 30);
	panel.add(textField);
	textField.setColumns(10);

	JComboBox cbxTipoNafta = new JComboBox();
	cbxTipoNafta.setFont(new Font("Liberation Sans", Font.BOLD, 18));
	cbxTipoNafta.setBounds(190, 73, 165, 30);
	panel.add(cbxTipoNafta);

	JButton btnNewButton = new JButton("CALCULAR $");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    Venta venta = null;
		    if (cbxTipoNafta.getSelectedIndex() == 1) {
			CombustibleSuper combustible = (CombustibleSuper) persistenciaDeDatos
				.obtenerCombustible(cbxTipoNafta.getSelectedIndex());
			venta = new Venta(LocalDateTime.now(), Integer.parseInt(lblCantidadDeLitros.getText()),
				combustible);
		    }
		    if (cbxTipoNafta.getSelectedIndex() == 0) {
			CombustibleComun combustible = (CombustibleComun) persistenciaDeDatos
				.obtenerCombustible(cbxTipoNafta.getSelectedIndex());
			venta = new Venta(LocalDateTime.now(), Integer.parseInt(lblCantidadDeLitros.getText()),
				combustible);
		    }
		    JOptionPane.showMessageDialog(null, "El monto de la venta es de "+venta.montoVenta(), "Mostrando Monto", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, ex.getMessage(), "Problemas", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});
	btnNewButton.setFont(new Font("Liberation Sans", Font.BOLD, 14));
	btnNewButton.setBounds(56, 151, 136, 83);
	panel.add(btnNewButton);

	JButton btnNewButton_1 = new JButton("CONFIRMAR");
	btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    Venta venta = null;
		    if (cbxTipoNafta.getSelectedIndex() == 1) {
			CombustibleSuper combustible = (CombustibleSuper) persistenciaDeDatos
				.obtenerCombustible(cbxTipoNafta.getSelectedIndex());
			venta = new Venta(LocalDateTime.now(), Integer.parseInt(lblCantidadDeLitros.getText()),
				combustible);
		    }
		    if (cbxTipoNafta.getSelectedIndex() == 0) {
			CombustibleComun combustible = (CombustibleComun) persistenciaDeDatos
				.obtenerCombustible(cbxTipoNafta.getSelectedIndex());
			venta = new Venta(LocalDateTime.now(), Integer.parseInt(lblCantidadDeLitros.getText()),
				combustible);
		    }
		    persistenciaDeDatos.nuevaVenta(venta);
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, ex.getMessage(), "Problemas", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});
	btnNewButton_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
	btnNewButton_1.setBounds(236, 151, 136, 83);
	panel.add(btnNewButton_1);
	setLocationRelativeTo(null);
    }

}
