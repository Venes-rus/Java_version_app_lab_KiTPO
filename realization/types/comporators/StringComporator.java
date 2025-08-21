package realization.types.comporators;

import realization.types.StringType;

import java.io.Serializable;

public class StringComporator implements Comporator, Serializable {
    @Override
    public float compare(Object object1, Object object2) {
        return ((StringType) object1).getStringValue().compareTo(((StringType) object2).getStringValue());
    }
}
