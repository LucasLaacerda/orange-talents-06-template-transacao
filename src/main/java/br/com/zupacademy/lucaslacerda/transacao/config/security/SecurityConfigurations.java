package br.com.zupacademy.lucaslacerda.transacao.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {


    //Configuracoes de autorizacao url e ets
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests(authorizeRequests ->
                authorizeRequests

                        .antMatchers(HttpMethod.GET,"/cartoes/**").hasAuthority("SCOPE_cartao:read")
                        .anyRequest().authenticated()

        ).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

}
