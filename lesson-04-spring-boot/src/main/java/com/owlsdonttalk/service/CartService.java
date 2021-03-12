package com.owlsdonttalk.service;


import com.owlsdonttalk.persist.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CartService {



    void addProductForUserQty(long productId, long userId, int qty);

    void removeProductForUser(long productId, long userId, int qty);

    void removeAllForUser(long userId);

    List<LineItem> findAllItemsForUser(long userId);

    //Page<LineItem> findAllItemsForUser(long userId);
}
