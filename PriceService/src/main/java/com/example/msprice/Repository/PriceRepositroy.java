package com.example.msprice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.msprice.entity.Price;

@Repository
public interface PriceRepositroy extends JpaRepository<Price, Long> {

}
