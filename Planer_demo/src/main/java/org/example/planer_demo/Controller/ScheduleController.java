package org.example.planer_demo.Controller;

import org.example.planer_demo.Controller.ScheduleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.planer_demo.domain.Schedule;
import org.example.planer_demo.repository.ScheduleRepository;
import org.example.planer_demo.service.ScheduleService;

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
        schedule.setUser_index(form.getUser_index());
        schedule.setDate(form.getDate());
        schedule.setTask(form.getTask());
        scheduleService.enterSchedule(schedule);
        return "redirect:/";
    }

    @GetMapping(value = "/schedules/delete")
    public String deleteForm(Model model) {
        List<Schedule> schedules = scheduleService.findAllSchedule();
        model.addAttribute("schedules", schedules);
        return "schedules/deleteScheduleForm";
    }

    @PostMapping(value = "/schedules/delete")
    public String delete(ScheduleForm form) {
        Schedule schedule = new Schedule();
        schedule.setSchedule_index(form.getSchedule_index());
        scheduleService.deleteSchedule(schedule.getSchedule_index());
        return "redirect:/";
    }

    @GetMapping("/schedules")
    public String list(Model model) {
        List<Schedule> schedules = scheduleService.findSchedule(1);
        model.addAttribute("schedules", schedules);
        return "schedules/scheduleList";
    }
}