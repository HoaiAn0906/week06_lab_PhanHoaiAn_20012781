package iuh.fit.week06_lab_phanhoaian_20012781.repositories;

import iuh.fit.week06_lab_phanhoaian_20012781.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}