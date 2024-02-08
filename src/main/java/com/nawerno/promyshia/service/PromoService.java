package com.nawerno.promyshia.service;

import com.nawerno.promyshia.entity.Promo;

import java.util.List;

public interface PromoService {
    Promo getById(int id);
    void create(Promo promo);

    List<Promo> getAll();
}
