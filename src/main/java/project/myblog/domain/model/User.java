package project.myblog.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.myblog.domain.code.Role;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")  // user 는 테이블 예약어라 실패..
@Getter
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // 사용자 이름
    private String email;    // 이메일
    private String password; // 비밀번호

    @Enumerated(EnumType.STRING)
    private Role role;       // 사용자 역할, ADMIN/USER

    private LocalDateTime createdAt; // 생성 시간

    private boolean active;  // 계정 활성 상태 여부
}