package org.psia.osgi;

public class Bundle {

	static private final int INSTALLED = 1;
	static private final int RESOLVED = 2;
	static private final int STARTING = 3;
	static private final int STARTED = 4;
	static private final int STOPPING = 5;

	private String url;
	private int id;
	private Framework framework;
	private int state;

	public Bundle(String url, int id, Framework framework) {
		this.url = url;
		this.id = id;
		this.framework = framework;
		state = INSTALLED;
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

	public void resolve() {
		state = RESOLVED;
	}

	public void start() {
		state = STARTING;
		
		state = STARTED;
	}

	public void stop() {
		assert(state == STARTED);
		state = STOPPING;
		
		state = RESOLVED;
	}

	public void update() {

	}
}
