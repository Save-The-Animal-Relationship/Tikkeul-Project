package com.tikkeul.app;


import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.DoranBoardVO;
import com.tikkeul.app.mapper.DoranBoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j

//도란도란 최보근
public class DoranDoranTests {
    @Autowired
    private DoranBoardMapper doranBoardMapper;

    @Test
    public void insertTest() {
        DoranBoardVO doranBoardVO = new DoranBoardVO();
        doranBoardVO.setId(7L);
        doranBoardVO.setTitle("테스트 제목 7");
        doranBoardVO.setContent("테스트 내용7");
        doranBoardVO.setViewCount(7);
        doranBoardVO.setUserId(7L);
        doranBoardVO.setItemId(7L);


        doranBoardMapper.insert(doranBoardVO);
    }

    @Test
    public void selectAllTest(){
        Pagination pagination = new Pagination();
        pagination.setPage(1); //화면에서 전달받은 페이지
//        assertThat(doranBoardMapper.selectAll()).hasSize(2);
        doranBoardMapper.selectAll(pagination, new Search()).stream().map(DoranBoardDTO::toString).forEach(log::info);
    }

    @Test
    public void selectTest() {
        doranBoardMapper.select(24L).map(DoranBoardDTO::getName).ifPresent(log::info);
    }

    @Test
    public void updateTest(){
        doranBoardMapper.select(24L).ifPresent(DoranBoardDTO -> {
            DoranBoardDTO.setContent("수정된 내용");
            doranBoardMapper.update(DoranBoardDTO);
        });
    }

    @Test
    public void deleteTest(){
        doranBoardMapper.delete(24L);
//        assertThat(doranBoardMapper.selectAll()).hasSize(1);
    }


}