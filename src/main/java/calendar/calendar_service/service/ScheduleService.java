package calendar.calendar_service.service;

import calendar.calendar_service.domain.Schedule;
import calendar.calendar_service.domain.SendSchedule;
import calendar.calendar_service.repository.ScheduleDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleDao scheduleDao;

    public ScheduleService(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public List<SendSchedule> findAllSchedules() {
        return scheduleDao.findAll();
    }

    public List<SendSchedule> findSchedulesByMonthAndYear(String month, String year) {
        return scheduleDao.findSchedulesByMonthAndYear(month, year);
    }
    public String newSchedule(Schedule schedule) {
        return scheduleDao.newSchedule(schedule);
    }
    public String modifySchedule(Schedule schedule) {
        return scheduleDao.modifySchedule(schedule);
    }
    public String deleteSchedule(int scheduleID) {
        return scheduleDao.deleteSchedule(scheduleID);
    }
}
