package br.com.ryannardelli.registerProduct.controllers;

import br.com.ryannardelli.registerProduct.Models.Product;
import br.com.ryannardelli.registerProduct.Models.StatusProduct;
import br.com.ryannardelli.registerProduct.dto.RequestNewProduct;
import br.com.ryannardelli.registerProduct.repositories.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public ModelAndView index(HttpServletRequest request) {
        List<Product> products = this.productRepository.findAll();

        ModelAndView mv = new ModelAndView("products/product");
        mv.addObject("products", products);
        mv.addObject("currentPath", request.getServletPath());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView newProduct() {
        ModelAndView mv = new ModelAndView("products/new");
        mv.addObject("requestNewProduct", new RequestNewProduct());
        mv.addObject("statusProduct", StatusProduct.values());
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView showProduct(@PathVariable long id) {
        Optional <Product> optional = this.productRepository.findById(id);

        if(optional.isPresent()) {
            Product product = optional.get();
            ModelAndView mv = new ModelAndView("products/show");
            mv.addObject("product", product);
            return mv;
        } else {
            return new ModelAndView("redirect:/products");
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getProduct(@PathVariable long id, RequestNewProduct requestNewProduct) {
        Optional <Product> optional = this.productRepository.findById(id);

        if(optional.isPresent()) {
            Product product = optional.get();
            requestNewProduct.fromProduct(product);
            ModelAndView mv = new ModelAndView("products/edit");
            mv.addObject("statusProduct", StatusProduct.values());
            mv.addObject("productId", product.getId());
            return mv;
        } else {
            return new ModelAndView("redirect:/products");
        }
    }

    @PostMapping("")
    public ModelAndView create(@Valid RequestNewProduct requestNewProduct, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("products/new");
            mv.addObject("statusProduct", StatusProduct.values());
            return mv;
        } else {
            Product product = requestNewProduct.toProduct();
            this.productRepository.save(product);

            ModelAndView modelAndView = new ModelAndView("redirect:/products/" + product.getId());
            modelAndView.addObject("message", "Seu produto foi criado com sucesso!");
            modelAndView.addObject("success", true);

            return modelAndView;
        }
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable long id, @Valid RequestNewProduct requestNewProduct, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("products/edit");
            mv.addObject("statusProduct", StatusProduct.values());
            return mv;
        } else {
            Optional <Product> optional = this.productRepository.findById(id);
            if(optional.isPresent()) {
                Product product = requestNewProduct.toProduct(optional.get());
                this.productRepository.save(product);
                ModelAndView modelAndView = new ModelAndView("redirect:/products/" +product.getId());
                modelAndView.addObject("message", "Seu produto foi editado com sucesso!");
                modelAndView.addObject("success", true);
                return modelAndView;
            } else {
                return new ModelAndView("redirect:/products");
            }
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("redirect:/products");
        try {
            this.productRepository.deleteById(id);
            mv.addObject("message", "Seu produto foi excluído com sucesso!");
            mv.addObject("success", true);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            mv.addObject("message", "Não foi possível apagar o produto. Verifique e tente novamente.");
            mv.addObject("success", false);
        }

        return mv;
    }
}
