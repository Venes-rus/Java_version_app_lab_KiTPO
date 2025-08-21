package realization.types.userTypes;

import realization.types.DoubleType;
import realization.types.comporators.Comporator;
import realization.types.comporators.DoubleComporator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class DoubleUserType implements UserType {
    @Override
    public String typeName() {
        return "Double";
    }

    @Override
    public Object create() {
        Random rand = new Random();
        return new DoubleType(rand.nextDouble() * 1000.0);
    }

    @Override
    public Object clone(Object object) {
        return new DoubleType(((DoubleType) object).getDoubleValue());
    }

    @Override
    public Object readValue(InputStreamReader in) throws IOException {
        return in.read();
    }

    @Override
    public Object parseValue(String ss) {
        return new DoubleType(Double.parseDouble(ss));
    }

    @Override
    public Comporator getTypeComparator() {
        return new DoubleComporator();
    }

    @Override
    public String toString(Object object) {
        return object.toString();
    }
}
