package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvice.class);
	
	// pointCut 설정을 위한 의미없는 메서드
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
		
	}
	
	// JoinPoint 핵심기능을 담고있는 로직
	@Before("dummy()")
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("beforeMethod : {}", joinPoint.getSignature().getName());
	}

	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 메소드 실행 전 공통 관심사항
		long start = System.currentTimeMillis();
		// 메서드 실행
		Object obj = joinPoint.proceed(joinPoint.getArgs());
		// 메서드 실행 후 관심사항
		long end = System.currentTimeMillis();
		logger.debug("profiling : {} {} - {}", 
						joinPoint.getSignature().getDeclaringTypeName(),
						joinPoint.getSignature().getName(), end-start+"ms");
		
		return obj;
	}
	
}
