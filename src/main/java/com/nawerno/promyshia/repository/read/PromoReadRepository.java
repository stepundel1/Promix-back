package com.nawerno.promyshia.repository.read;

import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PromoReadRepository {

    Promo getById (@Param("id") int id);

    List<Promo> getAll();
}

