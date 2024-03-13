package br.com.fiap.springpjchamadostecnicos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_CHAMADO")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SOLICITANTE")
    @SequenceGenerator(
            name = "SQ_CHAMADO",
            sequenceName = "SQ_CHAMADO",
            allocationSize = 1
    )
    @Column(name = "ID_CHAMADO")
    private Long id;

    @Column(name = "NM_CHAMADO")

    private String titulo;

    private String descricao;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataPrimeiroAtendimento;

    private LocalDateTime dataEncerramento;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "SOLICITANTE",
            referencedColumnName = "ID_SOLICITANTE",
            foreignKey = @ForeignKey(
                    name = "FK_SOLICITANTE_CHAMADO"
            )
    )
    private Solicitante solicitante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "TECNICO",
            referencedColumnName = "ID_TECNICO",
            foreignKey = @ForeignKey(
                    name = "FK_TECNICO_CHAMADO"
            )
    )
    private Tecnico tecnico;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ESPECIALIDADE",
            referencedColumnName = "ID_ESPECIALIDADE",
            foreignKey = @ForeignKey(
                    name = "FK_ESPECIALIDADE_CHAMADO"
            )
    )
    private Especialidade especialidade;

}
