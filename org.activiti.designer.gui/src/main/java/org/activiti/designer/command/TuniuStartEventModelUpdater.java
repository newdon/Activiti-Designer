package org.activiti.designer.command;

import org.eclipse.graphiti.features.IFeatureProvider;

import com.tuniu.nfbird.bpm.model.CrontabStartEvent;

public class TuniuStartEventModelUpdater extends BpmnProcessModelUpdater {

  public TuniuStartEventModelUpdater(IFeatureProvider featureProvider) {
    super(featureProvider);
  }
  
  @Override
  public boolean canControlShapeFor(Object businessObject) {
    if (businessObject instanceof CrontabStartEvent) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected CrontabStartEvent cloneBusinessObject(Object businessObject) {
    return ((CrontabStartEvent) businessObject).clone();
  }

  @Override
  protected void performUpdates(Object valueObject, Object targetObject) {
    ((CrontabStartEvent) targetObject).setValues(((CrontabStartEvent) valueObject));
  }
  
  @Override
  public BpmnProcessModelUpdater createUpdater(IFeatureProvider featureProvider) {
    return new TuniuStartEventModelUpdater(featureProvider);
  }
}
