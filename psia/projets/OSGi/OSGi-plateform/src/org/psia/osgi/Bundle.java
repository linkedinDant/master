package org.psia.osgi;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bundle implements Closeable {

	static private final Logger logger = Logger.getLogger(Bundle.class
			.getName());
	static private final int INSTALLED = 1;
	static private final int RESOLVED = 2;
	static private final int STARTING = 3;
	static private final int STARTED = 4;
	static private final int STOPPING = 5;

	private String url;
	private int id;
	private Framework framework;
	private int state;
	private Class<Activator> activatorClazz;
	private Activator activator;
	private BundleClassLoader loader;
	private boolean verbose;

	public Bundle(String url, int id, Framework framework, boolean verbose) {
		this.url = url;
		this.id = id;
		this.framework = framework;
		this.verbose = verbose;
		ManagementFactory.getClassLoadingMXBean().setVerbose(verbose);
	}

	public int getBundleId() {
		return id;
	}

	public String url() {
		return url;
	}

	public Framework framework() {
		return framework;
	}

	@SuppressWarnings("unchecked")
	public void resolve() {
		log(Level.INFO, "Démarrage de la résolution du bundle \"" + id
				+ "\"...");
		try {
			loader = new BundleClassLoader(new File(url));
			activatorClazz = (Class<Activator>) loader.loadClass(".");
			state = RESOLVED;
			log(Level.INFO, "Bundle \"" + id + "\" résolu");
		} catch (Exception ex) {
			log(Level.SEVERE, "Erreur dans la résolution du bundle \"" + id
					+ "\"", ex);
		}
	}

	public void start() {
		assert (state == RESOLVED);
		state = STARTING;
		try {
			log(Level.INFO, "Démarrage du bundle \"" + id + "\"");
			activator = activatorClazz.newInstance();
			activator.start(framework);
			state = STARTED;
		} catch (InstantiationException | IllegalAccessException ex) {
			log(Level.SEVERE, "Erreur dans le démarrage du bundle \"" + id
					+ "\"", ex);
		}
	}

	public void stop() {
		state = STOPPING;
		log(Level.INFO, "Arrêt du bundle \"" + id + "\"");
		this.activator.stop(framework);
		state = RESOLVED;
	}

	public void update() {
		int oldState = state;
		state = INSTALLED;
		if (oldState == STARTED) {
			stop();
		}
		resolve();

		if (oldState == STARTED) {
			start();
		}
	}

	@Override
	public void close() throws IOException {
		if (state != STOPPING && state == 0) {
			stop();
		}
		framework = null;
		activator = null;
		activatorClazz = null;
		if (loader != null) {
			loader.close();
		}
		System.gc();
	}

	private void log(Level level, String message) {
		log(level, message, null);
	}

	private void log(Level level, String message, Throwable ex) {
		if (verbose)
			logger.log(level, message, ex);
	}
}
