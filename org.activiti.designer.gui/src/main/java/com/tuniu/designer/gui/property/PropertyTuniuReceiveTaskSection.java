package com.tuniu.designer.gui.property;


import org.activiti.designer.property.ActivitiPropertySection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.tuniu.nfbird.bpm.model.AssertReceiveTask;


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