/*
 * Copyright 2006 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.eclipse.maihime;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sysdeo.eclipse.tomcat.TomcatLauncherPlugin;

/**
 * The main plugin class to be used in the desktop.
 */
public class MaihimePlugin extends AbstractUIPlugin {

	// The shared instance.
	private static MaihimePlugin plugin;

	/**
	 * The constructor.
	 */
	public MaihimePlugin() {
		setDefalut(this);
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		setDefalut(null);
	}

	/**
	 * Returns the shared instance.
	 */
	public static MaihimePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.seasar.eclipse.maihime", path);
	}

	public static String getContextsDir() {
			return TomcatLauncherPlugin.getDefault().getContextsDir();
	}

	private static void setDefalut(MaihimePlugin plugin) {
		MaihimePlugin.plugin = plugin;
	}
}
