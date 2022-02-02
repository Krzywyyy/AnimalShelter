package pl.krzywyyy.animalshelter.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import pl.krzywyyy.animalshelter.security.SecurityParameters;
import pl.krzywyyy.animalshelter.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends BasicAuthenticationFilter {

    private final UserService userService;

    public JwtAuthFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        final String authorizationHeader = request.getHeader(SecurityParameters.AUTHORIZATION_HEADER);

        if (authorizationHeader != null && authorizationHeader.startsWith(SecurityParameters.BEARER_PREFIX)) {
            final UsernamePasswordAuthenticationToken jwt = getAuthToken(authorizationHeader);
            SecurityContextHolder.getContext().setAuthentication(jwt);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthToken(String authorizationHeader) {
        final String email = JWT.require(Algorithm.HMAC256(SecurityParameters.SECRET_KEY.getBytes()))
                .build()
                .verify(authorizationHeader.replace(SecurityParameters.BEARER_PREFIX, StringUtils.EMPTY))
                .getSubject();
        final UserDetails user = userService.loadUserByUsername(email);

        if (user == null) {
            throw new AuthenticationServiceException(SecurityParameters.USER_NOT_AUTHORIZED_EXCEPTION_MESSAGE);
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
    }
}
