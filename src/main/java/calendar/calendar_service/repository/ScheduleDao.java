package calendar.calendar_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ScheduleDao {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
