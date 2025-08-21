import programUI.GUI;
import realization.list.MyListOfArrays;
import realization.types.factory.FactoryUserType;
import realization.types.userTypes.UserType;
import test.TestListOfArrays;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TestListOfArrays test = new TestListOfArrays();
        test.testingInteger();
        System.out.println("\n\n=============================================================\n\n");
        test.testingPoint2D();
        System.out.println("\n\n=============================================================\n\n");
        test.testingDouble();
        System.out.println("\n\n=============================================================\n\n");
        test.testingString();

        GUI mainFrame = new GUI();
        mainFrame.showWindow();
    }
}
