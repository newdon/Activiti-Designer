package org.activiti.designer.command;

import org.eclipse.graphiti.features.IFeatureProvider;

import com.tuniu.nfbird.bpm.model.AssertReceiveTask;

public class TuniuReceiveTaskModelUpdater extends BpmnProcessModelUpdater {

  public TuniuReceiveTaskModelUpdater(IFeatureProvider featureProvider) {
    super(featureProvider);
  }
  
  @Override
  public boolean canControlShapeFor(Object businessObject) {
    if (businessObject instanceof AssertReceiveTask) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected AssertReceiveTask cloneBusinessObject(Object businessObject) {
    return ((AssertReceiveTask) businessObject).clone();
  }

  @Override
  protected void performUpdates(Object valueObject, Object targetObject) {
    ((AssertReceiveTask) targetObject).setValues(((AssertReceiveTask) valueObject));
  }
  
  @Override
  public BpmnProcessModelUpdater createUpdater(IFeatureProvider featureProvider) {
    return new TuniuReceiveTaskModelUpdater(featureProvider);
  }
}
