package kr.re.kitri.hellospring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger log = 
			LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* kr.re.kitri.hellospring.service.*.*(..))")
	public void logBeforeServiceMethods(JoinPoint joinPoint) {
		String mName = joinPoint.getSignature().getName();
		log.info(mName + " 함수에서 로그를 출력 from 로깅 애스팩트");
	}
}
