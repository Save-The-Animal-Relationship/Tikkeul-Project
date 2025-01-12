package com.tikkeul.app.service.item;

import com.tikkeul.app.dao.FileDAO;
import com.tikkeul.app.dao.ItemDAO;
import com.tikkeul.app.dao.ItemFileDAO;
import com.tikkeul.app.domain.dto.ItemDTO;
import com.tikkeul.app.domain.dto.OrderDTO;
import com.tikkeul.app.domain.type.CategoryType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("item") @Primary
public class ItemServiceImpl implements ItemService {
    private final ItemDAO itemDAO;
    private final ItemFileDAO itemFileDAO;
    private final FileDAO fileDAO;
//    김보령 작업공간
    //    열매샵 제품 목록 가져오기 : list.html
    @Override
    public List<ItemDTO> getList(CategoryType categoryType) {
        return itemDAO.findAll(categoryType);
    }

    //    열매샵 제품 상세 보기 : readDetail.html
    @Override
    public Optional<ItemDTO> readDetail(Long id) {
        return itemDAO.readDetail(id);
    }

    //    후기 수 별점
    @Override
    public Optional<OrderDTO> readScoreAndCountOfReview(Long id) {
        return itemDAO.readScoreAndCountOfReview(id);
    }



//    홍윤기 작업공간
    @Override
    public List<ItemDTO> getitemList() {
    return itemDAO.findAllItem();
    }

    @Override
    public List<ItemDTO> getOptionItemList(Long savingLevelId) {
        return itemDAO.findAllOptionItem(savingLevelId);
    }



}