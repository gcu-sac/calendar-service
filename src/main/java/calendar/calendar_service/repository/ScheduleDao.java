package calendar.calendar_service.repository;
import calendar.calendar_service.domain.Schedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public class ScheduleDao {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Schedule> findAll() {
        String sql = "SELECT * FROM schedule";
        return jdbcTemplate.query(sql, new ScheduleRowMapper());
    }

    public List<Schedule> findSchedulesByMonthAndYear(String month, String year) {
        String sql = "SELECT * FROM Schedule WHERE MONTH(StartTime) = ? AND YEAR(StartTime) = ?";
        return jdbcTemplate.query(sql, new ScheduleRowMapper(), month, year);
    }
    private Long getMaxId() {
        String sql = "SELECT MAX(ScheduleID) FROM schedule";
        Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
        return (maxId == null) ? 0 : maxId;
    }
    public String newSchedule(Schedule schedule) {
        Long newId = getMaxId() + 1; // Get the next id
        //System.out.println(newId);
        String sql = "INSERT INTO schedule (ScheduleID, ScheduleName, StartTime, EndTime, ScheduleDesc, GroupID) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            int result = jdbcTemplate.update(sql,
                    newId,
                    schedule.scheduleName(),
                    Timestamp.valueOf(schedule.startTime()),
                    Timestamp.valueOf(schedule.endTime()),
                    schedule.schedulDesc(),
                    schedule.groupID());

            if (result > 0) {
                return "Schedule added successfully with id: " + newId;
            } else {
                return "Failed to add schedule.";
            }
        } catch (DataAccessException e) {
            // Log exception details
            return "Error accessing data: " + e.getMessage();
        }
    }
    public String modifySchedule(Schedule schedule) {
        String sql = "UPDATE schedule SET ScheduleName = ?, StartTime = ?, EndTime = ?, ScheduleDesc = ?, GroupID = ? WHERE ScheduleID = ?";
        try {
            int result = jdbcTemplate.update(sql,
                    schedule.scheduleName(),
                    Timestamp.valueOf(schedule.startTime()),
                    Timestamp.valueOf(schedule.endTime()),
                    schedule.schedulDesc(),
                    schedule.groupID(),
                    schedule.scheduleID());

            if (result > 0) {
                return "Schedule modified successfully with id: " + schedule.scheduleID();
            } else {
                return "Failed to add schedule.";
            }
        } catch (DataAccessException e) {
            // Log exception details
            return "Error accessing data: " + e.getMessage();
        }
    }
    public String deleteSchedule(int scheduleID) {
        String sql = "DELETE FROM schedule WHERE ScheduleID = ?";

        try {
            int result = jdbcTemplate.update(sql, scheduleID);

            if (result > 0) {
                return "Schedule deleted successfully with id: " + scheduleID;
            } else {
                return "No schedule found with id: " + scheduleID;
            }
        } catch (DataAccessException e) {
            // Log exception details
            return "Error accessing data: " + e.getMessage();
        }
    }
    private static class ScheduleRowMapper implements RowMapper<Schedule> {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();

            schedule.setScheduleID(rs.getInt("ScheduleId"));
            schedule.setScheduleName(rs.getString("ScheduleName"));
            schedule.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
            schedule.setEndTime(rs.getTimestamp("EndTime").toLocalDateTime());
            schedule.setSchedulDesc(rs.getString("SchedulDesc"));
            schedule.setGroupID(rs.getString("GroupID"));
            //scheduleEntity.setScheduleColor(rs.getString("ScheduleColor"));

            return schedule;
        }
    }
}



