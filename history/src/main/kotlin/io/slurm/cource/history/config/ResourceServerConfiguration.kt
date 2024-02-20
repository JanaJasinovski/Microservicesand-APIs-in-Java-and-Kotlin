package io.slurm.cource.history.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

@Configuration
@EnableResourceServer
class ResourceServerConfiguration() {


//    @Bean
//    fun configure(resources: ResourceServerSecurityConfigurer) {
//        resources.resourceId(RESOURCE_ID)
//    }

    @Throws(Exception::class)
    @Bean
    fun configure(http: HttpSecurity): HttpSecurity {
        return http
                .csrf { it.disable() }
                .authorizeHttpRequests {
                    it
                            .requestMatchers(SECURED_PATTERN).authenticated()
                            .anyRequest().hasAuthority(SECURED_SCOPE)
                }
                .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

    }

    companion object {
        private const val RESOURCE_ID = "history"
        private const val SECURED_SCOPE = "#oauth2.hasScope('web')"
        private const val SECURED_PATTERN = "/**"
    }
}