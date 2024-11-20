package com.RESTAPI.CRUD.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.RESTAPI.CRUD.entities.Category;
import com.RESTAPI.CRUD.models.CategoryModel;
import com.RESTAPI.CRUD.models.CategoryRes;
import com.RESTAPI.CRUD.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
    @GetMapping
    public Page<CategoryRes> getAllCategories(@RequestParam("page") Integer page) {
    	
        return categoryService.getAllCategories(0, page);
    }

    @PostMapping
    public CategoryModel createCategory(@RequestBody CategoryModel category) {
    	Category category2 = new Category();
    	category2.setName(category.getName());
    	Category res =  categoryService.createCategory(category2);
    	CategoryModel categoryModelRes = new CategoryModel();
    	categoryModelRes.setId(res.getId());
    	categoryModelRes.setName(res.getName());
    	return categoryModelRes;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Integer id) {
    	System.out.println("id " + id);
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
        return "category Id " + id +" updated";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully.";
    }
}
