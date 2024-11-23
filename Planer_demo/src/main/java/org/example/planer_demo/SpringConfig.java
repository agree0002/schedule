package org.example.planer_demo;

import jakarta.persistence.EntityManager;
import org.example.planer_demo.repository.JpaScheduleRepository;
import org.example.planer_demo.repository.MemoryScheduleRepository;
import org.example.planer_demo.repository.ScheduleRepository;
import org.example.planer_demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*@Bean
    public ScheduleService scheduleService() {
        return new ScheduleService(scheduleRepository());
    }

    @Bean
    public ScheduleRepository scheduleRepository() {
        return new MemoryScheduleRepository();
    }*/
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
