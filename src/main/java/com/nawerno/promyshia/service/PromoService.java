package com.nawerno.promyshia.service;

import com.nawerno.promyshia.entity.Promo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PromoService {
    Promo getById(int id);
    int create(Promo promo);

    List<Promo> getAll();

    boolean createImage(int id, MultipartFile file);


}
