package com.example.demo.Security;

import com.example.demo.Modules.AppRole;
import com.example.demo.Modules.Role;
import com.example.demo.Repositories.EmployeeRepo;
import com.example.demo.Repositories.RoleRepo;
import com.example.demo.Repositories.TenantRepo;
import com.example.demo.Security.JWT.AuthEntryPointJwt;
import com.example.demo.Security.JWT.JwtFilter;
import com.example.demo.Security.JWTService.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public JwtFilter authenticationJwtFilter() {
        return new JwtFilter();
    }


    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> {})
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                .requestMatchers("/h2-console/**").permitAll()
//                                .requestMatchers("/api/admin/**").permitAll()
                                .requestMatchers("/api/public/**").permitAll()
                                .requestMatchers("/api/test/**").permitAll()
                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                .anyRequest().authenticated()
                );
        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers(headers -> headers.frameOptions(
                frameOptions -> frameOptions.sameOrigin()));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImp);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public CommandLineRunner initData(RoleRepo roleRepository, EmployeeRepo userRepository, PasswordEncoder passwordEncoder, TenantRepo tenantRepo) {
        return args -> {



            // Retrieve or create roles
            Role employeeRole = roleRepository.findByRoleName(AppRole.ROLE_EMPLOYEE);
            if(employeeRole==null) {
                Role newEmployeeRole = new Role();
                newEmployeeRole.setRoleName(AppRole.ROLE_EMPLOYEE);
                roleRepository.save(newEmployeeRole);
                employeeRole=newEmployeeRole;
            };

            Role managerRole = roleRepository.findByRoleName(AppRole.ROLE_MANAGER);
            if(managerRole==null) {
                Role newManagerRole = new Role();
                newManagerRole.setRoleName(AppRole.ROLE_MANAGER);
                roleRepository.save(newManagerRole);
                managerRole=newManagerRole;
            }

        };
    }


}