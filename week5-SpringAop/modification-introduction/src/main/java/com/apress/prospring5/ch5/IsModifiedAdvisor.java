package com.apress.prospring5.ch5;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

//Create an Advisor to wrap the creation of the mixin class.
//This step is optional, but it does help ensure that a new instance 
//of the mixin is being used for each advised object.
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
