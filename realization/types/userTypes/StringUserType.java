package realization.types.userTypes;

import realization.types.StringType;
import realization.types.comporators.Comporator;
import realization.types.comporators.StringComporator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class StringUserType implements UserType {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";
    private static final String PASSWORD_ALLOW_CHARS = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static final Random RAND = new Random();

    @Override
    public String typeName() {
        return "String";
    }

    @Override
    public Object create() {
        return new StringType(generateRandomString(10)); // Генерация рандомной строки длиной 10 символов
    }

    @Override
    public Object clone(Object object) {
        return new StringType(((StringType) object).getStringValue());
    }

    @Override
    public Object readValue(InputStreamReader in) throws IOException {
        return in.read();
    }

    @Override
    public Object parseValue(String ss) {
        return new StringType(ss);
    }

    @Override
    public Comporator getTypeComparator() {
        return new StringComporator();
    }

    @Override
    public String toString(Object object) {
        return object.toString();
    }

    private String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        // Генерация первой заглавной буквы
        sb.append(CHAR_UPPER.charAt(RAND.nextInt(CHAR_UPPER.length())));
        // Генерация остальных строчных символов
        for (int i = 1; i < length; i++) {
            int rndCharAt = RAND.nextInt(PASSWORD_ALLOW_CHARS.length());
            char rndChar = PASSWORD_ALLOW_CHARS.charAt(rndCharAt);
            sb.append(Character.toLowerCase(rndChar));
        }

        return sb.toString();
    }
}
