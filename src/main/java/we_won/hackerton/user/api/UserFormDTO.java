package we_won.hackerton.user.api;

import lombok.Getter;
import lombok.Setter;
import we_won.hackerton.common.constant.UserRole;
import we_won.hackerton.user.domain.User_;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserFormDTO {

    @NotBlank(message = "아이디는 필수로 작성해야 합니다.")
    private String username;

    private String password;

    private final UserRole role = UserRole.USER;

    public User_ toEntity(){
        return User_.builder()
                .username(this.username)
                .password(this.password)
                .role(this.role)
                .build();
    }
}
