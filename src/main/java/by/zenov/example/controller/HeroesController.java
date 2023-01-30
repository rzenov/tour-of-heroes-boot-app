package by.zenov.example.controller;

import by.zenov.example.model.HeroEntity;
import by.zenov.example.repository.HeroesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static by.zenov.example.ServiceUtil.entityNotFoundMessage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroes")
public class HeroesController {
    private final HeroesRepository heroesRepository;

    @GetMapping
    public ResponseEntity<List<HeroEntity>> getAllHeroes() {
        return ResponseEntity.ok(heroesRepository.findAll());
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<HeroEntity> get(@PathVariable String heroId) {
        HeroEntity hero = heroesRepository.findById(heroId)
                .orElseThrow(() -> new IllegalArgumentException(entityNotFoundMessage("Hero", heroId)));
        return ResponseEntity.ok(hero);
    }

    @PostMapping
    public ResponseEntity<HeroEntity> create(@RequestBody HeroEntity heroEntity) {
        return ResponseEntity.ok(heroesRepository.save(heroEntity));
    }

    @PutMapping
    public ResponseEntity<HeroEntity> update(@RequestBody HeroEntity heroEntity) {
        return ResponseEntity.ok(heroesRepository.save(heroEntity));
    }

    @DeleteMapping("/{heroId}")
    public ResponseEntity<HeroEntity> delete(@PathVariable String heroId) {
        heroesRepository.deleteById(heroId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
