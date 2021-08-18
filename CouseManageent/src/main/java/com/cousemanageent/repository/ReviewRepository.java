package com.cousemanageent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cousemanageent.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	

}
