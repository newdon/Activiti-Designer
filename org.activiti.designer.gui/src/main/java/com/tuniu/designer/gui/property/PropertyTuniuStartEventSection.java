package com.tuniu.designer.gui.property;

import org.activiti.bpmn.model.TimerEventDefinition;
import org.activiti.designer.property.ActivitiPropertySection;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.tuniu.nfbird.bpm.model.CrontabStartEvent;

public class PropertyTuniuStartEventSection extends ActivitiPropertySection implements ITabbedPropertyConstants {
	
	private Text timeDurationText;
	private Text timeDateText;
	private Text timeCycleText;
	private Button aloneButton;
	
	@Override
  public void createFormControls(TabbedPropertySheetPage aTabbedPropertySheetPage) {
    timeDurationText = createTextControl(false);
    createLabel("Time duration", timeDurationText);
    timeDateText = createTextControl(false);
    createLabel("Time date (ISO 8601)", timeDateText);
    timeCycleText = createTextControl(false);
    createLabel("Time cycle", timeCycleText);
    aloneButton = createCheckboxControl("alone");
  }

  @Override
  protected Object getModelValueForControl(Control control, Object businessObject) {
    CrontabStartEvent event = (CrontabStartEvent) businessObject;
    TimerEventDefinition timerDefinition = (TimerEventDefinition) event.getEventDefinitions().get(0);
    
    if (control == timeDurationText) {
      return timerDefinition.getTimeDuration();
      
    } else if (control == timeDateText) {
      return timerDefinition.getTimeDate();
      
    } else if (control == timeCycleText) {
      return timerDefinition.getTimeCycle();
    } else if (control == aloneButton) {
        return event.isAlone();
      }
//    if (control == aloneButton) {
//      return event.isAlone();
//    }
    return null;
  }

  @Override
  protected void storeValueInModel(Control control, Object businessObject) {
	  CrontabStartEvent event = (CrontabStartEvent) businessObject;
    TimerEventDefinition timerDefinition = (TimerEventDefinition) event.getEventDefinitions().get(0);
    
    if (control == timeDurationText) {
      timerDefinition.setTimeDuration(timeDurationText.getText());
    
    } else if (control == timeDateText) {
      timerDefinition.setTimeDate(timeDateText.getText());
    
    } else if (control == timeCycleText) {
      timerDefinition.setTimeCycle(timeCycleText.getText());
    } else if (control == aloneButton) {
      event.setAlone(aloneButton.getSelection());
    }
//	  if (control == aloneButton) {
//	    	event.setAlone(aloneButton.getSelection());
//	      }
  }
}
