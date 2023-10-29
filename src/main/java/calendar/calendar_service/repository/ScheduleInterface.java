package calendar.calendar_service.repository;
import calendar.calendar_service.domain.ScheduleDto;

import java.util.List;
import java.util.Optional;

public interface ScheduleInterface {
    ScheduleDto save(ScheduleDto scheduleDto);
    Optional<ScheduleDto> add(String id);
    Optional<ScheduleDto> delete(String id);
    List<ScheduleDto> findAll();
}
