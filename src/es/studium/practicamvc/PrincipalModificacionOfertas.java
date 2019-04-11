package es.studium.practicamvc;

public class PrincipalModificacionOfertas {
	VistaModificaciones vm=new VistaModificaciones();
	Modelo3 mo = new Modelo3(vm);
	ControladorModificaciones cm = new ControladorModificaciones(vm,mo);  
}
