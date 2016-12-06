package FunctionalProg.Triangle;

import java.util.function.ToDoubleFunction;

class TriangleFuncProgram {

    public static ToDoubleFunction<TrianglePojo> f = triangle -> {
        triangle.setArea(0.5 * triangle.base * triangle.height);
        return triangle.getArea();
    };
}