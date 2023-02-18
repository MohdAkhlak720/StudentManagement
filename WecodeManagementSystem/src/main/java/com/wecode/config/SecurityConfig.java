package com.wecode.config;
/*
 * package com.wecode.main.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.csrf.CookieCsrfTokenRepository;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { //
 * http // .csrf() // .disable() // .authorizeRequests() //
 * .antMatchers("/public/**").hasRole("NORMAL") //
 * .antMatchers("/user/**").hasRole("ADMIN") //
 * .antMatchers("/student/{id}").hasRole("NORMAL") //
 * .antMatchers("/student/{id}","/student","/student/gender","/student/").
 * hasRole("ADMIN") // .anyRequest() // .authenticated() // .and() //
 * .httpBasic();
 * 
 * http
 * .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
 * .and() .authorizeRequests() .antMatchers("/public/**").hasRole("NORMAL")
 * .antMatchers("/user/**").hasRole("ADMIN")
 * .antMatchers("/student/{id}").hasRole("NORMAL")
 * .antMatchers("/student/{id}","/student","/student/gender","/student/").
 * hasRole("ADMIN") .anyRequest() .authenticated() .and() .httpBasic(); }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.inMemoryAuthentication().withUser("akhlak").password(this.
 * passwordEncoder().encode("pass123")).roles("NORMAL");
 * auth.inMemoryAuthentication().withUser("sajid").password(this.passwordEncoder
 * ().encode("pass321")).roles("ADMIN"); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(10); }
 * 
 * }
 */