package com.ryan.drinklogger.config

import com.ryan.drinklogger.constants.BCRYPT_STRENGTH
import com.ryan.drinklogger.constants.GET_PATTERNS
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, *GET_PATTERNS).hasAuthority("SCOPE_read")
                .anyRequest().hasAuthority("SCOPE_write")
                .and()
                .oauth2ResourceServer()
                .jwt()
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder(BCRYPT_STRENGTH)
}