package we_won.hackerton.user.domain;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import we_won.hackerton.common.constant.UserRole;

import javax.persistence.*;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User_ extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    @Builder
    public User_(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
