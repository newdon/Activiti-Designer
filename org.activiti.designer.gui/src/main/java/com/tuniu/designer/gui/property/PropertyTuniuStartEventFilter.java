package com.tuniu.designer.gui.property;

import org.activiti.bpmn.model.TimerEventDefinition;
import org.activiti.designer.property.ActivitiPropertyFilter;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.tuniu.nfbird.bpm.model.CrontabStartEvent;

public class PropertyTuniuStartEventFilter extends ActivitiPropertyFilter {
	
	@Override
	protected boolean accept(PictogramElement pe) {
		Object bo = getBusinessObject(pe);
		if (bo instanceof CrontabStartEvent) {
			if (((CrontabStartEvent) bo).getEventDefinitions().size() > 0) {
				if(((CrontabStartEvent) bo).getEventDefinitions().get(0) instanceof TimerEventDefinition) {
					return true;
				}
			}
		}
		return false;
	}

}
