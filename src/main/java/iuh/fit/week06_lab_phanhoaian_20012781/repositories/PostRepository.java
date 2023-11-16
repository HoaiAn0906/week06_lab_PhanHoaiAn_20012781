package iuh.fit.week06_lab_phanhoaian_20012781.repositories;

import iuh.fit.week06_lab_phanhoaian_20012781.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
}