package iuh.fit.week06_lab_phanhoaian_20012781.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import iuh.fit.week06_lab_phanhoaian_20012781.models.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_at")
    private Instant expiresAt;
    @JsonProperty("user")
    private User user;
 }
