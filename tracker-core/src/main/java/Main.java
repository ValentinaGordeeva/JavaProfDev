import Service.InjectionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);//создает контекст

    }
}
