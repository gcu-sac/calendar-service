package calendar.calendar_service.controller;

import calendar.calendar_service.domain.Schedule;
import calendar.calendar_service.domain.SendSchedule;
import calendar.calendar_service.service.AuthService;
import calendar.calendar_service.service.ScheduleService;
import io.swagger.v3.oas.annotations.headers.Header;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final AuthService authService;

    @GetMapping("/event")
    public List<SendSchedule> Schedules(@CookieValue String jwtAuthToken,@RequestHeader("userId") String userId, @RequestParam String month, @RequestParam String year) {
        System.out.println(month + "month" + year + "year");
        if (!authService.authenticate(jwtAuthToken)) {
            throw new RuntimeException("Authentication failed");
        }
        return scheduleService.findSchedulesByMonthAndYear(month, year, userId);
    }

    @PostMapping("/event")
    public ResponseEntity<String> newSchedule(@CookieValue String jwtAuthToken, @RequestBody Schedule schedule) {
        if (!authService.authenticate(jwtAuthToken)) {
            throw new RuntimeException("Authentication failed");
        }
        String result = scheduleService.newSchedule(schedule);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }

    @PutMapping("/event")
    public ResponseEntity<String> modifySchedule(@CookieValue String jwtAuthToken, @RequestBody Schedule schedule) {
        if (!authService.authenticate(jwtAuthToken)) {
            throw new RuntimeException("Authentication failed");
        }
        String result = scheduleService.modifySchedule(schedule);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }
    @DeleteMapping("/event/{scheduleID}")
    public ResponseEntity<String> deleteSchedule(@CookieValue String jwtAuthToken, @PathVariable int scheduleID) {
        if (!authService.authenticate(jwtAuthToken)) {
            throw new RuntimeException("Authentication failed");
        }
        String result = scheduleService.deleteSchedule(scheduleID);
        return ResponseEntity.ok(result); // You might want to adjust the response status based on the result
    }

    @GetMapping("/event/test")
    public String Schedules() {
        return "test";
    }
}
