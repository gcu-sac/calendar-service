package calendar.calendar_service.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class CalendarController {
    @GetMapping("/calendar")
    public String calendarMain(Model model){

        return "calendar";
    }
}
