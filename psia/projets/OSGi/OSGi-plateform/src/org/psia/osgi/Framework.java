package org.psia.osgi;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Framework implements Closeable {

	private int ID = 0;	
	final private Map<Integer, Bundle> bundles;
	
	public Framework() {
		bundles = new HashMap<>();
	}

	public Bundle install(String url, boolean verbose) {
		int id = ++ID;
		Bundle bundle = new Bundle(url, id, this, verbose);
		bundles.put(id, bundle);
		return bundle;
	}
	
	public Bundle install(String url) {
		return install(url, false);
	}
	
	public Bundle get(int id) {
		return bundles.get(id);
	}

	@Override
	public void close() throws IOException {
		for(Bundle bundle : bundles.values()) {
			bundle.close();
		}
		bundles.clear();
	}
	
}
