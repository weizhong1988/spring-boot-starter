package com.weiz.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

@Min(value = 18,message = "年龄最小不能小于18")
@Max(value = 120,message = "年龄最大不能超过120")
@Constraint(validatedBy = {}) //不指定效验器
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAgeValidator {
    String message() default "年龄大小必须大于18并且小于120";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}