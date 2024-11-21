package org.example.planer_demo.service;

import org.example.planer_demo.domain.Schedule;
import org.example.planer_demo.repository.ScheduleRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    /*public long deleteSchedule() {

    }*/

    public List<Schedule> findSchedule(int user_index) {
        return scheduleRepository.findByIdx(user_index);
    }

}
