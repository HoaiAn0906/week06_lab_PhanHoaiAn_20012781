package iuh.fit.week06_lab_phanhoaian_20012781.services;

import iuh.fit.week06_lab_phanhoaian_20012781.models.Post;
import iuh.fit.week06_lab_phanhoaian_20012781.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class PostServices {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
