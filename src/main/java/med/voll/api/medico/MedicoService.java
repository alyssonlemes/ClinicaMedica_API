package med.voll.api.medico;

import med.voll.api.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.medico.dto.DadosCadastroMedico;
import med.voll.api.medico.dto.DadosListagemMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoService {
    Medico cadastrar(DadosCadastroMedico dados);
    Medico update(DadosAtualizacaoMedico dados);
    void excluir(Long id);
    Page<DadosListagemMedico> listar(Pageable paginacao);
    Medico buscarPorId(Long id);
}
