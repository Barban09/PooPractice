package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Controladora;
import logica.Mascota;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreCliente;
	private JTextField txtRaza;
	private JTextField txtColor;
	private JTextField txtNombDuenio;
	private JTextField txtCelDuenio;
	private int numcliente;
	Controladora control = null;
	private JTextField txtObservaciones;
	private JComboBox cmbAlerg;
	private JComboBox cmbAtenEspecial;
	private Mascota MascoAEdit;

	public ModificarDatos(int idelim) {
		
		this.numcliente = idelim;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarDatos = new JLabel("Modificar Datos");
		lblModificarDatos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblModificarDatos.setBounds(362, 11, 253, 32);
		contentPane.add(lblModificarDatos);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreCliente.setBounds(20, 77, 119, 14);
		contentPane.add(lblNombreCliente);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(174, 74, 294, 20);
		contentPane.add(txtNombreCliente);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(174, 110, 111, 20);
		contentPane.add(txtRaza);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRaza.setBounds(20, 113, 86, 14);
		contentPane.add(lblRaza);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColor.setBounds(20, 154, 55, 14);
		contentPane.add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(174, 151, 184, 20);
		contentPane.add(txtColor);
		
		JLabel lblAlergico = new JLabel("Alergico:");
		lblAlergico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlergico.setBounds(20, 198, 55, 18);
		contentPane.add(lblAlergico);
		
		this.cmbAlerg = new JComboBox();
		cmbAlerg.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
		cmbAlerg.setBounds(174, 194, 65, 22);
		contentPane.add(cmbAlerg);
		
		JLabel lblAtencionEspecial = new JLabel("Atencion Especial:");
		lblAtencionEspecial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAtencionEspecial.setBounds(20, 236, 115, 14);
		contentPane.add(lblAtencionEspecial);
		
		this.cmbAtenEspecial = new JComboBox();
		cmbAtenEspecial.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
		cmbAtenEspecial.setBounds(174, 232, 65, 22);
		contentPane.add(cmbAtenEspecial);
		
		JLabel lblNombreDuenio = new JLabel("Nombre Dueño:");
		lblNombreDuenio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreDuenio.setBounds(20, 279, 115, 14);
		contentPane.add(lblNombreDuenio);
		
		txtNombDuenio = new JTextField();
		txtNombDuenio.setColumns(10);
		txtNombDuenio.setBounds(174, 276, 184, 20);
		contentPane.add(txtNombDuenio);
		
		JLabel txtCelDueno = new JLabel("Cel Dueño:");
		txtCelDueno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCelDueno.setBounds(20, 322, 115, 14);
		contentPane.add(txtCelDueno);
		
		txtCelDuenio = new JTextField();
		txtCelDuenio.setColumns(10);
		txtCelDuenio.setBounds(174, 320, 184, 20);
		contentPane.add(txtCelDuenio);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblObservaciones.setBounds(20, 375, 115, 14);
		contentPane.add(lblObservaciones);
		
		JButton btnGuardarDatos = new JButton("Guardar");
		btnGuardarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreMasco = txtNombreCliente.getText();
				String raza = txtRaza.getText();
				String color = txtColor.getText();
				String alergico = (String) cmbAlerg.getSelectedItem();
				String atencion_especial = (String) cmbAtenEspecial.getSelectedItem();
				String observaciones = txtObservaciones.getText();				
				
				
				String CelDuenio = txtCelDuenio.getText();
				String NombDuenio = txtNombDuenio.getText();
				
				control = new Controladora();
				control.EditarMascota(MascoAEdit, nombreMasco, raza, color, alergico, atencion_especial, observaciones, CelDuenio, NombDuenio);
        		VerDatos verdatos = new VerDatos();
        		verdatos.setVisible(true);
        		verdatos.setLocationRelativeTo(null);  
				dispose();
   
				
				
			}
		});
		btnGuardarDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardarDatos.setBounds(656, 389, 115, 66);
		contentPane.add(btnGuardarDatos);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\Mis_Documentos\\Desktop\\Javascript\\PooPractice\\Main\\src\\image2.jpg"));
		lblNewLabel_1.setBounds(586, 74, 225, 258);
		contentPane.add(lblNewLabel_1);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setColumns(10);
		txtObservaciones.setBounds(174, 373, 253, 113);
		contentPane.add(txtObservaciones);
		cargarDatos(numcliente);
	}


	private void cargarDatos(int numcliente) {
		control = new Controladora();
		MascoAEdit = control.traerMascota(numcliente);
		txtNombreCliente.setText(MascoAEdit.getNombre());
		txtRaza.setText(MascoAEdit.getRaza());
		txtColor.setText(MascoAEdit.getColor());
		txtNombDuenio.setText(MascoAEdit.getDuenio().getNombre());
		txtCelDuenio.setText(MascoAEdit.getDuenio().getCelDuenio());
		txtObservaciones.setText(MascoAEdit.getObservaciones());
		
		
		if (MascoAEdit.getAlergico().equals("Si")) {
			cmbAlerg.setSelectedIndex(1);
		}
		else {
			if (MascoAEdit.getAlergico().equals("No")) {
				cmbAlerg.setSelectedIndex(2);
			}
			else {
				cmbAlerg.setSelectedIndex(0);
			}
		}
		
		System.out.println(MascoAEdit.getAtencion_especial());
		if (MascoAEdit.getAtencion_especial().equals("Si")) {
			cmbAtenEspecial.setSelectedIndex(1);
		}
		else {
			if (MascoAEdit.getAtencion_especial().equals("No")) {
				cmbAtenEspecial.setSelectedIndex(2);
			}
			else {
				cmbAtenEspecial.setSelectedIndex(0);
			}
		}		
		
		
	}
}
