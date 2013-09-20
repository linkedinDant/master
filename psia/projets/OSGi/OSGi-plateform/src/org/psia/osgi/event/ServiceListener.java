package org.psia.osgi.event;

import org.psia.osgi.BundleContext;

/**
 * Listener invoqué lors de l'installation / désinstallation d'un bundle. Le BundleContext donné est celui du Bundle
 * sur lequel on effectue l'opération
 * @author pitton
 *
 */

public interface ServiceListener {

	void onResolve(BundleContext context);
	
	void onClose(BundleContext context);
	
}
