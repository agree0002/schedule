package org.example.planer_demo.repository;

import org.example.planer_demo.domain.Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryScheduleRepository implements ScheduleRepository {
    private static Map<Integer, Schedule> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Schedule insert(Schedule schedule) {
        schedule.setSchedule_index(++sequence);
        store.put(schedule.getSchedule_index(), schedule);
        return schedule;
    }

    @Override
    public List<Schedule> findByIdx(int user_index) {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Schedule> findAll() {
        return List.of();
    }

    @Override
    public long delete(int schedule_index) {
        return 0;
    }

    @Override
    public Schedule update(Schedule schedule) {
        return null;
    }
}
