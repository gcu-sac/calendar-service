package calendar.calendar_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    // Assuming this method handles fetching data based on month and year
    @GetMapping("/")
    public String getEventsByMonthAndYear(@RequestParam(name = "month") String month,
                                          @RequestParam(name = "year") String year) {

        System.out.println(month+"and"+year);
        // Add logic here to process the month and year, fetch data, etc.
        return  month + "/" + year;
    }
}