package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component //@Bean은 클래스에 못 붙여! class는 Component Configuration엔 여러가지 Baen이 들어가
public class TimerAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //proceed가 호출되면 실질적인 method가 실행, 만약 그 메소드가 return이 있다면 result로 받아줌
        //메소드 실행 전
        Object result = joinPoint.proceed();
        //메소드 실행 후
        stopWatch.stop();

        System.out.println("total timee :" + stopWatch.getTotalTimeSeconds());
    }
}
