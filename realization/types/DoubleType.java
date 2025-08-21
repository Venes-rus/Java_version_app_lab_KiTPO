package realization.types;

public class DoubleType {
    private double value;

    public DoubleType(double value) {
        this.value = value;
    }

    public double getDoubleValue() {
        return this.value;
    }

    public void setDoubleValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
