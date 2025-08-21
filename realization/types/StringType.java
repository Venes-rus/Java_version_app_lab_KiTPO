package realization.types;

public class StringType {
    private String value;

    public StringType(String value) {
        this.value = value;
    }

    public String getStringValue() {
        return this.value;
    }

    public void setStringValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

