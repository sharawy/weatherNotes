package com.weatherNotes.utils;

import com.weatherNotes.common.Defines;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    final static String lOGGING_COVERAGE = "within("+Defines.Packages.BASE_PACKAGE+".*..*)";
    private static final Logger logger = LogUtil.getInstance();
 
   
  @Around(lOGGING_COVERAGE)
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String dbugLogMsg = "";
        Object proceed = null;
      
        long startTime = 0;
        try {

   logger.info(joinPoint.getSignature() +": is called");
                dbugLogMsg =  " starting method: " + joinPoint.getSignature().getName() + " with args: " + Arrays.toString(joinPoint.getArgs())
                        + " in class " + joinPoint.getSignature().getDeclaringTypeName();
            
            logger.debug(dbugLogMsg);
            startTime = System.currentTimeMillis();

        } catch (Throwable e) {
            LogUtil.error("Could not log around for =>", e);
        }
        proceed = joinPoint.proceed(); //continue on the intercepted method
        try {
            long executionTime = System.currentTimeMillis() - startTime;
            logger.info("" + joinPoint.getSignature().getDeclaringType().getSimpleName()
                    + "." + joinPoint.getSignature().getName()
                    + " with args: " + Arrays.toString(joinPoint.getArgs())
                    + " ended in " + executionTime + " ms"
            );
        } catch (Throwable e) {
            LogUtil.error("Could not log around for =>", e);
        }

        return proceed;

    }


}