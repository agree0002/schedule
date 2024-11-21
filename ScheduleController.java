package project.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.planner.domain.Schedule;

import java.util.List;

public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedules/new")
    public String createFrom() {
        return "schedules/createScheduleForm";
    }

    @PostMapping
    public String create(ScheduleForm form) {
        Schedule schedule = new Schedule();
        schedule.setDate(form.getDate());
        schedule.setTask(form.getTask());
        scheduleService.enterSchedule(schedule);
        return "redirect:/";
    }

    @GetMapping("/schedules")
    public String list(Model model) {
        List<Schedule> schedules = scheduleService.findById();
        model.addAttribute("schedules", schedules);
        return "schedules/schduleList";
    }
}
