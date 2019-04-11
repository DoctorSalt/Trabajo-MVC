package es.studium.practicamvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorBaja implements WindowListener, ActionListener{
	
	private VistaBaja vb;
	private Modelo2 mo;
	public String demandanteElegido;
	
	public ControladorBaja(VistaBaja vb1, Modelo2 mo1) {
		vb=vb1;
		mo=mo1;
		
		vb.eliminar.addActionListener(this);
		vb.cancelar.addActionListener(this);
		vb.addWindowListener(this);
		vb.setVisible(true);
		meterDatosChoice();	
	}

	private void meterDatosChoice() {
		String sentencia="Select * from practicamvc.demandantes;";
		mo.meterDatosdeDemandante(sentencia);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(vb.eliminar.equals(e.getSource())) {
			String numeroSeleccionado=vb.demandanteCD.getSelectedItem();
			if(numeroSeleccionado.equals("Seleccione un demandante ...")) {
				System.out.println("Seleccione una opcion en demandante");
			}else {
				demandanteElegido = mo.Elegir(numeroSeleccionado);
				String nombreElegido = mo.ElegirN(numeroSeleccionado);
				vb.si.addActionListener(this);
				vb.no.addActionListener(this);
				vb.confirmarBaja.addWindowListener(this);
				vb.setVisible(false);
				vb.confirmarBajasC(nombreElegido);
			}
		}
		if(vb.cancelar.equals(e.getSource())) {
			vb.setVisible(false);
		}
		if(vb.si.equals(e.getSource())) {
			eliminar();
			vb.confirmarBaja.setVisible(false);
		}
		if(vb.no.equals(e.getSource())) {
			demandanteElegido="";
			vb.confirmarBaja.setVisible(false);
			vb.setVisible(true);
		}
	}

	private void eliminar() {
		String sentencia="Delete from practicamvc.demandantes where idDemandante="+demandanteElegido+";";
		mo.eliminar(sentencia);
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
		if(vb.isActive()) {
			vb.setVisible(false);
		} else if(vb.confirmarBaja.isActive()) {
			vb.confirmarBaja.setVisible(false);
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
