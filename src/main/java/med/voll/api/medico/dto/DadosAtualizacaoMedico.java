package med.voll.api.medico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
       @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
