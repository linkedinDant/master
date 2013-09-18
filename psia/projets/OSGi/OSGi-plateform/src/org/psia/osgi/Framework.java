package org.psia.osgi;

import java.util.HashMap;
import java.util.Map;

public class Framework {

	static private int ID = 0;	
	final private Map<Integer, Bundle> bundles;
	
	public Framework() {
		bundles = new HashMap<>();
	}

	public Bundle install(String url) {
		int id = ++ID;
		Bundle bundle = new Bundle(url, id, this);
		bundles.put(id, bundle);
		return bundle;
	}
	
	public Bundle get(int id) {
		return bundles.get(id);
	}
	
}
