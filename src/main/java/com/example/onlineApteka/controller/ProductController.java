package com.example.onlineApteka.controller;

import com.example.onlineApteka.model.Product;
import com.example.onlineApteka.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }


    @RequestMapping("/products")
    public String listProducts(Model model,
                               @Param("productName") String productName){
//        String productName="parasetamol";
        List<Product>products=productService.listAll(productName);
        model.addAttribute("products",products);
        return "products";
    }



    @PostMapping("/saveProducts")
    public String saveProducts(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/products";
    }




    @RequestMapping("/products/new")
    public String createProduct(Model model){
        Product product=new Product();
        model.addAttribute("products",product);
        return "create_products";
    }



    @RequestMapping("/products/editProduct/{id}")
    public String editProduct(@PathVariable("id")Long id,
                              Model model){
        model.addAttribute("products" , productService.findById(id));
        return "edit_products";
    }


    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") Long id,
                                @ModelAttribute("products") Product product,
                                Model model){
        Product existProduct=productService.findById(id);
        existProduct.setId(id);
        existProduct.setProductName(product.getProductName());
        existProduct.setProductRow(product.getProductRow());
        existProduct.setProductPlace(product.getProductPlace());
        existProduct.setProductPrice(product.getProductPrice());
        existProduct.setProductTabletka(product.getProductTabletka());
        existProduct.setProductUkol(product.getProductUkol());
        productService.updateProduct(existProduct);
        return "redirect:/products";
    }


//    @GetMapping("/p")
//    public String search( Model model, @RequestParam("name") String name){
//        this.name = name;
//
//        model.addAttribute("products",  productService.findByName(name));
//        return "redirect:/products";
//    }

    @RequestMapping("/p/{keyword}")
    public String viewHomePage(Model model, @PathVariable("keyword") String keyword) {
        List<Product> listProducts = productService.listAll(keyword);
        model.addAttribute("listProducts", productService.listAll(keyword));
        model.addAttribute("keyword", productService.listAll(keyword));
        return "redirect:/products";
    }




    @RequestMapping("/products/{id}")
    public String delete(@PathVariable("id")Long id){
        productService.deleteById(id);
        return "redirect:/products";
    }


}
