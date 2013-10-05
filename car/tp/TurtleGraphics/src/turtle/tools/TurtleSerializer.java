package turtle.tools;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import turtle.Action;
import turtle.Choreography;
import turtle.Forward;
import turtle.SetPen;
import turtle.Stage;
import turtle.Turtle;
import turtle.TurtleFactory;
import turtle.TurtlePackage;
import turtle.impl.TurtleFactoryImpl;

public class TurtleSerializer {

	public Stage load(File f) {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry registry = rs.getResourceFactoryRegistry();
		Map<String,Object> m = registry.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(TurtlePackage.eNS_URI, TurtlePackage.eINSTANCE);
		URI uri = URI.createFileURI(f.getAbsolutePath());
		Resource resource = rs.getResource(uri, true);
		if (resource.isLoaded() && resource.getContents().size() > 0) {
			return (Stage) resource.getContents().get(0);
		}
		return null;
	}
	
	public void save(Stage stage, File f) {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry registry = rs.getResourceFactoryRegistry();
		Map<String,Object> m = registry.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put("ecore", new EcoreResourceFactoryImpl());
		rs.getPackageRegistry().put(TurtlePackage.eNS_URI, TurtlePackage.eINSTANCE);
		Resource packageResource = rs.createResource(URI.createFileURI("Turtle.ecore"));
		packageResource.getContents().add(TurtlePackage.eINSTANCE);
		try {
			packageResource.load(null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		URI uri = URI.createFileURI(f.getAbsolutePath());
		Resource resource = rs.createResource(uri);
		resource.getContents().add(stage);
		try {
			HashMap<String, Boolean> options = new HashMap<String, Boolean>();
			options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			resource.save(options);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public void UpdateStage (Stage stage, Choreography choreography) {
		stage.getChoreographies().add(choreography);
	}
	
	public static void main(String[] args) {
		
		TurtleFactory factory = TurtleFactoryImpl.init();
		Stage stage = factory.createStage();
		
		Turtle frank = factory.createTurtle();
		frank.setName("Frank");
		
		SetPen a1 = factory.createSetPen();
		a1.setTarget(frank);
		a1.setUP(false);
		
		Forward a2 = factory.createForward();
		a2.setTarget(frank);
		a2.setLength(100);

		SetPen a3 = factory.createSetPen();
		a3.setTarget(frank);
		a3.setUP(true);
		
		Choreography chore = factory.createChoreography();
		chore.getSequence().add(a1);
		chore.getSequence().add(a2);
		chore.getSequence().add(a3);
		
		stage.getChoreographies().add(chore);
		System.out.println(stage.display());
		
	}
}



