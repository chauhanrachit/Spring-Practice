package com.practice.learnspringaop.aopexample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//We want to use this annotation only on methods
@Target(ElementType.METHOD)
//We want to be able to use this annotation at RunTime
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {

}
