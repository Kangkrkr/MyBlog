

-- User 테이블 초기 데이터
INSERT INTO users (username, email, password, role, created_at, active)
VALUES ('admin', 'admin@myblog.com', 'password123', 'ADMIN', '2023-11-21T12:00:00', true),
       ('user1', 'user1@myblog.com', 'password123', 'USER', '2023-11-20T15:30:00', true),
       ('user2', 'user2@myblog.com', 'password123', 'USER', '2023-11-20T16:00:00', false);

-- Category 테이블 초기 데이터
INSERT INTO category (name, description)
VALUES ('Technology', 'All about tech and programming'),
       ('Lifestyle', 'Lifestyle-related articles'),
       ('Travel', 'Travel tips and experiences');

-- Tag 테이블 초기 데이터
INSERT INTO tag (name)
VALUES ('Java'),
       ('Spring Boot'),
       ('Tutorial'),
       ('Coding'),
       ('Travel');

-- Post 테이블 초기 데이터
INSERT INTO post (title, content, author_id, status, created_at, updated_at, published_at, category_id)
VALUES ('Getting Started with Spring Boot', 'Content about Spring Boot...', 1, 'PUBLISHED', '2023-11-20T12:00:00',
        '2023-11-20T13:00:00', '2023-11-20T13:30:00', 1),
       ('Traveling to Spain', 'Content about Spain...', 2, 'PUBLISHED', '2023-11-18T10:00:00', '2023-11-19T15:00:00',
        '2023-11-19T15:30:00', 3),
       ('Top 5 Programming Languages', 'Content about programming...', 1, 'DRAFT', '2023-11-15T14:00:00', NULL, NULL,
        1);

-- Post_Tags 관계 매핑 초기 데이터
INSERT INTO post_tags (post_id, tag_id)
VALUES (1, 1), -- 'Getting Started with Spring Boot' has tag 'Java'
       (1, 2), -- 'Getting Started with Spring Boot' has tag 'Spring Boot'
       (3, 1), -- 'Top 5 Programming Languages' has tag 'Java'
       (3, 4);
-- 'Top 5 Programming Languages' has tag 'Coding'

-- Comment 테이블 초기 데이터
INSERT INTO comment (post_id, author_id, content, created_at, deleted)
VALUES (1, 2, 'Great article on Spring Boot!', '2023-11-21T09:00:00', false),
       (2, 3, 'Spain is such a beautiful place!', '2023-11-21T10:00:00', false),
       (3, 3, 'Please add more examples!', '2023-11-21T11:00:00', false);

-- Like 테이블 초기 데이터
INSERT INTO likes (post_id, user_id, created_at)
VALUES (1, 2, '2023-11-21T10:15:00'), -- user1 liked post 1
       (1, 3, '2023-11-21T11:00:00'), -- user2 liked post 1
       (2, 1, '2023-11-21T09:30:00'); -- admin liked post 2

