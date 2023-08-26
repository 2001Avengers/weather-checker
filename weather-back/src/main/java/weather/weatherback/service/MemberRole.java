/*
스프링 시큐리티는 인증 뿐만 아니라 권한도 관리한다.
따라서 인증후에 사용자에게 부여할 권한이 필요하다.
다음과 같이 ADMIN, USER 2개의 권한을 갖는 UserRole을 신규로 작성하자.
 */

package weather.weatherback.service;

import lombok.Getter;

@Getter
public enum MemberRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    MemberRole(String roleUser) {
        this.roleUser = roleUser;
    }

    private String roleUser;
}
