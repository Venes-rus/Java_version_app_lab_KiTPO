package test;

import realization.list.MyListOfArrays;
import realization.list.SerializeList;
import realization.types.factory.FactoryUserType;
import realization.types.userTypes.*;

import java.io.FileNotFoundException;

public class TestListOfArrays {
    private FactoryUserType factoryUserType;
    private UserType userType;
    private MyListOfArrays list;

    private final String INTEGER_FILENAME = "testInteger.dat";
    private final String POINT2D_FILENAME = "testPoint2D.dat";
    private final String DOUBLE_FILENAME = "testDouble.dat";
    private final String STRING_FILENAME = "testString.dat";

    private void startTest() {
        System.out.println("### FILL LIST (ADD METHOD)");
        for (int i = 0; i < 120; i++) {
            list.add(userType.create());
        }
        System.out.println("### PRINT LIST");
        list.show();
        System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());

        System.out.println("\n### INSERT ELEMENT");
        System.out.println("ELEMENT ON 77 INDEX BEFORE INSERT: " + list.get(77));
        list.insert(userType.create(), 77);
        System.out.println("ELEMENT ON 77 INDEX AFTER INSERT: " + list.get(77));

        System.out.println("\n### INSERT 20 ELEMENTS ON INDEX 100");
        for (int i = 0; i < 20; i++) {
            list.insert(userType.create(), 100);
        }
        System.out.println("### PRINT LIST");
        list.show();
        System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());

        System.out.println("\n### REMOVE ELEMENT ON INDEX");
        System.out.println("ELEMENT ON 77 INDEX BEFORE REMOVE: " + list.get(77));
        list.remove(77);
        System.out.println("ELEMENT ON 77 INDEX AFTER REMOVE: " + list.get(77));

        System.out.println("\n### REMOVE 20 ELEMENTS ON INDEX 50");
        for (int i = 0; i < 20; i++) {
            list.remove(50);
        }
        System.out.println("### PRINT LIST");
        list.show();
        System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());

        if (userType instanceof IntegerUserType) {
            System.out.println("### SAVE TO FILE " + INTEGER_FILENAME);
            SerializeList.saveToFile(list, INTEGER_FILENAME, userType);
        } else if (userType instanceof Point2DUserType) {
            System.out.println("### SAVE TO FILE " + POINT2D_FILENAME);
            SerializeList.saveToFile(list, POINT2D_FILENAME, userType);
        } else if (userType instanceof DoubleUserType) {
            System.out.println("### SAVE TO FILE " + DOUBLE_FILENAME);
            SerializeList.saveToFile(list, DOUBLE_FILENAME, userType);
        } else if (userType instanceof StringUserType) {
            System.out.println("### SAVE TO FILE " + STRING_FILENAME);
            SerializeList.saveToFile(list, STRING_FILENAME, userType);
        }

        System.out.println("\n### SORT LIST");
        list = list.sort(userType.getTypeComparator());
        System.out.println("### PRINT LIST");
        list.show();
        System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());

        if (userType instanceof IntegerUserType) {
            try {
                System.out.println("\n~~ LOAD LIST FROM FILE " + INTEGER_FILENAME + " ~~");
                list.clear();
                list = SerializeList.loadFromFile(INTEGER_FILENAME, userType);
                System.out.println("### PRINT LIST");
                list.show();
                System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());
            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка. Файл не найден!");
            } catch (Exception ex) {
                System.out.println("Ошибка. Структура файла неверна или повреждена!");
            }
        } else if (userType instanceof Point2DUserType) {
            try {
                System.out.println("\n~~ LOAD LIST FROM FILE " + POINT2D_FILENAME + " ~~");
                list.clear();
                list = SerializeList.loadFromFile(POINT2D_FILENAME, userType);
                System.out.println("### PRINT LIST");
                list.show();
                System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());
            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка. Файл не найден!");
            } catch (Exception ex) {
                System.out.println("Ошибка. Структура файла неверна или повреждена!");
            }
        } else if (userType instanceof DoubleUserType) {
            try {
                System.out.println("\n~~ LOAD LIST FROM FILE " + DOUBLE_FILENAME + " ~~");
                list.clear();
                list = SerializeList.loadFromFile(DOUBLE_FILENAME, userType);
                System.out.println("### PRINT LIST");
                list.show();
                System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());
            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка. Файл не найден!");
            } catch (Exception ex) {
                System.out.println("Ошибка. Структура файла неверна или повреждена!");
            }
        } else if (userType instanceof StringUserType) {
            try {
                System.out.println("\n~~ LOAD LIST FROM FILE " + STRING_FILENAME + " ~~");
                list.clear();
                list = SerializeList.loadFromFile(STRING_FILENAME, userType);
                System.out.println("### PRINT LIST");
                list.show();
                System.out.println("TOTAL ELEMENTS = " + list.getTotalElements());
            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка. Файл не найден!");
            } catch (Exception ex) {
                System.out.println("Ошибка. Структура файла неверна или повреждена!");
            }
        }
    }

    public int testingInteger() {
        System.out.println("#### TEST USER TYPE INTEGER\n");
        factoryUserType = new FactoryUserType();
        userType = factoryUserType.getBuilderByTypeName("Integer");
        list = new MyListOfArrays(100);
        startTest();

        return 1;
    }

    public int testingPoint2D() {
        System.out.println("#### TEST USER TYPE POINT2D\n");
        factoryUserType = new FactoryUserType();
        userType = factoryUserType.getBuilderByTypeName("Point2D");
        list = new MyListOfArrays(100);
        startTest();

        return 1;
    }

    public int testingDouble() {
        System.out.println("#### TEST USER TYPE DOUBLE\n");
        factoryUserType = new FactoryUserType();
        userType = factoryUserType.getBuilderByTypeName("Double");
        list = new MyListOfArrays(100);
        startTest();

        return 1;
    }

    public int testingString() {
        System.out.println("#### TEST USER TYPE STRING\n");
        factoryUserType = new FactoryUserType();
        userType = factoryUserType.getBuilderByTypeName("String");
        list = new MyListOfArrays(100);
        startTest();

        return 1;
    }

    public static void main(String[] args) {
        TestListOfArrays test = new TestListOfArrays();
        test.testingInteger();
        test.testingPoint2D();
        test.testingDouble();
        test.testingString();
    }
}

