package org.learn.myscheduler.trigger;

import org.springframework.data.jpa.repository.JpaRepository;

interface TriggerRepository extends JpaRepository<Trigger, Long>{
    
}
