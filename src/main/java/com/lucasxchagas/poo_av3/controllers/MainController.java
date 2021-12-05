package com.lucasxchagas.poo_av3.controllers;

import com.lucasxchagas.poo_av3.models.fornecedor.Fornecedor;
import com.lucasxchagas.poo_av3.models.fornecedor.FornecedorService;
import com.lucasxchagas.poo_av3.models.sorvete.Sorvete;
import com.lucasxchagas.poo_av3.models.sorvete.SorveteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired private SorveteService sService;
    @Autowired private FornecedorService fService;

    @GetMapping("/")
    public String index(Model model)
    {
        List<Sorvete> listSorvete = sService.listSorvetes();
        List<Fornecedor> listFornecedor = fService.listFornecedores();

        model.addAttribute("listSorvete", listSorvete);
        model.addAttribute("listFornecedor", listFornecedor);
        return "index";
    }

    @GetMapping("/success")
    public String Success()
    {
        return "success";
    }

    @GetMapping("/failure")
    public String Failure()
    {
        return "failure";
    }
}
