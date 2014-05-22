package com.tuniu.designer.gui.features;

import org.activiti.designer.PluginImage;
import org.activiti.designer.features.AbstractCreateFastBPMNFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import com.tuniu.nfbird.bpm.model.AskReceiveTask;


public class CreateTuniuAskReceiveTaskFeature extends AbstractCreateFastBPMNFeature {

  public static final String FEATURE_ID_KEY = "askreceivetask";

  public CreateTuniuAskReceiveTaskFeature(IFeatureProvider fp) {
    super(fp, "AskReceiveTask", "Add ask receive task");
  }

  @Override
  public Object[] create(ICreateContext context) {
    AskReceiveTask newReceiveTask = new AskReceiveTask();

    newReceiveTask.setAsynchronous(true);
    addObjectToContainer(context, newReceiveTask, "askreceivetask");

    return new Object[] { newReceiveTask };
  }

  @Override
  public String getCreateImageId() {
    return PluginImage.IMG_ASK_RECEIVE_TASK.getImageKey();
  }

  @Override
  protected String getFeatureIdKey() {
    return FEATURE_ID_KEY;
  }
}
