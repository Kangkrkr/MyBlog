package project.myblog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.myblog.domain.model.User;

import java.util.Optional;

/**
 * 1. **`JpaRepository<User, Long>`**:
 *     - `JpaRepository`를 확장함으로써 기본 제공되는 CRUD 메서드(`findById`, `save`, `deleteById` 등)를 사용할 수 있습니다.
 *     - 제네릭 타입: `<엔티티 클래스, 기본 키 타입>`
 *         - 여기서는 `User`와 `Long`을 지정함.
 *
 * 2. **커스텀 메서드**:
 *     - `JpaRepository`는 이름 기반 메서드로 커스텀 쿼리를 정의하는 것도 가능합니다.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // 필요한 경우 커스텀 쿼리 메서드를 추가로 정의할 수 있음
    Optional<User> findByUsername(String username);
}