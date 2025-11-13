package com.example.demo.Repositories;

import com.example.demo.Modules.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    Optional<Category> findById(Long id);

    Category findByCategoryName(String categoryName);
}
