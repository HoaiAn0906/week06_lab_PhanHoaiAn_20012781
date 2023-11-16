package iuh.fit.week06_lab_phanhoaian_20012781.resource;

import iuh.fit.week06_lab_phanhoaian_20012781.models.Post;
import iuh.fit.week06_lab_phanhoaian_20012781.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PostResource {
    private final PostServices postServices;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postServices.getAllPosts());
    }


    //post
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(postServices.getPostById(id));
    }
}
