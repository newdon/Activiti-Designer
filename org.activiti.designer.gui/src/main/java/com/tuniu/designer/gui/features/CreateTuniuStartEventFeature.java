package com.tuniu.designer.gui.features;


import org.activiti.bpmn.model.EventSubProcess;
import org.activiti.bpmn.model.TimerEventDefinition;
import org.activiti.designer.PluginImage;
import org.activiti.designer.features.AbstractCreateBPMNFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import com.tuniu.nfbird.bpm.model.CrontabStartEvent;

public class CreateTuniuStartEventFeature extends AbstractCreateBPMNFeature {

  public static final String FEATURE_ID_KEY = "crontabStartEvent";

  public CreateTuniuStartEventFeature(IFeatureProvider fp) {
    // set name and description of the creation feature
    super(fp, "CrontabStartEvent", "Add Crontab start event");
  }

  public boolean canCreate(ICreateContext context) {
	  Object parentObject = getBusinessObjectForPictogramElement(context.getTargetContainer());
	    if (parentObject instanceof EventSubProcess)
	      return false;
	    return super.canCreate(context);
  }

  public Object[] create(ICreateContext context) {
	  	CrontabStartEvent startEvent = new CrontabStartEvent();
	  	startEvent.setId(getNextId(startEvent));
	  	startEvent.setAlone(true);
	    TimerEventDefinition timerEvent = new TimerEventDefinition();
	    startEvent.getEventDefinitions().add(timerEvent);
	    
	    //addGraphicalRepresentation(context, startEvent);
	    addObjectToContainer(context, startEvent, "Timer start");

	    // return newly created business object(s)
	    return new Object[] { startEvent };
  }

  @Override
  public String getCreateImageId() {
    return PluginImage.IMG_EVENT_TIMER.getImageKey();
  }

  @Override
  protected String getFeatureIdKey() {
    return FEATURE_ID_KEY;
  }
}
