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
        // 먼저 schedule_index에 해당하는 엔티티 조회
        Schedule schedule = em.find(Schedule.class, schedule_index);

        if (schedule != null) {
            // 엔티티 삭제
            em.remove(schedule);
            return schedule_index; // 삭제된 schedule_index 반환
        } else {
            return 0; // 삭제 대상이 없으면 0 반환
        }
    }

    @Override
    public Schedule update(Schedule schedule) {
        return null;
    }

    @Override
    public List<Schedule> findByIdx(int user_index) {
        return em.createQuery("select m from Schedule m where m.user_index= :user_index", Schedule.class)
                .setParameter("user_index", user_index)
                .getResultList();
    }

    @Override
    public List<Schedule> findAll() {
        return em.createQuery("select m from Schedule m", Schedule.class)
                .getResultList();
    }
}
