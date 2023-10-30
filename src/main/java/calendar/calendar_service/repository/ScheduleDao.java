package calendar.calendar_service.repository;

import calendar.calendar_service.domain.ScheduleDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ScheduleDao implements ScheduleInterface {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public ScheduleDto save(ScheduleDto scheduleDto) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("Schedule").usingGeneratedKeyColumns("ScheduleID");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ScheduleName", scheduleDto.scheduleName());
        parameters.put("ScheduleDesc", scheduleDto.scheduleDesc());
        parameters.put("StartTime", scheduleDto.StartTime());
        parameters.put("EndTime", scheduleDto.EndTime());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        scheduleDto.setScheduleID(key.toString());
        return scheduleDto;
    }

    @Override
    public Optional<ScheduleDto> addMember(String id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM Schedule WHERE id = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<ScheduleDto> findAll() {
        return jdbcTemplate.query("select * from Schedule", scheduleDtoRowMapper());
    }

    private RowMapper<ScheduleDto> scheduleDtoRowMapper() {
        return new RowMapper<ScheduleDto>() {
            @Override
            public ScheduleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                ScheduleDto scheduleDto = new ScheduleDto();
                scheduleDto.setScheduleID(rs.getString("ScheduleID"));
                scheduleDto.setScheduleName(rs.getString("ScheduleName"));
                scheduleDto.setScheduleID(rs.getString("ScheduleDesc"));
                scheduleDto.setScheduleName(rs.getString("ScheduleName"));
                scheduleDto.setScheduleID(rs.getString("StartTime"));
                scheduleDto.setScheduleName(rs.getString("EndTime"));
                //scheduleDto.setScheduleName(rs.getString("GroupID"));
                //scheduleDto.setScheduleName(rs.getString("ScheduleColor"));

                return null;
            }
        };
    }
}