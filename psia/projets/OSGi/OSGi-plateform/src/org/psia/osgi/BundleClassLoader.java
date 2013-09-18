package org.psia.osgi;

import java.net.URL;
import java.net.URLClassLoader;

public class BundleClassLoader extends URLClassLoader {

	public BundleClassLoader(URL url) {
		super(new URL[]{url});
	}

}
