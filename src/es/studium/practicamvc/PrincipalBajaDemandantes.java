package es.studium.practicamvc;

public class PrincipalBajaDemandantes {
	VistaBaja vb=new VistaBaja();
	Modelo2 mo = new Modelo2(vb);
	ControladorBaja cb = new ControladorBaja(vb,mo);  
}
