package project.planner.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import project.planner.domain.Schedule;
import project.planner.repository.ScheduleRepository;

import java.util.List;




@Transactional
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public int enterSchedule(Schedule schedule) {
    scheduleRepository.insert(schedule);
    return schedule.getSchedule_index();
}

    public long deleteSchedule(int schedule_index) {
        return scheduleRepository.delete(schedule_index);
    }

    public List<Schedule> findSchedule(int user_index) {
        return scheduleRepository.findByIdx(user_index);
    }



}