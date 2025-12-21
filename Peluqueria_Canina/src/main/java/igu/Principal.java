package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 928, 616);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // ⭐ ESTA ES LA LÍNEA IMPORTANTE ⭐
        contentPane.setLayout(null);

        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Peluqueria Canina");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(352, 11, 253, 32);
        contentPane.add(lblNewLabel);
        
        JButton btnCargarDatos = new JButton("Cargar Datos");
        btnCargarDatos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Cargadatos pantalla = new Cargadatos();
        		pantalla.setVisible(true);
        		pantalla.setLocationRelativeTo(null);
        	}
        });
        btnCargarDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCargarDatos.setBounds(36, 97, 212, 80);
        contentPane.add(btnCargarDatos);
        
        JButton btnVerDatos = new JButton("Ver Datos");
        btnVerDatos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VerDatos verdatos = new VerDatos();
        		verdatos.setVisible(true);
        		verdatos.setLocationRelativeTo(null);        			
        	}
        });
        btnVerDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnVerDatos.setBounds(36, 219, 212, 92);
        contentPane.add(btnVerDatos);
        
        JButton btnNewButton_1_1 = new JButton("Salir");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_1.setBounds(36, 351, 212, 92);
        contentPane.add(btnNewButton_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("F:\\Mis_Documentos\\Desktop\\Javascript\\PooPractice\\Main\\src\\image2.jpg"));
        lblNewLabel_1.setBounds(448, 123, 225, 258);
        contentPane.add(lblNewLabel_1);
	}
}
