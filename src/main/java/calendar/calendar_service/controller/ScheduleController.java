package calendar.calendar_service.controller;

import calendar.calendar_service.domain.Schedule;
import calendar.calendar_service.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/")
    public List<Schedule> Schedules(@RequestParam String month, @RequestParam String year) {
        System.out.println(month + "month" + year + "year");
        return scheduleService.findSchedulesByMonthAndYear(month, year);
    }

    @PostMapping("/new")
    public ResponseEntity<String> newewSchedule(@RequestBody Schedule schedule) {
        String result = scheduleService.newSchedule(schedule);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifySchedule(@RequestBody Schedule schedule) {
        String result = scheduleService.modifySchedule(schedule);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }
    @DeleteMapping("/delete/{scheduleID}")
    public ResponseEntity<String> deleteSchedule(@PathVariable int scheduleID) {
        String result = scheduleService.deleteSchedule(scheduleID);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }
}
