package com.springboot.racingdemo.converter;

import com.springboot.racingdemo.dto.CarDTO;
import com.springboot.racingdemo.entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarConvertor {

    public CarDTO entityToDto(Car company)
    {
        ModelMapper mapper=new ModelMapper();
        CarDTO map=mapper.map(company,CarDTO.class);
        return map;
    }
    public Car dtoToEntity(CarDTO companyDTO)
    {
        ModelMapper mapper=new ModelMapper();
        Car map=mapper.map(companyDTO,Car.class);
        return map;
    }
    public List<CarDTO> entityToDto(List<Car> companies)
    {
        return  companies.stream().map(x->entityToDto(x)).collect(Collectors.toList());

    }
    public List<Car> dtoToEntity(List<CarDTO> companyDTOList){

        return companyDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
