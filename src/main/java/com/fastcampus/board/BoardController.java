package com.fastcampus.board;

import com.fastcampus.board.dto.PostDto;
import com.fastcampus.board.entity.Board;
import com.fastcampus.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    // TODO BoardController는 JSP를 이용한 화면 로직과 연결되어 있습니다.
    //  다른 부분은 바꾸지 말고 TODO 부분만 작성해주시기를 권장합니다 :)
    // TODO please write code on only TODO part in BoardController
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    /** CREATE */
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String createPost(@ModelAttribute("command") PostDto postDto){
        System.out.println("save " + postDto);
        /* TODO: 게시물 추가 로직*/
        Board board = new Board(
                            postDto.getNickName(),
                            postDto.getTitle(),
                            postDto.getContent()
                        );
        boardService.save( board );
        return "redirect:/";
    }

    /** READ */
    @RequestMapping("/")
    public String ReadAllPost(Model model){
        /* TODO 게시물 전체를 받아오는 로직 */
        List<PostDto> postList = new ArrayList<>();

        for (Board board: boardService.getList()){
            boardService.increaseCnt(board.getSeq());
            PostDto postDto = new PostDto(
                    board.getSeq(),
                    board.getWriter(),
                    board.getTitle(),
                    board.getContent()
            );
            postList.add( postDto );
        }
        System.out.println(postList);

        /* Do not change */
        model.addAttribute("postList", postList);

        return "index";
    }

    /** UPDATE */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("command") PostDto postDto){
        System.out.println("update " + postDto);
        /* TODO 게시물 수정 로직 */
        boardService.update(
                postDto.getPostId(),
                postDto.getNickName(),
                postDto.getTitle(),
                postDto.getContent()
        );

        return "redirect:/";
    }

    /** DELETE */
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String deletePost(@PathVariable int id){
        System.out.println("삭제 " + id);
        /* TODO 게시물 삭제 로직 */
        boardService.delete(id);
        return "redirect:/";
    }

    // ***************************************************************************************************
    // ******************************************* Do not edit *******************************************
    // 아래 부분은 수정 안하셔도 됩니다. (글 생성, 글 업데이트 창으로 연결하는 부분)

    @RequestMapping(value="/createView")
    public String ViewCreate(Model model){
        model.addAttribute("command", new PostDto());
        return "create";
    }

    @RequestMapping(value="/updateView/{id}")
    public String ViewUpdate(@PathVariable int id, Model model){
        PostDto postDto = new PostDto();
        postDto.setPostId(id);
        model.addAttribute("command",postDto);
        return "update";
    }
}

