package com.chiaki.acdms;

import com.chiaki.acdms.service.SysUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService sysUserService() {
        return new SysUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/static/**","/SysIntroduction_visitor","/SysFrame_visitor",
                        "/SysFunction_visitor", "/SysSense_visitor","/LocationInfo_visitor",
                        "/ProbeInfo_visitor", "/CorrosionInfo_visitor",
                        "/LocationInfo_visitor/find","/LocationInfo_visitor_find",
                        "/LocationInfo/find","/LocationInfo_find",
                        "/AreaInfo_visitor/find", "/AreaInfo/find","/AreaInfo_visitor",
                        "/AreaInfo_find","/AreaInfo_visitor_ajax","/AreaInfo_visitor_find",
                        "/DeviceInfo_visitor/find","/DeviceInfo/find","/DeviceInfo_visitor",
                        "/DeviceInfo_find","/DeviceInfo_visitor_ajax","/DeviceInfo_visitor_find",
                        "/ProbeInfo_visitor/find","/ProbeInfo/find","/ProbeInfo_visitor",
                        "/ProbeInfo_find","/ProbeInfo_visitor_ajax","/ProbeInfo_visitor_find",
                        "/CorrosionInfo_visitor/find","/CorrosionInfo/find","/CorrosionInfo_visitor",
                        "/CorrosionInfo_find","/CorrosionInfo_visitor_ajax","/CorrosionInfo_visitor_find")
                .permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/Homepage")
                .failureUrl("/login?error").permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll();
    }
}