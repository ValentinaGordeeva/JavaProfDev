import Service.ServiceGPS;
import Service.ServiceKeeping;
import Service.ServiceSendingMes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
@Configuration
@EnableScheduling
public class InjectionContext {
    @Bean
    public ServiceGPS  servergps() {
    return new ServiceGPS();
    }
    @Bean
    public ServiceKeeping keeping() {
        return new ServiceKeeping();
    }

    @Bean
    public ServiceSendingMes sendmec() {
        return new ServiceSendingMes();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("расписание работы пула ");
        scheduler.setPoolSize(20);
        return scheduler;
    }
}
