package com.ischano.tmall.controller;

import com.ischano.tmall.entiey.Category;
import com.ischano.tmall.service.CategoryService;
import com.ischano.tmall.util.ImageUtil;
import com.ischano.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigator<Category> list(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }

    @PostMapping("/categories")
    public Object add(Category category, MultipartFile image, HttpServletRequest request) throws Exception {
        categoryService.add(category);
        saveOrUpdateImageFile(category, image, request);
        return category;
    }

    private void saveOrUpdateImageFile(Category category, MultipartFile image, HttpServletRequest request)
            throws Exception {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, category.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        categoryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return null;
    }

    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id) throws Exception {
        return categoryService.get(id);
    }

    @PutMapping("/categories/{id}")
    public Object update(Category category, MultipartFile image, HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        category.setName(name);
        categoryService.update(category);

        if (image != null) {
            saveOrUpdateImageFile(category, image, request);
        }
        return category;
    }
}

