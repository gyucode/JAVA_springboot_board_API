package com.fastcampus.board.service;

import com.fastcampus.board.entity.Board;
import com.fastcampus.board.repository.BoardRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoardService {
    private final BoardRepository repository;

    @Autowired
    public BoardService(BoardRepository repository){
        this.repository = repository;
    }

    public void save(Board board){
        repository.save(board);
    }

    public List<Board> getList(){
        return (List<Board>) repository.findAll();
    }

    public void update(long id, String writer, String title, String content){
        Optional<Board> board = repository.findById(id);
        if(board.isPresent()){
            Board post = board.get();
            post.setWriter(writer);
            post.setTitle(title);
            post.setContent(content);
            post.setCnt(post.getCnt() +1);// 수정 시 CNT 1씩 증가
        }

    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public void increaseCnt(long id){
        Optional<Board> board = repository.findById(id);
        if(board.isPresent()) {
            Board post = board.get();
            post.setCnt(post.getCnt() +1);
        }

    }


}
