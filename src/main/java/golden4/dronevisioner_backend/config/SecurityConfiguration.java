package golden4.dronevisioner_backend.config;


import golden4.dronevisioner_backend.JwtAuthenticationEntryPoint;
import golden4.dronevisioner_backend.JwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//hej
@Configuration
@AllArgsConstructor
public class SecurityConfiguration implements WebMvcConfigurer {
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    private JwtFilter filter;
    private static PasswordEncoder passwordEncoder;
    @Bean
    public static PasswordEncoder passwordEncoder() {
        if(passwordEncoder==null){
            passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("WebSec configure(HttpSecurity) Call: 2");
        http.cors().and().csrf().disable()  // was cors().and() after http
                // to implement CSRF token https://www.javainuse.com/spring/boot_security_csrf
                // "antMathcers" comes from Apache Ant build system.
                // Since Spring 3, the next line replaces the old one:
                // .authorizeRequests().antMatchers("/login", "/signup").permitAll()
        .authorizeHttpRequests().requestMatchers("/*").permitAll()
                .requestMatchers(new AntPathRequestMatcher("/login/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/login/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/login/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/signup/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/signup/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/signup/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/frontPageInternal/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/frontPageInternal/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/frontPageInternal/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/appointment/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/appointment/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/appointment/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/updateAppointment/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/updateAppointment/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/updateAppointment/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/appointment/getAllAppointments/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/appointment/getAllAppointments/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/appointment/getAllAppointments/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/captureDevice")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/captureDevice/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/captureDevice/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/visualMediaType")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/visualMediaType/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/visualMediaType/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/PostVisualMediaType")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/PostVisualMediaType/*")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/PostVisualMediaType/**")).permitAll()


                //.requestMatchers(new AntPathRequestMatcher("/**", HttpMethod.OPTIONS.name())).permitAll()





        .anyRequest().authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

   /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("addCorsMappings called");
        registry.addMapping("/**")  // /** means match any string recursively
                .allowedOriginPatterns("*") //Multiple strings allowed. Wildcard * matches all port numbers.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // decide which methods to allow
                .allowCredentials(true);
    }


    *//*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:63342")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }*//*

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin("http://localhost:*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }*/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("addCorsMappings called");
        registry.addMapping("/**")  // /** means match any string recursively
                .allowedOriginPatterns("http://localhost:*") //Multiple strings allowed. Wildcard * matches all port numbers.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // decide which methods to allow
                .allowCredentials(true);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:63342");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


}
