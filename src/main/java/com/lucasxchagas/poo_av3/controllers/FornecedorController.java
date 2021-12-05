package com.lucasxchagas.poo_av3.controllers;

import com.lucasxchagas.poo_av3.models.fornecedor.Fornecedor;
import com.lucasxchagas.poo_av3.models.fornecedor.FornecedorNotFoundException;
import com.lucasxchagas.poo_av3.models.fornecedor.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FornecedorController {

    @Autowired
    private FornecedorService fService;

    @GetMapping("/novo-fornecedor")
    public String novoFornecedor(Model model)
    {
        model.addAttribute("fornecedor", new Fornecedor());
        model.addAttribute("pageTitle", "Novo Fornecedor");
        return "fornecedor";
    }

    @PostMapping("novo-fornecedor/salvar")
    public String salvarFornecedor(Fornecedor fornecedor, RedirectAttributes ra)
    {
        fService.save(fornecedor);
        ra.addFlashAttribute("message", "O fornecedor foi cadastrado com sucesso.");
        return "redirect:/success";
    }

    @GetMapping("editar-fornecedor/{id}")
    public String editarFornecedor(@PathVariable("id") Integer id, Model model, RedirectAttributes ra)
    {
        try {
            Fornecedor fornecedor = fService.get(id);
            model.addAttribute("fornecedor", fornecedor);
            model.addAttribute("pageTitle", "Editar Fornecedor (ID: " + id + ")");
            return "fornecedor";
        } catch (FornecedorNotFoundException e) {
            ra.addFlashAttribute("message", "Não foi encontrado nenhum fornecedor com esse id.");
            return "redirect:/failure";
        }
    }

    @GetMapping("deletar-fornecedor/{id}")
    public String deletarFornecedor(@PathVariable("id") Integer id, RedirectAttributes ra)
    {
        try {
            fService.delete(id);
            ra.addFlashAttribute("message", "Fornecedor deletado com sucesso..");
            return "redirect:/success";
        } catch (FornecedorNotFoundException e) {
            ra.addFlashAttribute("message", "Não foi encontrado nenhum fornecedor com esse id.");
            return "redirect:/failure";
        }
    }





}

