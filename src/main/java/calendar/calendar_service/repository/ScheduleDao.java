package calendar.calendar_service.repository;
import calendar.calendar_service.domain.Schedule;
import calendar.calendar_service.domain.ScheduleResponseDTO;
import calendar.calendar_service.domain.SendSchedule;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class ScheduleDao {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SendSchedule> findAll() {
        String sql = "SELECT * FROM Schedule";
        return jdbcTemplate.query(sql, new ScheduleRowMapper());
    }

    public List<SendSchedule> findSchedulesByMonthAndYear(String month, String year, String userId) {
        String sql = "SELECT * FROM Schedule WHERE MONTH(StartTime) = ? AND YEAR(StartTime) = ? AND UserID =?";
        return jdbcTemplate.query(sql, new ScheduleRowMapper(), month, year, userId);
    }
    /*
    private Long getMaxId() {
        String sql = "SELECT MAX(ScheduleID) FROM schedule";
        Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
        return (maxId == null) ? 0 : maxId;
    }
    */
    public String newSchedule(Schedule schedule) {
        String sql = "INSERT INTO Schedule (ScheduleID, UserID, ScheduleName, StartTime, EndTime, ScheduleDesc) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            int result = jdbcTemplate.update(sql,
                    null,
                    schedule.userID(),
                    schedule.scheduleName(),
                    Timestamp.valueOf(schedule.convertStatTime()),
                    Timestamp.valueOf(schedule.convertStatTime()),
                    schedule.scheduleDesc());

            if (result > 0) {
                return "Schedule added successfully with id: " + schedule.userID();
            } else {
                return "Failed to add schedule.";
            }
        } catch (DataAccessException e) {
            // Log exception details
            return "Error accessing data: " + e.getMessage();
        }
    }
    public String modifySchedule(Schedule schedule) {

        String sql = "UPDATE Schedule SET UserID =?, ScheduleName = ?, StartTime = ?, EndTime = ?, ScheduleDesc = ? WHERE ScheduleID = ?";
        try {
            int result = jdbcTemplate.update(sql,
                    schedule.userID(),
                    schedule.scheduleName(),
                    Timestamp.valueOf(schedule.convertStatTime()),
                    Timestamp.valueOf(schedule.convertEndTime()),
                    schedule.scheduleDesc(),
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
        String sql = "DELETE FROM Schedule WHERE ScheduleID = ?";

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
    private static class ScheduleRowMapper implements RowMapper<SendSchedule> {
        @Override
        public SendSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            ScheduleResponseDTO DBschedule = new ScheduleResponseDTO();
            DBschedule.setScheduleID(rs.getInt("ScheduleId"));
            DBschedule.setUserID(rs.getString("UserID"));
            DBschedule.setScheduleName(rs.getString("ScheduleName"));
            DBschedule.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
            DBschedule.setEndTime(rs.getTimestamp("EndTime").toLocalDateTime());
            DBschedule.setScheduleDesc(rs.getString("ScheduleDesc"));
            DBschedule.setTime(null);


            SendSchedule Fschedule = new SendSchedule();
            Fschedule.setScheduleID(DBschedule.scheduleID());
            Fschedule.setUserID(DBschedule.userID());
            Fschedule.setScheduleName(DBschedule.scheduleName());
            Fschedule.setStartTime(DBschedule.sendtStatTime(DBschedule.startTime()));
            Fschedule.setEndTime(DBschedule.sendEndTime(DBschedule.endTime()));
            Fschedule.setScheduleDesc(DBschedule.scheduleDesc());


            return Fschedule;
        }
    }
}



