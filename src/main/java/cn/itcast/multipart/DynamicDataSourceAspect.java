package cn.itcast.multipart;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Administrator
 * AOP开发的方式选择：
 * 		1.单纯使用Aspectj进行aop开发
 * 			*功能强大，但需要专门的编译器和aspectj语法
 *     	2.spring联合Aspectj进行aop开发
 *     		*实现起来很简单
 * AOP方式切换数据源的时候需要注意的问题
 * 		*需要在切换数据源和@Transaction都是基于aop来实现，这就关系到谁先执行的问题了，如果@Transaction先执行，则就会先获取数据源，因为开启事务就需要数据源，
 * 		 当我们切换数据库的aop执行的时候，数据源已经选定了，导致我们不能切换数据源了，解决办法是控制切换数据源和@Transaction aop的执行顺序问题，采用Ordered注解。
 *  
 */
@Aspect
@Component
public class DynamicDataSourceAspect implements Ordered {
	
	private Random random = new Random();
	
	@Autowired
	private MasterSlaveDataSourceMapping mappings;
	
	@Pointcut(value="execution(* cn.itcast.service..*.*(..))")
	public void pointcut(){
		
	}
	
	@Before(value="pointcut()")
	public void beforeSetDataSourceKey(JoinPoint joinPoint){
		Object target = joinPoint.getTarget();
        String methodName = joinPoint.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        if(classz == null || classz.length ==0){
        	classz = new Class<?>[]{target.getClass()};
        }
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        try {
            Method method = classz[0].getMethod(methodName, parameterTypes);
            if (method != null && method.isAnnotationPresent(DataSource.class)) {
                DataSource dataSource = method .getAnnotation(DataSource.class);
                String dataSourceType = dataSource.value();
                MasterSlaveDataSourceItem masterSlaveDateSourceItem = mappings.getTargetMasterSlaveDataSourceItems().get(dataSourceType);
            	if(dataSource.read()){        
            		//读
            		List<String> slaveDataSources = masterSlaveDateSourceItem.getSlaveDataSources();
            		DataSourceContextHolder.setDataSourceType(slaveDataSources.get(random.nextInt(slaveDataSources.size())));
            	} else {
            		//写
            		String masterDataSource = masterSlaveDateSourceItem.getMasterDataSource();
            		DataSourceContextHolder.setDataSourceType(masterDataSource);
            	}
                System.out.println(dataSource.value());
            }
        } catch (Exception e) {
        }
	}

	public int getOrder() {
		return 1;
	}
}
