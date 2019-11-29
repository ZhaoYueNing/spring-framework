package cn.zynworld.springexample.aoptest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author zhaoyuening
 */
@Target(ElementType.METHOD)
public @interface AopMethodTimeAnnotation {
}
