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

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

/**
 * @author Satoshi Kimura
 */
public class UpdateButtonListener extends DefaultSelectionListener {
    private List checkboxs;
    private MaihimeView viewPart;

    public UpdateButtonListener(final List checkboxs, final MaihimeView viewPart) {
        this.checkboxs = checkboxs;
        this.viewPart = viewPart;
    }

    public void widgetSelected(SelectionEvent e) {
        synchronized (this.viewPart) {
            update();
        }
    }

    private void update() {
        for (Iterator iterator = this.checkboxs.iterator(); iterator.hasNext();) {
            Button checkbox = (Button) iterator.next();
            update(checkbox);
        }
        this.viewPart.layout();
    }

    private void update(Button checkbox) {
        File confDir = new File(MaihimePlugin.getContextsDir());
        File xml = new File(confDir, checkbox.getText());
        if (checkbox.getSelection() == true) {
            xml.renameTo(new File(xml.getAbsolutePath().replaceFirst("\\_*$", "")));
            checkbox.setText(checkbox.getText().replaceFirst("\\_*$", ""));
        } else if (checkbox.getText().endsWith(".xml")) {
            xml.renameTo(new File(xml.getAbsolutePath() + "_"));
            checkbox.setText(checkbox.getText() + "_");
        }
    }

}
