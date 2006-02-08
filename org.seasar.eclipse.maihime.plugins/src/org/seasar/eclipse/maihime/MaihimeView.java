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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

/**
 * @author Satoshi Kimura
 */
public class MaihimeView extends ViewPart {
	private static final String XML = ".xml"; //$NON-NLS-1$

	private Composite composite;
	private Composite parent;

	public MaihimeView() {
		super();
	}

	public synchronized void createPartControl(final Composite parentComposite) {
		this.parent = parentComposite;
		layout();
	}

	public void setFocus() {
		// empty
	}

	public synchronized void layout() {
		 Color white = Display.getDefault().getSystemColor(SWT.COLOR_LIST_BACKGROUND);

		if (this.composite != null) {
			this.composite.dispose();
		}

		ScrolledForm form = new ScrolledForm(this.parent);
		this.composite = form;
		form.setBackground(white);
		Composite body = form.getBody();

		body.setBackground(white);
		body.setLayout(new GridLayout(1, true));

		Label label = new Label(body, SWT.READ_ONLY);
		label.setText(Messages.getString("MaihimeView.check")); //$NON-NLS-1$
		label.setBackground(white);

		String[] xmls = new File(MaihimePlugin.getContextsDir()).list();
		List checkboxs = new ArrayList();
		for (int i = 0; i < xmls.length; i++) {
			if (xmls[i].indexOf(XML) < 0) {
				continue;
			}
			Button checkbox = new Button(body, SWT.CHECK);
			Color color = Display.getDefault().getSystemColor(SWT.COLOR_LIST_FOREGROUND);//COLOR_LIST_BACKGROUND
			checkbox.setForeground(color);
			Font font = label.getFont();
//			font.
			checkbox.setFont(font);
//			checkbox.setFont(label.getFont()); // FIXME
			checkbox.setText(xmls[i]);
			checkbox.setBackground(white);
			checkboxs.add(checkbox);
			if (xmls[i].endsWith(XML) == false) {
				checkbox.setSelection(false);
			} else {
				checkbox.setSelection(true);
			}
			checkbox.addSelectionListener(new UpdateButtonListener(checkboxs, this));
		}

		Button refreshButton = new Button(body, SWT.NULL);
		refreshButton.setText(Messages.getString("MaihimeView.refresh")); //$NON-NLS-1$
		refreshButton.addSelectionListener(new RefreshButtonListener(this));

		this.parent.layout(true);
		this.parent.redraw();
	}

	public String getTitleToolTip() {
		return Messages.getString("MaihimeView.title"); //$NON-NLS-1$
	}
}
