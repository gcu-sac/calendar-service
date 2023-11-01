package calendar.calendar_service.controller;

import calendar.calendar_service.domain.Schedule;
import calendar.calendar_service.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/")
    public List<Schedule> getSchedules(@RequestParam int month, @RequestParam int year) {
        System.out.println(month+"월"+year+"년");
        return scheduleService.findAllSchedules();
    }
}
