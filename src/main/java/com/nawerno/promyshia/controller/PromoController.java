package com.nawerno.promyshia.controller;

import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.service.PromoService;
import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.service.PromoService;
import com.nawerno.promyshia.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/promo")
@Tag(name = "promo")
public class PromoController {
    private final PromoService promoService;

    @GetMapping("/{id}")
    @Operation(summary = "id")
    public Promo getById(@PathVariable("id")int id){
        return promoService.getById(id);
    }

    @PostMapping(value = "/create")
    @Operation(summary = "create Promo")
    public void create(@RequestBody Promo promo){
        promoService.create(promo);
    }
    @GetMapping("/list")
    @Operation(summary = "getAll promos")
    public List<Promo> getAll(){
        return promoService.getAll();
    }
}
