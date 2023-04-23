package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.dto.CategoryDto;
import com.example.TravelSpringBootProject.entity.Category;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@Service
public interface ICategoryService {
    Category save(Category category);
    Category findById(Long id);
    List<Category> findAll();
    Boolean update (Category category,Long categoryId);
    Boolean delete (Long categoryId);

}
