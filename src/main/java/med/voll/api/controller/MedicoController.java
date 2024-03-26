package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        repository.save(new Medico(dados)); //salva no banco de dados os dados do cadastro do médico através da classe repository
    }

    @GetMapping
    public Page<DadosListagemMedico> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new); //retorna uma page com as informações da listagem de medicos
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id()); //carrega a variavel medico pelo id do banco de dados
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}") //exemplo de parametro dinamico que chegará através da url na requisição
    @Transactional
    public void excluir(@PathVariable Long id){ //o PathVariable avisa que o parÂmetro long id vem do parametro dinamico definido anteriormente
        var medico = repository.getReferenceById(id); //carrega a variavel medico pelo id do banco de dados
        medico.excluir();
    }
}
