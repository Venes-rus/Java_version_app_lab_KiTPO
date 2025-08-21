package realization.types.factory;

import realization.types.userTypes.*;
import realization.types.userTypes.DoubleUserType;
import realization.types.userTypes.StringUserType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FactoryUserType {

    private final static ArrayList<UserType> listOfAvailableTypes = new ArrayList<>();

    static {
        ArrayList<UserType> types = new ArrayList<>(Arrays.asList(
                new IntegerUserType(),
                new Point2DUserType(),
                new DoubleUserType(),
                new StringUserType()
        ));
        listOfAvailableTypes.addAll(types);
    }

    public UserType getBuilderByTypeName(String typename) {
        for (UserType userType : listOfAvailableTypes) {
            if (typename.equals(userType.typeName())) {
                return userType;
            }
        }

        throw new RuntimeException("Ошибка. Тип данных не найден!");
    }

    public Set<String> getTypeNameList() {
        return listOfAvailableTypes.stream().map(UserType::typeName).collect(Collectors.toSet());
    }
}
