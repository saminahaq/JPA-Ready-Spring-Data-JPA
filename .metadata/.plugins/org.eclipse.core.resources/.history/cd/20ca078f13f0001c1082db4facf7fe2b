package ExampleAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Learning AOP !!!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Learning AOP !!!" );
        
        ApplicationContext context =
        		new AnnotationConfigApplicationContext(BeanConfig.class);
        ShoppingCart cart =context.getBean(ShoppingCart.class);
        cart.checkOut("Approved");
        
        
        
    }
}
