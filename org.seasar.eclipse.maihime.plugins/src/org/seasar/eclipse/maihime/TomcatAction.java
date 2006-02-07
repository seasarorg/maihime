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

import com.sysdeo.eclipse.tomcat.TomcatLauncherPlugin;

/**
 * @author Satoshi Kimura
 */
public class TomcatAction {
	public static void start() {
		if (TomcatLauncherPlugin.checkTomcatSettingsAndWarn()) {
			try {
				TomcatLauncherPlugin.getDefault().getTomcatBootstrap().start();
			} catch (Exception ex) {
				String msg = TomcatLauncherPlugin.getResourceString("msg.start.failed");
				TomcatLauncherPlugin.log(msg + "/n");
				TomcatLauncherPlugin.log(ex);
			}
		}
	}

	public static void stop() {
		if (TomcatLauncherPlugin.checkTomcatSettingsAndWarn()) {
			try {
				TomcatLauncherPlugin.getDefault().getTomcatBootstrap().stop();
			} catch (Exception ex) {
				String msg = TomcatLauncherPlugin.getResourceString("msg.stop.failed");
				TomcatLauncherPlugin.log(msg + "/n");
				TomcatLauncherPlugin.log(ex);
			}
		}
	}

	public static void restart() {
		if (TomcatLauncherPlugin.checkTomcatSettingsAndWarn()) {
			try {
				TomcatLauncherPlugin.getDefault().getTomcatBootstrap().restart();
			} catch (Exception ex) {
				String msg = TomcatLauncherPlugin.getResourceString("msg.restart.failed");
				TomcatLauncherPlugin.log(msg + "/n");
				TomcatLauncherPlugin.log(ex);
			}
		}
	}

}
