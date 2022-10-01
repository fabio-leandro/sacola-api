package me.dio.sacola.resource;


import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class SacolaResource {

    private final SacolaService sacolaService;

    @PostMapping
    public ResponseEntity<Item>  incluirItemSacola(ItemDto itemDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(sacolaService.incluirItemSacola(itemDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sacola> verSacola(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(sacolaService.verSacola(id));
    }

    @PutMapping("/fecharSacola/{sacolaId}")
    public ResponseEntity<Sacola> fecharSacola(@PathVariable("sacolaId") Long sacolaId,
                               @RequestParam("formaPagamento") int formaPagamento){
        return ResponseEntity.status(HttpStatus.OK).body(sacolaService.fecharSacola(sacolaId,formaPagamento));
    }
}
