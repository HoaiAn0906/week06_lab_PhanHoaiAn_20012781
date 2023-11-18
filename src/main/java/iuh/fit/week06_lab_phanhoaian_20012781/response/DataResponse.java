package iuh.fit.week06_lab_phanhoaian_20012781.response;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {
    private T data;
    private String message;
    private int status;
}