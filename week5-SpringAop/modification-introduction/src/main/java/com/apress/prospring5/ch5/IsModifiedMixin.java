package com.apress.prospring5.ch5;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor 
        implements IsModified {
    private boolean isModified = false;

    private Map<Method, Method> methodCache = new HashMap<Method, Method>();

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
    	//We start by performing the check only if the object is still unmodified; 
    	//we do not need to check for modifications once we know that the object 
    	//has been modified
        if (!isModified) {
        	//Next, we check to see whether the method is a setter 
            if ((invocation.getMethod().getName().startsWith("set"))
                && (invocation.getArguments().length == 1)) {
                //and if it is, we retrieve the corresponding getter method
                Method getter = getGetter(invocation.getMethod());

                if (getter != null) {
                	//we compare the value returned by the getter with that passed 
                	//to the setter to determine whether a modification has occurred
                    Object newVal = invocation.getArguments()[0];
                    Object oldVal = getter.invoke(invocation.getThis(), null);

                    //Notice that we check for the different possible combinations 
                    //of null and set the modifications appropriately.
                    if((newVal == null) && (oldVal == null)) {
                        isModified = false;
                    } else if((newVal == null) && (oldVal != null)) {
                        isModified = true;
                    } else if((newVal != null) && (oldVal == null)) {
                        isModified = true;
                    } else {
                        isModified = (!newVal.equals(oldVal));
                    }
                }
            }
        }
        //When when you are using DelegatingIntroductionInterceptor, you must call super.invoke()
        //when overriding invoke() because it is the DelegatingIntroductionInterceptor that 
        //dispatches the invocation to the correct location, either the advised object or the mixin itself. 
        return super.invoke(invocation);
    }

    private Method getGetter(Method setter) {
        Method getter = null;

        getter = (Method) methodCache.get(setter);

        if (getter != null) {
            return getter;
        }

        String getterName = setter.getName().replaceFirst("set", "get");

        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);

            synchronized (methodCache) {
                methodCache.put(setter, getter);
            }

            return getter;
        } catch (NoSuchMethodException ex) {
            return null;
        }
    }
}
