package realization.types.comporators;

import realization.types.DoubleType;

import java.io.Serializable;

public class DoubleComporator implements Comporator, Serializable {
    @Override
    public float compare(Object object1, Object object2) {
        return (float) (((DoubleType) object1).getDoubleValue() - ((DoubleType) object2).getDoubleValue());
    }
}
