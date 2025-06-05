package com.gestao.gestaoequipamentos.controllers;

import com.gestao.gestaoequipamentos.entities.Equipamento;
import com.gestao.gestaoequipamentos.entities.dto.EquipamentoDTO;
import com.gestao.gestaoequipamentos.service.EquipamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipamentos")
@Tag(name = "Equipamentos", description = "Endpoints para gerenciamento de equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @Operation(summary = "Cadastra um novo equipamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Violação na regra de negocio, eja existe um equipamento cadastrado com essa Service tag")
    })
    @PostMapping
    public ResponseEntity<Equipamento> salve(@RequestBody Equipamento equipamento) {
        Equipamento entity = equipamentoService.salve(equipamento);
        return  ResponseEntity.ok().body(entity);
    }

    @Operation(summary = "Lista todos os equipamentos")
    @ApiResponse(responseCode = "200", description = "Lista de equipamentos retornada com sucesso")
    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> findAll() {
        List<EquipamentoDTO> list = equipamentoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Busca equipamento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @GetMapping(value = {"/id/{id}"})
    public ResponseEntity<EquipamentoDTO> findById(@PathVariable Long id) {
        Equipamento equipamento = equipamentoService.findById(id);
        EquipamentoDTO dto = new EquipamentoDTO(equipamento);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(summary = "Atualiza dados de um equipamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> update(@PathVariable Long id, @RequestBody EquipamentoDTO dto) {
        Equipamento equipamentoAtualizado = equipamentoService.update(id, dto);
        return ResponseEntity.ok(new EquipamentoDTO(equipamentoAtualizado));
    }

    @Operation(summary = "Busca equipamentos por número de contrato de leasing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamentos encontrados"),
            @ApiResponse(responseCode = "204", description = "Nenhum equipamento encontrado")
    })
    @GetMapping("/leasing/{contratoLeasing}")
    public ResponseEntity<List<EquipamentoDTO>> findByLeasing(@PathVariable Long contratoLeasing) {
        List<Equipamento> equipamentos = equipamentoService.findByContratoLeasing(contratoLeasing);
        List<EquipamentoDTO> dtoList = equipamentos.stream().map(EquipamentoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @Operation(summary = "Busca equipamento por Service Tag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @GetMapping(value = {"/servicetag/{servicetag}"})
    public ResponseEntity<EquipamentoDTO> findByServicetag(@PathVariable String servicetag) {
        Equipamento equipamento = equipamentoService.findByServicetag(servicetag);
        EquipamentoDTO dto = new EquipamentoDTO(equipamento);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(summary = "Remove um equipamento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Equipamento removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        equipamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
