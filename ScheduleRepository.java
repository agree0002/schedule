package org.example.planer_demo.repository;

import org.example.planer_demo.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule insert (Schedule schedule);
    long delete (int schedule_index);
    Schedule update(Schedule schedule);
    List<Schedule> findByIdx(int user_index);
}
