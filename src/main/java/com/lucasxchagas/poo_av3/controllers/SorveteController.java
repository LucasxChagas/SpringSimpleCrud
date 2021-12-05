package com.lucasxchagas.poo_av3.controllers;

import com.lucasxchagas.poo_av3.models.fornecedor.Fornecedor;
import com.lucasxchagas.poo_av3.models.fornecedor.FornecedorService;
import com.lucasxchagas.poo_av3.models.sorvete.Sorvete;
import com.lucasxchagas.poo_av3.models.sorvete.SorveteNotFoundException;
import com.lucasxchagas.poo_av3.models.sorvete.SorveteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SorveteController {

    @Autowired private SorveteService sService;
    @Autowired private FornecedorService fService;

    @GetMapping("/novo-sorvete")
    public String novoSorvete(Model model)
    {
        List<Fornecedor> listFornecedor = fService.listFornecedores();

        model.addAttribute("sorvete", new Sorvete());
        model.addAttribute("pageTitle", "Novo Sorvete");
        model.addAttribute("listFornecedor", listFornecedor);
        return "sorvete";
    }

    @PostMapping("novo-sorvete/salvar")
    public String salvarSorvete(Sorvete sorvete, RedirectAttributes ra)
    {
        sService.save(sorvete);
        ra.addFlashAttribute("message", "O sorvete foi cadastrado com sucesso.");
        return "redirect:/success";
    }

    @GetMapping("editar-sorvete/{id}")
    public String editarSorvete(@PathVariable("id") Integer id, Model model, RedirectAttributes ra)
    {
        try {
            List<Fornecedor> listFornecedor = fService.listFornecedores();
            model.addAttribute("listFornecedor", listFornecedor);

            Sorvete sorvete = sService.get(id);
            model.addAttribute("sorvete", sorvete);
            model.addAttribute("pageTitle", "Editar Sorvete (ID: " + id + ")");
            return "sorvete";
        } catch (SorveteNotFoundException e) {
            ra.addFlashAttribute("message", "Não foi encontrado nenhum sorvete com esse id.");
            return "redirect:/failure";
        }
    }

}
