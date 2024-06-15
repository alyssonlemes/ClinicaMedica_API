package med.voll.api.medico;

import med.voll.api.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.medico.dto.DadosCadastroMedico;
import med.voll.api.medico.dto.DadosListagemMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    @Transactional
    public Medico cadastrar(DadosCadastroMedico dados) {
        Medico medico = new Medico(dados);
        return medicoRepository.save(medico);
    }

    @Override
    @Transactional
    public Medico update(DadosAtualizacaoMedico dados) {
        Medico medico = medicoRepository.findById(dados.id())
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o id: " + dados.id()));

        if (dados.nome() != null) {
            medico.setNome(dados.nome());
        }
        if (dados.telefone() != null) {
            medico.setTelefone(dados.telefone());
        }
        if (dados.endereco() != null) {
            medico.getEndereco().atualizarInformacoes(dados.endereco());
        }

        return medicoRepository.save(medico);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o id: " + id));
        medico.setAtivo(false);
        medicoRepository.save(medico);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o id: " + id));
    }
}
