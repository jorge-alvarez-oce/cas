package org.apereo.cas.web;

import org.apereo.cas.audit.spi.config.CasCoreAuditConfiguration;
import org.apereo.cas.config.*;
import org.apereo.cas.config.support.CasWebApplicationServiceFactoryConfiguration;
import org.apereo.cas.config.support.authentication.AcceptUsersAuthenticationEventExecutionPlanConfiguration;
import org.apereo.cas.logging.config.CasLoggingConfiguration;
import org.apereo.cas.logout.config.CasCoreLogoutConfiguration;
import org.apereo.cas.oidc.config.*;
import org.apereo.cas.pm.config.PasswordManagementConfiguration;
import org.apereo.cas.pm.config.PasswordManagementForgotUsernameConfiguration;
import org.apereo.cas.pm.config.PasswordManagementWebflowConfiguration;
import org.apereo.cas.services.web.config.CasThemesConfiguration;
import org.apereo.cas.validation.config.CasCoreValidationConfiguration;
import org.apereo.cas.web.config.CasCookieConfiguration;
import org.apereo.cas.web.config.CasSupportActionsConfiguration;
import org.apereo.cas.web.config.CasValidationConfiguration;
import org.apereo.cas.web.flow.config.CasCoreWebflowConfiguration;
import org.apereo.cas.web.flow.config.CasMultifactorAuthenticationWebflowConfiguration;
import org.apereo.cas.web.flow.config.CasWebflowContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.audit.AuditAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.*;
import org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.web.client.HttpClientMetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.security.servlet.SecurityRequestMatchersManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.netty.NettyAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration;
import org.springframework.cloud.autoconfigure.LifecycleMvcEndpointAutoConfiguration;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.autoconfigure.RefreshEndpointAutoConfiguration;
import org.springframework.cloud.client.CommonsClientAutoConfiguration;
import org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClientAutoConfiguration;
import org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClientAutoConfiguration;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration;
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration;
import org.springframework.cloud.commons.util.UtilAutoConfiguration;
import org.springframework.cloud.configuration.CompatibilityVerifierAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@ImportAutoConfiguration({
        AcceptUsersAuthenticationEventExecutionPlanConfiguration.class,
        AopAutoConfiguration.class,
        AuditAutoConfiguration.class,
        AutoServiceRegistrationAutoConfiguration.class,
        CasCookieConfiguration.class,
        CasCoreAuditConfiguration.class,
        CasCoreAuthenticationComponentSerializationConfiguration.class,
        CasCoreAuthenticationConfiguration.class,
        CasCoreAuthenticationHandlersConfiguration.class,
        CasCoreAuthenticationMetadataConfiguration.class,
        CasCoreAuthenticationPolicyConfiguration.class,
        CasCoreAuthenticationPrincipalConfiguration.class,
        CasCoreAuthenticationServiceSelectionStrategyConfiguration.class,
        CasCoreAuthenticationSupportConfiguration.class,
        CasCoreConfiguration.class,
        CasCoreHttpConfiguration.class,
        CasCoreLogoutConfiguration.class,
        CasCoreMultifactorAuthenticationAuditConfiguration.class,
        CasCoreMultifactorAuthenticationConfiguration.class,
        CasCoreNotificationsConfiguration.class,
        // CasCoreRestConfiguration.class,
        CasCoreServicesAuthenticationConfiguration.class,
        CasCoreServicesComponentSerializationConfiguration.class,
        CasCoreServicesConfiguration.class,
        CasCoreTicketCatalogConfiguration.class,
        CasCoreTicketComponentSerializationConfiguration.class,
        CasCoreTicketIdGeneratorsConfiguration.class,
        CasCoreTicketsConfiguration.class,
        CasCoreTicketsSchedulingConfiguration.class,
        CasCoreTicketsSerializationConfiguration.class,
        CasCoreUtilConfiguration.class,
        CasCoreUtilSerializationConfiguration.class,
        CasCoreValidationConfiguration.class,
        CasCoreViewsConfiguration.class,
        CasCoreWebConfiguration.class,
        CasCoreWebflowConfiguration.class,
        CasDefaultServiceTicketIdGeneratorsConfiguration.class,
        CasDiscoveryProfileConfiguration.class,
        CasEmbeddedContainerTomcatConfiguration.class,
        CasEmbeddedContainerTomcatFiltersConfiguration.class,
        CasFiltersConfiguration.class,
        CasLoggingConfiguration.class,
        CasMultifactorAuthenticationWebflowConfiguration.class,
        CasOAuth20AuthenticationServiceSelectionStrategyConfiguration.class,
        CasOAuth20ComponentSerializationConfiguration.class,
        CasOAuth20Configuration.class,
        CasOAuth20EndpointsConfiguration.class,
        CasOAuth20ServicesConfiguration.class,
        CasOAuth20TicketSerializationConfiguration.class,
        CasOAuth20ThrottleConfiguration.class,
        CasOAuth20WebflowConfiguration.class,
        CasPersonDirectoryConfiguration.class,
        CasSupportActionsConfiguration.class,
        CasThemesConfiguration.class,
        CasThrottlingConfiguration.class,
        CasThymeleafConfiguration.class,
        CasValidationConfiguration.class,
        CasWebAppConfiguration.class,
        CasWebAppSecurityConfiguration.class,
        CasWebApplicationServiceFactoryConfiguration.class,
        CasWebflowContextConfiguration.class,
        CommonsClientAutoConfiguration.class,
        CompatibilityVerifierAutoConfiguration.class,
        CompositeDiscoveryClientAutoConfiguration.class,
        CompositeMeterRegistryAutoConfiguration.class,
        ConfigurationPropertiesAutoConfiguration.class,
        ConfigurationPropertiesRebinderAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        DispatcherServletAutoConfiguration.class,
        EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
        EndpointAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
        //GitServiceRegistryConfiguration.class,
        JsonServiceRegistryConfiguration.class,
        GsonAutoConfiguration.class,
        HealthContributorAutoConfiguration.class,
        HttpClientConfiguration.class,
        HttpClientMetricsAutoConfiguration.class,
        HttpEncodingAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
        InfoContributorAutoConfiguration.class,
        JtaAutoConfiguration.class,
        JvmMetricsAutoConfiguration.class,
        LifecycleAutoConfiguration.class,
        LifecycleMvcEndpointAutoConfiguration.class,
        Log4J2MetricsAutoConfiguration.class,
        ManagementContextAutoConfiguration.class,
        MessageSourceAutoConfiguration.class,
        MetricsAutoConfiguration.class,
        NettyAutoConfiguration.class,
        OidcComponentSerializationConfiguration.class,
        OidcConfiguration.class,
        OidcEndpointsConfiguration.class,
        OidcLogoutConfiguration.class,
        OidcResponseConfiguration.class,
        OidcThrottleConfiguration.class,
        PasswordManagementConfiguration.class,
        PasswordManagementForgotUsernameConfiguration.class,
        PasswordManagementWebflowConfiguration.class,
        PersistenceExceptionTranslationAutoConfiguration.class,
        ProjectInfoAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class,
        QuartzAutoConfiguration.class,
        RedisAutoConfiguration.class,
        RedisTicketRegistryConfiguration.class,
        RefreshAutoConfiguration.class,
        RefreshEndpointAutoConfiguration.class,
        RepositoryMetricsAutoConfiguration.class,
        RestTemplateAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        SecurityFilterAutoConfiguration.class,
        SecurityRequestMatchersManagementContextConfiguration.class,
        ServiceRegistryAutoConfiguration.class,
        ServletEndpointManagementContextConfiguration.class,
        ServletManagementContextAutoConfiguration.class,
        ServletWebServerFactoryAutoConfiguration.class,
        SimpleDiscoveryClientAutoConfiguration.class,
        SimpleMetricsExportAutoConfiguration.class,
        // SpringApplicationAdminJmxAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class,
        SqlInitializationAutoConfiguration.class,
        SystemMetricsAutoConfiguration.class,
        TaskExecutionAutoConfiguration.class,
        TaskSchedulingAutoConfiguration.class,
        ThymeleafAutoConfiguration.class,
        TomcatMetricsAutoConfiguration.class,
        TransactionAutoConfiguration.class,
        UserDetailsServiceAutoConfiguration.class,
        UtilAutoConfiguration.class,
        ValidationAutoConfiguration.class,
        WebEndpointAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        WebMvcEndpointManagementContextConfiguration.class,
        WebMvcMetricsAutoConfiguration.class
})
public class DefaultCasConfiguration {

}
