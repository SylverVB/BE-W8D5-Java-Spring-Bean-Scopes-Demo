package com.app;

// import com.app.Application;
import com.app.Beans.ScopedBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopedBeanTest {
    /**
     * Requesting the "labBean" multiple times should result in multiple instances. This is the expected behavior
     * of one of the bean scopes. This test will pass when the bean is set to the proper scope.
     */
    @Test
    public void scopedBeanTest(){
        // Create the application context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        // Retrieve beans
        ScopedBean b1 = (ScopedBean) applicationContext.getBean("labBean");
        ScopedBean b2 = (ScopedBean) applicationContext.getBean("labBean");
        // Perform assertions
        Assertions.assertTrue(b1!=b2);
        // Close the application context to release resources
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}