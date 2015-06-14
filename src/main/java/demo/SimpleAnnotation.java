package demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//将这一Annotation的信息显示在JAVA API文档上
@Documented

@Retention(RetentionPolicy.RUNTIME)
//指定Annotation类型可以用在哪些元素上的
@Target(ElementType.TYPE)
public @interface SimpleAnnotation {
	
	String value();
}
