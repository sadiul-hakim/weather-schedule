package org.learn.myscheduler.trigger;

import java.util.List;

import org.learn.myscheduler.exception.NotFounfException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TriggerService {
    private final TriggerRepository triggerRepository;
    public Trigger save(Trigger trigger){
        return triggerRepository.save(trigger);
    }

    public List<Trigger> getAll(){
        return triggerRepository.findAll();
    }

    public Trigger getById(long id) throws NotFounfException{
        return triggerRepository.findById(id)
        .orElseThrow(()-> new NotFounfException("Trigger not found with id"+id));
    }
}
