package br.com.ryannardelli.registerProduct.controllers;

import br.com.ryannardelli.registerProduct.Models.Provider;
import br.com.ryannardelli.registerProduct.Models.StatusProduct;
import br.com.ryannardelli.registerProduct.dto.RequestNewProvider;
import br.com.ryannardelli.registerProduct.repositories.ProviderRepository;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping("")
    public ModelAndView home(HttpServletRequest request) {
        List<Provider> providers = this.providerRepository.findAll();

        ModelAndView mv = new ModelAndView("provider/provider");
        mv.addObject("providers", providers);
        mv.addObject("currentPath", request.getServletPath());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView newProvider() {
        ModelAndView mv = new ModelAndView("provider/new");
        mv.addObject("requestNewProvider", new RequestNewProvider());
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView showProduct(@PathVariable long id) {
        Optional<Provider> optional = this.providerRepository.findById(id);

        if(optional.isPresent()) {
            Provider provider = optional.get();
            ModelAndView mv = new ModelAndView("provider/show");
            mv.addObject("provider", provider);
            return mv;
        } else {
            return new ModelAndView("redirect:/provider");
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getProduct(@PathVariable long id, RequestNewProvider requestNewProvider) {
        Optional <Provider> optional = this.providerRepository.findById(id);

        if(optional.isPresent()) {
            Provider provider = optional.get();
            requestNewProvider.fromProvider(provider);
            ModelAndView mv = new ModelAndView("provider/edit");
            mv.addObject("statusProduct", StatusProduct.values());
            mv.addObject("providerId", provider.getId());
            return mv;
        } else {
            return new ModelAndView("redirect:/provider");
        }
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable long id, @Valid RequestNewProvider requestNewProvider, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("provider/edit");
            return mv;
        } else {
            Optional <Provider> optional = this.providerRepository.findById(id);
            if(optional.isPresent()) {
                Provider provider = requestNewProvider.toProvider(optional.get());
                this.providerRepository.save(provider);
                ModelAndView modelAndView = new ModelAndView("redirect:/provider/" +provider.getId());
                modelAndView.addObject("message", "Seu Fornecedor foi editado com sucesso!");
                modelAndView.addObject("success", true);
                return modelAndView;
            } else {
                return new ModelAndView("redirect:/provider");
            }
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("redirect:/provider");
        try {
            this.providerRepository.deleteById(id);
            mv.addObject("message", "Seu fornecedor foi excluído com sucesso!");
            mv.addObject("success", true);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            mv.addObject("message", "Não foi possível apagar o fornecedor. Verifique e tente novamente.");
            mv.addObject("success", false);
        }

        return mv;
    }

    @PostMapping("")
    public ModelAndView create(@Valid RequestNewProvider requestNewProvider, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("provider/new");
            return mv;
        } else {
            Provider provider = requestNewProvider.toProvider();
            this.providerRepository.save(provider);

            ModelAndView modelAndView = new ModelAndView("redirect:/provider");
            modelAndView.addObject("message", "Seu Fornecedor foi criado com sucesso!");
            modelAndView.addObject("success", true);

            return modelAndView;
        }
    }
}
