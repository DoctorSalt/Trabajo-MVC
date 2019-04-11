package es.studium.practicamvc;

public class PrincipalAltaGestion {
		VistaAlta va=new VistaAlta();
		Modelo1 mo = new Modelo1(va);
		ControladorAlta ca=new ControladorAlta(va,mo);
}
