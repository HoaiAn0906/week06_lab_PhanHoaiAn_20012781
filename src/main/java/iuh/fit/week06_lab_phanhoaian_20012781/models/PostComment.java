package iuh.fit.week06_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "post_comment")
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PostComment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private PostComment parent;

    @Column(name = "createdAt", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant createdAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    public PostComment(Post post, PostComment parent, String title, User user, Boolean published, Instant createdAt, Instant publishedAt, String content, Set<PostComment> postComments) {
        this.post = post;
        this.parent = parent;
        this.title = title;
        this.user = user;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.postComments = postComments;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", postComments=" + postComments +
                ", post=" + post +
                ", parent=" + parent +
                ", createdAt=" + createdAt +
                ", publishedAt=" + publishedAt +
                '}';
    }
}