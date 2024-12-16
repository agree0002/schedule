package project.planner.repository;

import project.planner.domain.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule insert (Schedule schedule);
    long delete (int schedule_index);
    Schedule update(Schedule schedule);
    List<Schedule> findByIdx(int user_index);
}
