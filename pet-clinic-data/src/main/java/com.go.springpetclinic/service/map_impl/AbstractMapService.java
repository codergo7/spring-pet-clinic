package com.go.springpetclinic.service.map_impl;

import com.go.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

    public Collection<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(ID id){
        return map.get(id);
    }

   public T save(T object){
        if(object!= null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
        }
        else {
            throw new RuntimeException("Object can not be null");
        }

        map.put(object.getId(), object);
        return object;
    }

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T object){
        map.entrySet().removeIf(entry-> entry.getValue().equals(object));
    }

    private Long getNextId(){
        if(map.keySet().isEmpty()){
            return 1L;
        }
        return Collections.max(map.keySet()) + 1;
    }
}
