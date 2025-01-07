package com.br.apimoney.resource;

import com.br.apimoney.model.Categoria;
import com.br.apimoney.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping
    public List<Categoria> categorias(){
        return categoriaRepository.findAll();
    }
}
