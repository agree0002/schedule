package org.example.planer_demo.repository;

import jakarta.persistence.EntityManager;
import org.example.planer_demo.domain.Schedule;

import java.util.List;
import java.util.Optional;

public class JpaScheduleRepository implements ScheduleRepository{

    private final EntityManager em;

    public JpaScheduleRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Schedule insert(Schedule schedule) {
        em.persist(schedule);
        return schedule;
    }

    @Override
    public long delete(int schedule_index) {
        return 0;
    }

    @Override
    public Schedule update(Schedule schedule) {
        return null;
    }

    @Override
    public List<Schedule> findByIdx(int user_index) {
        return em.createQuery("select m from schedule m where m.userIndex= :user_index", Schedule.class)
                .setParameter("userIndex", user_index)
                .getResultList();
    }
}
