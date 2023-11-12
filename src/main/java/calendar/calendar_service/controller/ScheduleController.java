package calendar.calendar_service.controller;

import calendar.calendar_service.domain.Schedule;
import calendar.calendar_service.domain.SendSchedule;
import calendar.calendar_service.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/event")
    public List<SendSchedule> Schedules(@RequestParam String month, @RequestParam String year) {
        System.out.println(month + "month" + year + "year");
        return scheduleService.findSchedulesByMonthAndYear(month, year);
    }

    @PostMapping("/event")
    public ResponseEntity<String> newewSchedule(@RequestBody Schedule schedule) {
        String result = scheduleService.newSchedule(schedule);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }

    @PutMapping("/event")
    public ResponseEntity<String> modifySchedule(@RequestBody Schedule schedule) {
        String result = scheduleService.modifySchedule(schedule);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }
    @DeleteMapping("/event/{scheduleID}")
    public ResponseEntity<String> deleteSchedule(@PathVariable int scheduleID) {
        String result = scheduleService.deleteSchedule(scheduleID);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }
}
