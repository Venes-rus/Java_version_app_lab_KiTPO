package realization.types.comporators;

import realization.types.Point2DType;

import java.io.Serializable;

public class Point2DComporator implements Comporator, Serializable {
    @Override
    public float compare(Object object1, Object object2) {
        Point2DType point1 = (Point2DType) object1;
        Point2DType point2 = (Point2DType) object2;

        // Сортировка по координате X
        return (float) (point1.getX() - point2.getX());
    }
}
