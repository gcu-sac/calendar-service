package calendar.calendar_service;

import calendar.calendar_service.repository.*;
import calendar.calendar_service.service.MemberService;
import calendar.calendar_service.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService(){
       return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new JdbcTemplateMemberRepository(dataSource);
    }


    @Bean
    public ScheduleService scheduleService(){
        return new ScheduleService(scheduleInterface());
    }
    @Bean
    public ScheduleInterface scheduleInterface(){
        return new ScheduleDao(dataSource);
    }
}
