package iuh.fit.week06_lab_phanhoaian_20012781.config;

import iuh.fit.week06_lab_phanhoaian_20012781.repositories.TokenRepository;
import iuh.fit.week06_lab_phanhoaian_20012781.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        System.out.println("Hoai An 1");
        if (request.getServletPath().contains("/api/v1")) {
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("Hoai An 2");
        final String authorization = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (authorization == null && !authorization.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authorization.substring(7);
        userEmail = jwtService.extractUserName(jwt);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            var isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);

            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        System.out.println("Hoai An 2");
        filterChain.doFilter(request, response);
        System.out.println("Hoai An 3");
    }
}
