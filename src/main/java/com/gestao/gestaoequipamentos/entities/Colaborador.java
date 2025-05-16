package com.gestao.gestaoequipamentos.entities;
import com.gestao.gestaoequipamentos.entities.Enums.SistemaOperacional;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_colaborador")
public class Colaborador extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome de usuário não pode estar em branco")
    @Size(min = 3, max = 50, message = "O nome de usuário deve ter entre 3 e 50 caracteres")
    private String userName;


    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
    private String password;

    @Enumerated(EnumType.STRING)
    private SistemaOperacional sistemaOperacional;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Equipamento> equipamentos = new ArrayList<>();

    public Colaborador() {
        super();
    }

    public Colaborador(String nome, LocalDate dataInicio, long id, String userName, String password, SistemaOperacional sistemaOperacional) {
        super(nome, dataInicio);
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.sistemaOperacional = sistemaOperacional;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
}
