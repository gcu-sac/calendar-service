package calendar.calendar_service.service;

import calendar.calendar_service.domain.Schedule;
import calendar.calendar_service.repository.ScheduleDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleDao scheduleDao;

    public ScheduleService(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public List<Schedule> findAllSchedules() {
        return scheduleDao.findAll();
    }

    public List<Schedule> findSchedulesByMonthAndYear(int month, int year) {
        return scheduleDao.findSchedulesByMonthAndYear(month, year);
    }
}
