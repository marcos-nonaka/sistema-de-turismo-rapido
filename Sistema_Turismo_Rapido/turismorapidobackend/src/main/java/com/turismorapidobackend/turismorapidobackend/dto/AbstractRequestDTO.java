package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import static com.turismorapidobackend.turismorapidobackend.utils.Utils.getNullPropertyNames;

@Data
@AllArgsConstructor
public abstract class AbstractRequestDTO {
    public Object toObject(Object object){
        BeanUtils.copyProperties(this, object, getNullPropertyNames(this));
        return object;
    }
}
