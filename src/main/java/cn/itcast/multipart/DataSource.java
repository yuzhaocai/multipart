package cn.itcast.multipart;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @author Administrator
 * 	RetentionPolicy
 * 		*SOURCE表示这个Annotation类型的信息只会保留在源码里，源码经过编译之后，Annotation的数据就会消失，并不会保留在编译好的.class文件里；
 *			*CLASS表示这个Annotation类型的信息在源码保留，在.class文件也保留，但不会把这些信息加载到虚拟机（JVM）中，如果不设置，系统默认值是CLASS；
 *			*RUNTIME表示在源码，编译后的.class都保存信息，在执行的时候也会把这些信息加载到JVM中
 *	注解的保留策略：
 *		*SOURCE:源码中
 *		*CLASS:保留在源码和.class文件中
 *      *RUNTIME:在JVM中也保留
 *  注解的Target:
 *  	Type:class和interface、enmu中
 *  	method:方法上
 *  	field:字段中
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
	String value();
	
	boolean read() default false;
}
