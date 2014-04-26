package com.tuniu.designer.gui.property;

import org.activiti.designer.property.ActivitiPropertyFilter;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import com.tuniu.nfbird.bpm.model.AssertReceiveTask;

public class PropertyTuniuReceiveTaskFilter extends ActivitiPropertyFilter {

	@Override
	protected boolean accept(PictogramElement pe) {
		Object bo = getBusinessObject(pe);
		if (bo instanceof AssertReceiveTask ) {
			return true;
		}
		return false;
	}

}
