package pl.krzywyyy.animalshelter.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.krzywyyy.animalshelter.model.dto.response.AuthTokenResponse;
import pl.krzywyyy.animalshelter.model.entity.abstracts.User;
import pl.krzywyyy.animalshelter.security.SecurityParameters;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class BasicAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public BasicAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(SecurityParameters.LOGIN_URL);
    }

    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        final User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword())
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {
        final String email = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal())
                .getUsername();
        final String jwt = JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParameters.TOKEN_EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SecurityParameters.SECRET_KEY.getBytes()));
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(SecurityParameters.JSON_CONTENT_TYPE);
        response.setCharacterEncoding(SecurityParameters.UTF_CHARACTER_ENCODING);
        response.getWriter().write(new ObjectMapper().writeValueAsString(new AuthTokenResponse(jwt)));
        response.getWriter().flush();
    }
}
