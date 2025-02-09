package com.study.netflix;

import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BeanChecker {
    private final ApplicationContext context;

    public BeanChecker(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void checkBeans() {
        System.out.println("등록된 빈 목록:");
        Arrays.stream(context.getBeanDefinitionNames())
                .filter(name -> name.contains("sample"))  // sample 관련 빈만 출력
                .forEach(System.out::println);
    }
}
