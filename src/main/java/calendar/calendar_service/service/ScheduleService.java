package calendar.calendar_service.service;

import calendar.calendar_service.domain.Member;
import calendar.calendar_service.repository.ScheduleDao;
import calendar.calendar_service.repository.ScheduleInterface;

import java.util.List;

public class ScheduleService {
    private final ScheduleInterface scheduleInterface;
    public ScheduleService(ScheduleInterface scheduleInterface) {
        this.scheduleInterface = scheduleInterface;
    }

}
