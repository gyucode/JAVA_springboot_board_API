package com.fastcampus.board.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    // PostDto는 JSP 화면과 Spring 서버가 주고받는 객체입니다.
    // PostDto를 수정하시기보다는 Post 클래스를 만들어 사용하기를 권장합니다.
    private long postId;
    private String nickName;
    private String title;
    private String content;
}
