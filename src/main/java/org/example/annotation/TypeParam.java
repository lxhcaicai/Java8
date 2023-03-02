package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * ● JDK8 为 @Target 元注解新增了两种类型：TYPE_PARAMETER 和 TYPE_USE。
 * ● TYPE_PARAMETER：表示该注解能写在类型参数的声明语句中。
 * ● TYPE_USE：表示注解可以在任何用到类型的地方使用。
 */
@Target(ElementType.TYPE_PARAMETER)
public @interface TypeParam {
}
