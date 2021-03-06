package pers.fpj.answer.a2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面类
 *
 * 引用: http://blog.didispace.com/springbootaoplog/
 *
 * created by fpj on 2017/11/19 22:11.
 */
@Component
@Aspect
public class WebLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    //切入pers.fpj.answer.a2.domain包下的所有函数
    @Pointcut("execution(public * pers.fpj.answer.a2.domain.*.controller.*.*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)throws Exception {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        LOGGER.info("URL : " + request.getRequestURL().toString());
        LOGGER.info("HTTP_METHOD : " + request.getMethod());
        LOGGER.info("IP : " + request.getRemoteAddr());
        LOGGER.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        LOGGER.info("RESPONSE : " + ret);
    }
}
