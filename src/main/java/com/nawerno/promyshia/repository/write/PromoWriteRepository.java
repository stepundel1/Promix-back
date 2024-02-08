package com.nawerno.promyshia.repository.write;

import com.nawerno.promyshia.entity.Promo;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoWriteRepository {
    int create(Promo p);

}
