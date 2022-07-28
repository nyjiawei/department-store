package com.store.template.config.security;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 17:19
 * @Description：如果多个请求参数都校验失败，则遇到第一个校验失败就抛出异常，接下来的异常参数不做校验
 * @Version：1.0
 **/
//@Configuration
public class WebValidatorConfig {
    /**
     * 自定义spring-boot的 Validator
     * @return Validator
     */
    //@Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true) //failFast的意思只要出现校验失败的情况，就立即结束校验，不再进行后续的校验。
                .buildValidatorFactory();

        return validatorFactory.getValidator();
    }

    /**
     * set 进 methodValidationPostProcessor
     * @return methodValidationPostProcessor
     */
    //@Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setValidator(validator());
        return methodValidationPostProcessor;
    }

}
