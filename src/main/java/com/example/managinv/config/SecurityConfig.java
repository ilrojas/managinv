package com.example.managinv.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
//esta anotacion permite trabajar con Spring Security mediante anotaciones en cada controlador, si lo utilizaramos
// deberias quitar la parte de authorizeHttpRequests en el metodo securityFilterChain y colocar primeramente la
//anotacion @PreAuthorize("hasAuthority('READ')") en cada controlador 
@EnableMethodSecurity
public class SecurityConfig {


    //1er paso
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        
        return httpSecurity
        //el httpBasic se usa solo cuando nos vamos a autenticar solo con usuario y contraseña.
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        //aqui se define el acceso a los endpoints segun los permisos.
        .authorizeHttpRequests(http -> {
            //configuramos los endpoints que van a ser publicos
            http.requestMatchers(HttpMethod.GET, "/auth/hello").permitAll();
            //configuramos los endpoints privados
            http.requestMatchers(HttpMethod.GET, "/auth/hello-secured").hasAuthority("READ");
            //configuramos el resto de los endpoints - NO ESPECIFICADOS
            //si no estan especificados en ninguno de los de arriba los rechaza todos
            http.anyRequest().denyAll();
            //aunque no los especifique arriba si tiene credenciales correctas va a dejar pasar al endpoint
            //http.anyRequest().authenticated();
        })
        .build();
    }

    //2do paso
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withUsername("ivan")
                                    .password("1234")
                                    .roles("Admin")
                                    .authorities("READ","CREATE")
                                    .build();
        //Aqui estamos guardando en memoria el userDetail creado
        return new InMemoryUserDetailsManager(userDetails);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        //este solo para pruebas en su lugar usar BCryptPasswordEncoder
        return NoOpPasswordEncoder.getInstance();
    }
}
