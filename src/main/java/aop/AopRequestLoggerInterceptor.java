package aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@AopRequestLogger
public class AopRequestLoggerInterceptor implements Serializable {

    @AroundInvoke
    public Object logRequest(final InvocationContext invocationContext) throws Exception {
        String methodName = invocationContext.getMethod().getName();
        Object result = null;
        try {
            System.out.println("-----------------------------------------------------");
            System.out.println("Request of method: " + methodName);
            result = invocationContext.proceed();
            System.out.println("Successfully executed!");
            System.out.println("-----------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Request of method: " + methodName);
            System.out.println("Interceptor error");
        }

        return result;
    }
}
