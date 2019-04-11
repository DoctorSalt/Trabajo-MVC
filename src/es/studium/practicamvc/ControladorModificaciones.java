package es.studium.practicamvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorModificaciones implements WindowListener, ActionListener{
private VistaModificaciones vis;
private VistaModificaciones2 vis2;
private Modelo3 mo;

ControladorModificaciones(VistaModificaciones v1, Modelo3 m){
	vis=v1;
	mo=m;
	vis.addWindowListener(this);
	vis.editar.addActionListener(this);
	vis.cancelar.addActionListener(this);
	vis.setVisible(true);
	mo.MeterDatosChoice();
}


@Override
public void actionPerformed(ActionEvent arg0) {
	if(vis.editar.equals(arg0.getSource())) {
		String elegido=vis.ofertaCM.getSelectedItem();
		if(elegido.equals("Seleccione oferta ...")) {
			System.out.println("Eliga alguna oferta");
		}else {
		String numeroElegido=mo.Elegir(elegido);
		String nombreElegido=mo.RecogerNombre(numeroElegido);
		vis.setVisible(false);
		vis2 = new VistaModificaciones2(nombreElegido);
		vis2.addWindowListener(this);
		vis2.actualizar.addActionListener(this);
		vis2.cancelar.addActionListener(this);
		cargarDatos(numeroElegido);
		}
	}
	if(vis.cancelar.equals(arg0.getSource())) {
		vis.setVisible(false);
	}if(vis2.actualizar.equals(arg0.getSource())) {
		String fecha =mo.americanizacionFecha(vis2.fecha1T.getText());
		String fechaFin =mo.americanizacionFecha(vis2.fecha2T.getText());
		String requisitos =vis2.requisitosT.getText();
	}if(vis2.cancelar.equals(arg0.getSource())) {
		vis2.setVisible(false);
		vis.setVisible(true);
	}
	
}
private void cargarDatos(String numero) {
	String [] datos=mo.datosRellena(numero);
	vis2.fecha1T.setText(mo.fechaNormalizacion(datos[0]));
	vis2.fecha2T.setText(mo.fechaNormalizacion(datos[1]));
	vis2.requisitosT.setText(datos[2]);
}


@Override
public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosing(WindowEvent arg0) {
	if(vis.isActive()) {
		vis.setVisible(false);
	}if(vis2.isActive()) {
		vis2.setVisible(false);
	}	
}
@Override
public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeiconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowOpened(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}


}
