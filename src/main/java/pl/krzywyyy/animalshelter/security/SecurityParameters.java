package pl.krzywyyy.animalshelter.security;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityParameters {
    public final String AUTHORIZATION_HEADER = "Authorization";
    public final String BEARER_PREFIX = "Bearer ";
    public final String SECRET_KEY = "SecretKey";
    public final String JSON_CONTENT_TYPE = "application/json";
    public final String UTF_CHARACTER_ENCODING = "UTF-8";
    public final String CLIENT_ROLE = "CLIENT";
    public final String EMPLOYEE_ROLE = "EMPLOYEE";
    public final String MANAGEMENT_ROLE = "MANAGEMENT";
    public final String ADMIN_ROLE = "ADMIN";
    public final String USER_NOT_AUTHORIZED_EXCEPTION_MESSAGE = "Authentication failed";
    public final long TOKEN_EXPIRATION_TIME = 364_000_000;
    public final String LOGIN_URL = "/login";
}
