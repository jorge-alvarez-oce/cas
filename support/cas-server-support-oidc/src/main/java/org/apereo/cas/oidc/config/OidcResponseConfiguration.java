package org.apereo.cas.oidc.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.oidc.OidcConfigurationContext;
import org.apereo.cas.oidc.issuer.OidcIssuerService;
import org.apereo.cas.oidc.token.OidcIdTokenGeneratorService;
import org.apereo.cas.oidc.web.OidcAccessTokenResponseGenerator;
import org.apereo.cas.oidc.web.OidcImplicitIdTokenAndTokenAuthorizationResponseBuilder;
import org.apereo.cas.oidc.web.OidcImplicitIdTokenAuthorizationResponseBuilder;
import org.apereo.cas.support.oauth.web.response.accesstoken.response.OAuth20AccessTokenResponseGenerator;
import org.apereo.cas.support.oauth.web.response.callback.OAuth20AuthorizationCodeAuthorizationResponseBuilder;
import org.apereo.cas.support.oauth.web.response.callback.OAuth20AuthorizationModelAndViewBuilder;
import org.apereo.cas.support.oauth.web.response.callback.OAuth20AuthorizationResponseBuilder;
import org.apereo.cas.support.oauth.web.response.callback.OAuth20ClientCredentialsResponseBuilder;
import org.apereo.cas.support.oauth.web.response.callback.OAuth20ResourceOwnerCredentialsResponseBuilder;
import org.apereo.cas.support.oauth.web.response.callback.OAuth20TokenAuthorizationResponseBuilder;
import org.apereo.cas.ticket.IdTokenGeneratorService;
import org.apereo.cas.token.JwtBuilder;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * This is {@link OidcResponseConfiguration}.
 *
 * @author Misagh Moayyed
 * @since 6.4.0
 */
@Configuration(value = "OidcResponseConfiguration", proxyBeanMethods = false)
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class OidcResponseConfiguration {

    @Configuration(value = "OidcResponseAccessTokenConfiguration", proxyBeanMethods = false)
    @EnableConfigurationProperties(CasConfigurationProperties.class)
    public static class OidcResponseAccessTokenConfiguration {

        @ConditionalOnMissingBean(name = "oidcAccessTokenResponseGenerator")
        @Bean
        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        public OAuth20AccessTokenResponseGenerator oidcAccessTokenResponseGenerator(
            @Qualifier("oidcIdTokenGenerator")
            final IdTokenGeneratorService oidcIdTokenGenerator,
            @Qualifier("accessTokenJwtBuilder")
            final JwtBuilder accessTokenJwtBuilder,
            final CasConfigurationProperties casProperties,
            @Qualifier("oidcIssuerService")
            final OidcIssuerService oidcIssuerService) {
            return new OidcAccessTokenResponseGenerator(oidcIdTokenGenerator, accessTokenJwtBuilder,
                casProperties, oidcIssuerService);
        }
    }

    @Configuration(value = "OidcResponseClientCredentialConfiguration", proxyBeanMethods = false)
    @EnableConfigurationProperties(CasConfigurationProperties.class)
    public static class OidcResponseClientCredentialConfiguration {
        @Bean
        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        @ConditionalOnMissingBean(name = "oidcClientCredentialsResponseBuilder")
        public OAuth20AuthorizationResponseBuilder oidcClientCredentialsResponseBuilder(
            @Qualifier("oauthAuthorizationModelAndViewBuilder")
            final OAuth20AuthorizationModelAndViewBuilder oauthAuthorizationModelAndViewBuilder,
            @Qualifier("oidcConfigurationContext")
            final OidcConfigurationContext oidcConfigurationContext) {
            return new OAuth20ClientCredentialsResponseBuilder(
                oidcConfigurationContext,
                oauthAuthorizationModelAndViewBuilder);
        }

    }

    @Configuration(value = "OidcResponseTokenConfiguration", proxyBeanMethods = false)
    @EnableConfigurationProperties(CasConfigurationProperties.class)
    public static class OidcResponseTokenConfiguration {
        @Bean
        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        @ConditionalOnMissingBean(name = "oidcTokenResponseBuilder")
        public OAuth20AuthorizationResponseBuilder oidcTokenResponseBuilder(
            @Qualifier("oauthAuthorizationModelAndViewBuilder")
            final OAuth20AuthorizationModelAndViewBuilder oauthAuthorizationModelAndViewBuilder,
            @Qualifier("oidcConfigurationContext")
            final OidcConfigurationContext oidcConfigurationContext) {
            return new OAuth20TokenAuthorizationResponseBuilder(
                oidcConfigurationContext,
                oauthAuthorizationModelAndViewBuilder);
        }
    }

    @Configuration(value = "OidcResponseAuthorizationCodeConfiguration", proxyBeanMethods = false)
    @EnableConfigurationProperties(CasConfigurationProperties.class)
    public static class OidcResponseAuthorizationCodeConfiguration {
        @Bean
        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        @ConditionalOnMissingBean(name = "oidcAuthorizationCodeResponseBuilder")
        public OAuth20AuthorizationResponseBuilder oidcAuthorizationCodeResponseBuilder(
            @Qualifier("oauthAuthorizationModelAndViewBuilder")
            final OAuth20AuthorizationModelAndViewBuilder oauthAuthorizationModelAndViewBuilder,
            @Qualifier("oidcConfigurationContext")
            final OidcConfigurationContext oidcConfigurationContext) {
            return new OAuth20AuthorizationCodeAuthorizationResponseBuilder(
                oidcConfigurationContext,
                oauthAuthorizationModelAndViewBuilder);
        }


    }

    @Configuration(value = "OidcResponseImplicitConfiguration", proxyBeanMethods = false)
    @EnableConfigurationProperties(CasConfigurationProperties.class)
    public static class OidcResponseImplicitConfiguration {
        @Bean
        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        @ConditionalOnMissingBean(name = "oidcImplicitIdTokenCallbackUrlBuilder")
        public OAuth20AuthorizationResponseBuilder oidcImplicitIdTokenCallbackUrlBuilder(
            @Qualifier("oauthAuthorizationModelAndViewBuilder")
            final OAuth20AuthorizationModelAndViewBuilder oauthAuthorizationModelAndViewBuilder,
            @Qualifier("oidcConfigurationContext")
            final OidcConfigurationContext oidcConfigurationContext) {
            return new OidcImplicitIdTokenAuthorizationResponseBuilder(
                oidcConfigurationContext,
                oauthAuthorizationModelAndViewBuilder);
        }

        @Bean
        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        @ConditionalOnMissingBean(name = "oidcImplicitIdTokenAndTokenCallbackUrlBuilder")
        public OAuth20AuthorizationResponseBuilder oidcImplicitIdTokenAndTokenCallbackUrlBuilder(
            @Qualifier("oauthAuthorizationModelAndViewBuilder")
            final OAuth20AuthorizationModelAndViewBuilder oauthAuthorizationModelAndViewBuilder,
            @Qualifier("oidcConfigurationContext")
            final OidcConfigurationContext oidcConfigurationContext) {
            return new OidcImplicitIdTokenAndTokenAuthorizationResponseBuilder(
                oidcConfigurationContext,
                oauthAuthorizationModelAndViewBuilder);
        }

    }

    @Configuration(value = "OidcResponseResourceOwnerConfiguration", proxyBeanMethods = false)
    @EnableConfigurationProperties(CasConfigurationProperties.class)
    public static class OidcResponseResourceOwnerConfiguration {
        @Bean
        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        @ConditionalOnMissingBean(name = "oidcResourceOwnerCredentialsResponseBuilder")
        public OAuth20AuthorizationResponseBuilder oidcResourceOwnerCredentialsResponseBuilder(
            @Qualifier("oauthAuthorizationModelAndViewBuilder")
            final OAuth20AuthorizationModelAndViewBuilder oauthAuthorizationModelAndViewBuilder,
            @Qualifier("oidcConfigurationContext")
            final OidcConfigurationContext oidcConfigurationContext) {
            return new OAuth20ResourceOwnerCredentialsResponseBuilder(
                oidcConfigurationContext,
                oauthAuthorizationModelAndViewBuilder);
        }
    }

    @Configuration(value = "OidcResponseTokenGenerationConfiguration", proxyBeanMethods = false)
    @EnableConfigurationProperties(CasConfigurationProperties.class)
    public static class OidcResponseTokenGenerationConfiguration {

        @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
        @ConditionalOnMissingBean(name = "oidcIdTokenGenerator")
        @Bean
        public IdTokenGeneratorService oidcIdTokenGenerator(
            @Qualifier("oidcConfigurationContext")
            final ObjectProvider<OidcConfigurationContext> oidcConfigurationContext) {
            return new OidcIdTokenGeneratorService(oidcConfigurationContext);
        }
    }

}
