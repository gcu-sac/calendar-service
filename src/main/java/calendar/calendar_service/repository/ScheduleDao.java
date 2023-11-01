package calendar.calendar_service.repository;

import calendar.calendar_service.domain.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public List<Schedule> findSchedulesByMonthAndYear(int month, int year) {

        //이부분 쿼리문 다시
        //이부분 쿼리문 다시
        //이부분 쿼리문 다시

        String sql = "SELECT * FROM Schedule WHERE MONTH(StartTime) = ? AND YEAR(StartTime) = ?";
        return jdbcTemplate.query(sql, new ScheduleRowMapper(), month, year);
    }

    private static class ScheduleRowMapper implements RowMapper<Schedule> {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();

            schedule.setScheduleId(rs.getInt("ScheduleId"));
            schedule.setScheduleName(rs.getString("ScheduleName"));
            schedule.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
            schedule.setEndTime(rs.getTimestamp("EndTime").toLocalDateTime());
            schedule.setSchedulDesc(rs.getString("SchedulDesc"));
            schedule.setGroupId(rs.getString("GroupID"));
            //scheduleEntity.setScheduleColor(rs.getString("ScheduleColor"));

            return schedule;
        }
    }
}



