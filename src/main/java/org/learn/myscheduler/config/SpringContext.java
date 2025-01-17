package org.learn.myscheduler.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * Returns the Spring managed bean instance of the given class type if it exists.
     * Returns null otherwise.
     *
     * @param beanClass Spring bean classes.
     * @return <T extends Object>
     */
    public static <T> T getBean(Class<T> beanClass) {

        return context.getBean(beanClass);
    }

    /**
     * Returns the Spring managed bean instance of the given class type if it exists.
     * Returns null otherwise.
     *
     * @param beanName Spring bean class that contains the bean name.
     * @return <T extends Object>
     */
    public static <T> T getBean(String beanName) {

        return (T) context.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {

        // store ApplicationContext reference to access required beans later on
        SpringContext.context = context;
    }
}