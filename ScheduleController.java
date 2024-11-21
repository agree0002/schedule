package project.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.planner.domain.Schedule;
import project.planner.repository.ScheduleRepository;
import project.planner.service.ScheduleService;

import java.util.List;

@Controller
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleService scheduleService, ScheduleRepository scheduleRepository) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping(value = "/schedules/new")
    public String createFrom() {
        return "schedules/createScheduleForm";
    }

    @PostMapping(value = "/schedules/new")
    public String create(ScheduleForm form) {
        Schedule schedule = new Schedule();
        schedule.setDate(form.getDate());
        schedule.setTask(form.getTask());
        scheduleService.enterSchedule(schedule);
        return "redirect:/";
    }

    @GetMapping("/schedules")
    public String list(Model model) {
        List<Schedule> schedules = scheduleService.findSchedule(1);
        model.addAttribute("schedules", schedules);
        return "schedules/scheduleList";
    }
}
