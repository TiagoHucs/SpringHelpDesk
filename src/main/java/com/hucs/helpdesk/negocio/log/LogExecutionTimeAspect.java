package com.hucs.helpdesk.negocio.log;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.lang.String.format;

@Aspect
@Component
public class LogExecutionTimeAspect {

    private static String SIGLA = "HELPDESK";
    private static String TEMPO = "Tempo";

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogExecutionTime myAnnotation = method.getAnnotation(LogExecutionTime.class);
        String descricao = myAnnotation.value();

        Object proceed = joinPoint.proceed();

        long execTime = System.currentTimeMillis() - start;

        LocalDateTime agora = LocalDateTime.now();
        BigDecimal valor = BigDecimal.valueOf(10.25);

        //SIGLA DATAHORA DESCRICAO TIPO VALOR TEMPO
         System.out.println( format("%s , \"%s\" , %s , %s , %s ", SIGLA, agora , descricao , TEMPO , valor, execTime));
        return proceed;
    }


}
