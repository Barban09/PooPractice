package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Controladora;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cargadatos extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreCliente;
	private JTextField txtRaza;
	private JTextField txtColor;
	private JTextField txtNombDueno;
	private JTextField txtCelDueño;
	/**
	 * Create the frame.
	 */
	public Cargadatos() {
		
		
		
		
		Controladora Control = new Controladora();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 928, 616);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // ⭐ ESTA ES LA LÍNEA IMPORTANTE ⭐
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        JLabel lblCargaDatos = new JLabel("Carga Datos");
        lblCargaDatos.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblCargaDatos.setBounds(308, 11, 253, 32);
        contentPane.add(lblCargaDatos);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("F:\\Mis_Documentos\\Desktop\\Javascript\\PooPractice\\Main\\src\\image2.jpg"));
        lblNewLabel_1.setBounds(525, 145, 225, 258);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("Nombre Cliente");
        lblNewLabel.setBounds(10, 93, 78, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblRaza = new JLabel("Raza:");
        lblRaza.setBounds(10, 145, 86, 14);
        contentPane.add(lblRaza);
        
        JLabel lblAlergico = new JLabel("Color:");
        lblAlergico.setBounds(10, 182, 55, 14);
        contentPane.add(lblAlergico);
        
        JLabel lblAlergico_1 = new JLabel("Alergico:");
        lblAlergico_1.setBounds(10, 215, 55, 14);
        contentPane.add(lblAlergico_1);
        
        JLabel lblAtencionEspecial = new JLabel("Atencion Especial:");
        lblAtencionEspecial.setBounds(10, 253, 115, 14);
        contentPane.add(lblAtencionEspecial);
        
        JLabel lblNombreDueo = new JLabel("Nombre Dueño:");
        lblNombreDueo.setBounds(10, 299, 115, 14);
        contentPane.add(lblNombreDueo);
        
        JLabel txtCelDueno = new JLabel("Cel Dueño:");
        txtCelDueno.setBounds(10, 359, 115, 14);
        contentPane.add(txtCelDueno);
        
        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setBounds(10, 428, 115, 14);
        contentPane.add(lblObservaciones);
        
        txtNombreCliente = new JTextField();
        txtNombreCliente.setBounds(130, 90, 184, 20);
        contentPane.add(txtNombreCliente);
        txtNombreCliente.setColumns(10);
        
        txtRaza = new JTextField();
        txtRaza.setColumns(10);
        txtRaza.setBounds(130, 142, 184, 20);
        contentPane.add(txtRaza);
        
        txtColor = new JTextField();
        txtColor.setColumns(10);
        txtColor.setBounds(130, 179, 184, 20);
        contentPane.add(txtColor);
        
        txtNombDueno = new JTextField();
        txtNombDueno.setColumns(10);
        txtNombDueno.setBounds(130, 296, 184, 20);
        contentPane.add(txtNombDueno);
        
        txtCelDueño = new JTextField();
        txtCelDueño.setColumns(10);
        txtCelDueño.setBounds(130, 356, 184, 20);
        contentPane.add(txtCelDueño);
        
        JTextArea txtObservaciones = new JTextArea();
        txtObservaciones.setBounds(135, 423, 267, 121);
        contentPane.add(txtObservaciones);
        
        JComboBox cmbAlergico = new JComboBox();
        cmbAlergico.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
        cmbAlergico.setBounds(130, 211, 65, 22);
        contentPane.add(cmbAlergico);
        
        JComboBox cmbAtenEspecial = new JComboBox();
        cmbAtenEspecial.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
        cmbAtenEspecial.setBounds(130, 249, 65, 22);
        contentPane.add(cmbAtenEspecial);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String NombreMasco = txtNombreCliente.getText();
        		String Raza = txtRaza.getText();
        		String Color = txtColor.getText();
        		String NombDuenio = txtNombDueno.getText();
        		String CelDuenio = txtCelDueño.getText();
        		String Observaciones = txtObservaciones.getText();
        		String alergico = (String) cmbAlergico.getSelectedItem();
        		String AtenEsp = (String) cmbAtenEspecial.getSelectedItem();
        		Control.guardar(NombreMasco,Raza,Color, NombDuenio, CelDuenio, Observaciones, alergico, AtenEsp);
        		
        		System.out.println(" Guardado Exitoso ");
        	}
        });
        
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGuardar.setBounds(466, 465, 115, 66);
        contentPane.add(btnGuardar);
        
        JButton btnLimpiar = new JButton("Limpiar");
        
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtNombreCliente.setText("");
        		txtRaza.setText("");
        		txtColor.setText("");
        		txtNombDueno.setText("");
        		txtCelDueño.setText("");
        		lblObservaciones.setText("");
        		cmbAlergico.setSelectedIndex(0);
        		cmbAtenEspecial.setSelectedIndex(0);
        	}
        });
        
        btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLimpiar.setBounds(654, 461, 122, 70);
        contentPane.add(btnLimpiar);

	}
}
