package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Controladora;
import logica.Mascota;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class VerDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaMascota;
	Controladora control = null;

	public VerDatos() {
		control = new Controladora();
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				cargarTabla();
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVisualizacinDeDatos = new JLabel("Visualización de Datos");
		lblVisualizacinDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVisualizacinDeDatos.setBounds(308, 11, 253, 32);
		contentPane.add(lblVisualizacinDeDatos);
		
		tablaMascota = new JTable();
		tablaMascota.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollTabla = new JScrollPane(tablaMascota);
		scrollTabla.setBounds(31, 76, 700, 400);
		contentPane.add(scrollTabla);
		
		JLabel lblNewLabel = new JLabel("Datos de Mascotas");
		lblNewLabel.setBounds(31, 50, 117, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaMascota.getRowCount() > 0) {
					if(tablaMascota.getSelectedRow() != -1){
						//Id Mascota a editar 
						Integer numrow = tablaMascota.getSelectedRow();
						int idelim = (int) tablaMascota.getValueAt(numrow, 0);
						ModificarDatos ModifDatos = new ModificarDatos(idelim);
						ModifDatos.setVisible(true);
						ModifDatos.setLocationRelativeTo(null);
						dispose();
					}
					else {
						mostrarMensaje("No seleccionó ninguna mascota", "Error", "Error al eliminar");					
					}
				}
				else {
					mostrarMensaje("No hay mascotas", "Error", "Error al eliminar");
				
				}
				
				
			}
		 });
		btnEditar.setBounds(775, 76, 180, 74);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Se controla que la tabla tenga registros y se haya seleccionado un registro
				if(tablaMascota.getRowCount() > 0) {
					if(tablaMascota.getSelectedRow() != -1){
						//Id Mascota a eliminar
						Integer numrow = tablaMascota.getSelectedRow();
						int idelim = (int) tablaMascota.getValueAt(numrow, 0);
						control.eliminarMascota(idelim);
						mostrarMensaje("Mascota eliminada correctamente", "Informacion", "Borrado de Mascota");
						cargarTabla();
					}
					else {
						mostrarMensaje("No seleccionó ninguna mascota", "Error", "Error al eliminar");					
					}
				}
				else {
					mostrarMensaje("No hay mascotas", "Error", "Error al eliminar");
				}
			}
				
		});

		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(775, 209, 180, 74);
		contentPane.add(btnEliminar);


		
		
	}
	
	private void cargarTabla() { 
		
		 
		DefaultTableModel tabla = new DefaultTableModel() {
			
			//Row and Column no editable
			@Override
			public boolean isCellEditable (int row, int column) {
				return false;
			}
		};
		
		
		//Set Column Names
		String titulos[] = {"Num","Nombre","Color","Raza","Alergico","AtEsp","Duenio","Cel"};
		tabla.setColumnIdentifiers(titulos); 
		
		List<Mascota> listamascotas = control.traerTodasLasMascotas();
		
		if (listamascotas!=null) {
			for(Mascota masco:listamascotas) {
				Object[] objeto = {masco.getNum_cliente(), masco.getNombre(), masco.getColor(), masco.getRaza(), masco.getAlergico(), masco.getAtencion_especial(),
						masco.getDuenio().getNombre(), masco.getDuenio().getCelDuenio()};
				
				tabla.addRow(objeto);
				
			}
		}
		
		tablaMascota.setModel(tabla);
		
		
		
		
		
	}
	
	private void mostrarMensaje(String mensaje, String tipo, String titulo) {
		JOptionPane optionPane = new JOptionPane(mensaje);
		
		if (tipo.equals("Informacion")) {
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(tipo.equals("Error")) {
			optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
		}
		
		
		JDialog dialog = optionPane.createDialog(titulo);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
	
	
}
