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

import turtle.Choreography;
import turtle.Color;
import turtle.Farm;
import turtle.Forward;
import turtle.SetPen;
import turtle.Stage;
import turtle.Turtle;
import turtle.TurtleFactory;
import turtle.TurtlePackage;
import turtle.impl.TurtleFactoryImpl;

public class TurtleSerializer {

	public Stage loadStage(File f) {
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
	
	public void saveStage(Stage stage, File f) {
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
	
	public Farm loadFarm(File f) {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry registry = rs.getResourceFactoryRegistry();
		Map<String,Object> m = registry.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(TurtlePackage.eNS_URI, TurtlePackage.eINSTANCE);
		URI uri = URI.createFileURI(f.getAbsolutePath());
		Resource resource = rs.getResource(uri, true);
		if (resource.isLoaded() && resource.getContents().size() > 0) {
			return (Farm) resource.getContents().get(0);
		}
		return null;
	}
	
	public void saveFarm(Farm farm, File f) {
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
		resource.getContents().add(farm);
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
		
		TurtleSerializer serializer = new TurtleSerializer();
		
		try {
			// load + print du stage
			Stage s = serializer.loadStage(new File("/workspace/TurtleGraphics/example/Stage2.xmi"));
			System.out.println(s.display());
		} catch(Exception e) {
			System.err.println("Le chemin n'est pas correcte.");
		}
		
		// ---------------------------------------------------------
		
		// load de la farm
		Farm f = serializer.loadFarm(new File("/workspace/TurtleGraphics/example/Farm2.xmi"));

		// création du stage
		TurtleFactory factory = TurtleFactoryImpl.init();
		Stage stage = factory.createStage();
		
		Color color = factory.createColor();
		color.setRed(255);
		stage.setBackgroundColor(color);

		// fabrication d'une choré
		Turtle mamaDidi = factory.createTurtle();
		mamaDidi.setName("mamaDidi");
		
		// on ajoute la turtle dans la ferme
		f.getContains().add(mamaDidi);
		
		SetPen setPen = factory.createSetPen();
		setPen.setTarget(mamaDidi);
		setPen.setUP(false);
		
		Forward forward = factory.createForward();
		forward.setTarget(mamaDidi);
		forward.setLength(100);

		SetPen setPen2 = factory.createSetPen();
		setPen2.setTarget(mamaDidi);
		setPen2.setUP(true);
		
		Choreography chore2 = factory.createChoreography();
		chore2.getSequence().add(forward);
		chore2.getSequence().add(setPen2);
		chore2.getSequence().add(setPen);
		
		stage.getChoreographies().add(chore2);
		stage.getFarms().add(f);
		
		// copie de la farm
		File fileFarmJava = new File("/workspace/TurtleGraphics/example/Farm2-java.xmi");
		serializer.saveFarm(f, fileFarmJava);
		// reload de la farm pour prendre conscience qu'elle existe
		serializer.loadFarm(fileFarmJava);
		
		// on peut enfin sauvegarder le stage dans un fichier
		serializer.saveStage(stage, new File("/workspace/TurtleGraphics/example/Stage2-java.xmi"));
	}
}



