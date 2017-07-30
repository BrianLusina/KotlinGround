package com.javapp.functionalprog.Triangle;

import java.util.function.ToDoubleFunction;

public class TriangleFuncProgram {

  public static ToDoubleFunction<TrianglePojo> f = triangle -> {
    triangle.setArea(0.5 * triangle.base * triangle.height);
    return triangle.getArea();
  };

}