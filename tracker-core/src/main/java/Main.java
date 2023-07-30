import Service.ServiceSendingMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);//создает контекст

    }
}
