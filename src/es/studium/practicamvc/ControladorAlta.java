package es.studium.practicamvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class ControladorAlta implements WindowListener, ActionListener{
	
	public VistaAlta va;
	public Modelo1 ma;
	
	ControladorAlta(VistaAlta va1, Modelo1 ma1){
		va=va1;
		ma=ma1;
		meterDatosChoice();
		va.fechaT.setText(ma.actualFecha());
		va.aceptar.addActionListener(this);
		va.cancelar.addActionListener(this);
		va.addWindowListener(this);
		va.setVisible(true);
	}

	private void meterDatosChoice() {
		String sentencia="Select * from practicamvc.ofertas;";
		ma.meterDatosdeOfertanteC(sentencia);
		sentencia="Select * from practicamvc.demandantes;";
		ma.meterDatosdeDemandante(sentencia);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(va.aceptar.equals(e.getSource())) {
			String fechaRecogida =	va.fechaT.getText();
			String fechaAmericana = ma.americanizacionFecha(fechaRecogida);
			String ofertaSeleccionada = va.ofertaC.getSelectedItem();
			String demandanteSeleccionado = va.demandanteC.getSelectedItem();
			if(ofertaSeleccionada.equals("Seleccione una oferta ...")) {
				JOptionPane.showMessageDialog (null, "Tiene que seleccionar una opcion en oferta", "Tiene que seleccionar", JOptionPane.INFORMATION_MESSAGE);
			}else {
				String ofertaElegida = ma.Elegir(ofertaSeleccionada);
				if(demandanteSeleccionado.equals("Seleccione un demandante ...")) {
					JOptionPane.showMessageDialog (null, "Tiene que seleccionar una opcion en oferta", "Tiene que seleccionar", JOptionPane.INFORMATION_MESSAGE);
				}else {
					String demandanteElegido = ma.Elegir(demandanteSeleccionado);
					insertarDatos(fechaAmericana, ofertaElegida, demandanteElegido);
				}
			}
			
		}
		if(va.cancelar.equals(e.getSource())) {
			va.setVisible(false);
		}
	}

	private void insertarDatos(String fechaAmericana, String ofertaSeleccionada, String demandanteSeleccionado) {
		String sentencia="INSERT into practicamvc.asignaciones values(null,"+fechaAmericana+","+ofertaSeleccionada+","+demandanteSeleccionado+");";
		ma.insertarDatosDeAlta(sentencia);
		JOptionPane.showMessageDialog (null, "La alta se produjo correctamente", "Alta Completada", JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(va.isActive()) {
			va.setVisible(false);
		}		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
