package iuh.fit.week06_lab_phanhoaian_20012781.services;

import iuh.fit.week06_lab_phanhoaian_20012781.repositories.PostCommentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentServices {
    private PostCommentRepository postCommentRepository;
}
