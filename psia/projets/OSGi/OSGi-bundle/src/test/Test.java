package test;

import org.psia.osgi.Activator;
import org.psia.osgi.Framework;

public class Test implements Activator {

	@Override
	public void start(Framework f) {
		System.out.println("Je démarre !");
	}

	@Override
	public void stop(Framework f) {
		System.out.println("Je m'arrête !");
	}

}
