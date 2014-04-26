package com.tuniu.designer.gui.property;

import org.activiti.bpmn.model.ImplementationType;
import org.activiti.bpmn.model.ServiceTask;
import org.activiti.designer.property.ActivitiPropertySection;
import org.activiti.designer.property.ui.FieldExtensionEditor;
import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.tuniu.nfbird.bpm.model.AssertReceiveTask;
import com.tuniu.nfbird.bpm.model.WorkformTask;

public class PropertyTuniuReceiveTaskSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	private Text startText;
	private Text endText;

	@Override
  public void createFormControls(TabbedPropertySheetPage aTabbedPropertySheetPage) {
		startText = createTextControl(false);
		createLabel("start event", startText);
		
		endText = createTextControl(false);
		createLabel("end event", endText);
  }

  @Override
  protected Object getModelValueForControl(Control control, Object businessObject) {
	  AssertReceiveTask receiveTask = (AssertReceiveTask) businessObject;

		if (control == startText) {

			return receiveTask.getAssertEvents().get(0).getExpression();

		}else if (control == endText) {

			return receiveTask.getAssertEvents().get(1).getExpression();

		}
    return null;
  }

  @Override
  protected void storeValueInModel(Control control, Object businessObject) {
	  AssertReceiveTask receiveTask = (AssertReceiveTask) businessObject;
		if (control == startText) {
			receiveTask.getAssertEvents().get(0).setExpression(startText.getText());
		}else if (control == endText) {
			receiveTask.getAssertEvents().get(1).setExpression(endText.getText());
		}
  }


}