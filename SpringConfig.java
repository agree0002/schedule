package project.planner;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.planner.repository.JpaScheduleRepository;
import project.planner.repository.ScheduleRepository;
import project.planner.service.ScheduleService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public ScheduleService scheduleService() {
        return new ScheduleService(scheduleRepository());
    }

    @Bean
    public ScheduleRepository scheduleRepository() {
        return new JpaScheduleRepository(em);
    }
}
