package com.tuniu.designer.gui.property;

import org.activiti.designer.property.ActivitiPropertySection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.tuniu.nfbird.bpm.model.AskReceiveTask;


public class PropertyTuniuAskReceiveTaskSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	private Text askText;

	@Override
  public void createFormControls(TabbedPropertySheetPage aTabbedPropertySheetPage) {
		askText = createTextControl(false);
		createLabel("Ask Expression ", askText);
		
  }

  @Override
  protected Object getModelValueForControl(Control control, Object businessObject) {
	  AskReceiveTask receiveTask = (AskReceiveTask) businessObject;

		if (control == askText) {

			return receiveTask.getAskExpression();

		}
    return null;
  }

  @Override
  protected void storeValueInModel(Control control, Object businessObject) {
	  AskReceiveTask receiveTask = (AskReceiveTask) businessObject;
		if (control == askText) {
			receiveTask.setAskExpression(askText.getText());
		}
  }


}