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
@Table(name = "post")
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Lob
    @Column(name = "content", columnDefinition = "text")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Post parent;

    @Column(name = "title", nullable = false, length = 275)
    private String title;

    @Column(name = "metaTitle", length = 300)
    private String metaTitle;

    @Lob
    @Column(name = "summary", columnDefinition = "text")
    private String summary;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "authorId", nullable = false)
    private User author;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostComment> postComments = new LinkedHashSet<>();

    @Column(name = "createdAt", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    @Column(name = "cover_image")
    private String coverImage;

    public Post(User author, Post parent, String title, String metaTitle, String summary, Boolean published, Instant createdAt, Instant updatedAt, Instant publishedAt, String content) {
        this.author = author;
        this.parent = parent;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", published=" + published +
                ", content='" + content + '\'' +
                ", parent=" + parent +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", author=" + author +
                ", posts=" + posts +
                ", postComments=" + postComments +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", publishedAt=" + publishedAt +
                ", coverImage='" + coverImage + '\'' +
                '}';
    }
}