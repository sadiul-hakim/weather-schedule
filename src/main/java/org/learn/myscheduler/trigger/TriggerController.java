package org.learn.myscheduler.trigger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trigger")
class TriggerController {
    private final TriggerService triggerService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Trigger trigger){
        Trigger save = triggerService.save(trigger);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        List<Trigger> all = triggerService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        Trigger trigger = triggerService.getById(id);
        return ResponseEntity.ok(trigger);
    }
}
