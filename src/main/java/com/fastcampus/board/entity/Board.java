package com.fastcampus.board.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  GenerationType.SEQUENCE와의 차이는?
    private long seq;

    @NotNull
    private String title;

    @NotNull
    private String writer;

    @NotNull
    private String content;

    @CreationTimestamp  // @updateTimestamp VS @CreatedDate  Vs  @LastModifiedDate
    private LocalDateTime regDate;

    private long cnt;

    @Builder
//    public Board(long seq, String writer, String title, String content, long cnt) {
    public Board(String writer, String title, String content) {
//        this.seq = seq;
        this.writer = writer;
        this.title = title;
        this.content = content;
//        this.cnt = cnt;
    }
}
