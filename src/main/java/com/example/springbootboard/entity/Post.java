package com.example.springbootboard.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity<String> {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @Embedded
    private Title title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Post(@NonNull Title title, @NonNull String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        if(Objects.nonNull(user)) {
            setCreatedBy(user.getName());
        }
    }

    public void changeTitle(Title title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
