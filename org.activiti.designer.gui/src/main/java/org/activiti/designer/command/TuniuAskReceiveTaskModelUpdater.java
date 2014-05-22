package org.activiti.designer.command;

import org.eclipse.graphiti.features.IFeatureProvider;

import com.tuniu.nfbird.bpm.model.AskReceiveTask;

public class TuniuAskReceiveTaskModelUpdater extends BpmnProcessModelUpdater {

  public TuniuAskReceiveTaskModelUpdater(IFeatureProvider featureProvider) {
    super(featureProvider);
  }
  
  @Override
  public boolean canControlShapeFor(Object businessObject) {
    if (businessObject instanceof AskReceiveTask) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected AskReceiveTask cloneBusinessObject(Object businessObject) {
    return ((AskReceiveTask) businessObject).clone();
  }

  @Override
  protected void performUpdates(Object valueObject, Object targetObject) {
    ((AskReceiveTask) targetObject).setValues(((AskReceiveTask) valueObject));
  }
  
  @Override
  public BpmnProcessModelUpdater createUpdater(IFeatureProvider featureProvider) {
    return new TuniuAskReceiveTaskModelUpdater(featureProvider);
  }
}
