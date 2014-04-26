package com.tuniu.designer.gui.features;

import org.activiti.designer.PluginImage;
import org.activiti.designer.features.AbstractCreateFastBPMNFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import com.tuniu.nfbird.bpm.model.AssertReceiveTask;
import com.tuniu.nfbird.bpm.model.AssertReceiveTask.AssertEvent;

public class CreateTuniuReceiveTaskFeature extends AbstractCreateFastBPMNFeature {

  public static final String FEATURE_ID_KEY = "assertreceivetask";

  public CreateTuniuReceiveTaskFeature(IFeatureProvider fp) {
    super(fp, "AssertReceiveTask", "Add assert receive task");
  }

  @Override
  public Object[] create(ICreateContext context) {
    AssertReceiveTask newReceiveTask = new AssertReceiveTask();
    AssertEvent startEvent = new AssertEvent();
    startEvent.setEvent("start");
    startEvent.setExpression("");
    AssertEvent endEvent = new AssertEvent();
    endEvent.setEvent("end");
    endEvent.setExpression("");
    newReceiveTask.addAssertEvent(startEvent);
    newReceiveTask.addAssertEvent(endEvent);
    newReceiveTask.setAsynchronous(true);
    addObjectToContainer(context, newReceiveTask, "Receive Task");

    return new Object[] { newReceiveTask };
  }

  @Override
  public String getCreateImageId() {
    return PluginImage.IMG_RECEIVETASK.getImageKey();
  }

  @Override
  protected String getFeatureIdKey() {
    return FEATURE_ID_KEY;
  }
}
