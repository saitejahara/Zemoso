package com.springboot.racingdemo;



import com.springboot.racingdemo.dao.CarRepository;
import com.springboot.racingdemo.entity.Car;
import com.springboot.racingdemo.service.CarService;
import com.springboot.racingdemo.service.CarServiceImpl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={com.springboot.racingdemo.RacingApplication.class})
class RacingApplicationTests {

	@Test
	void contextLoads() {
	}
	private CarService carService;


	@Mock
	private CarRepository carRepository;



	@BeforeEach
	void initUseCase(){
		carService=new CarServiceImpl(carRepository);
	}

	@Test
	void findByIdMocked()
	{

		Car car = new Car("carName1","modelYear1", "fuelType1", "intakeType1", "power1", "torque1");
		when(carRepository.findById(1)).thenReturn(java.util.Optional.of(car));
		assertEquals(car, carService.findById(1));
		Mockito.verify(carRepository).findById(1);
	}


	@Test
	void getCar()
	{
		when(carRepository.findAll()).thenReturn(Stream.of(
				new Car("carName2","modelYear2", "fuelType2", "intakeType2", "power2", "torque2"),
				new Car("carName3","modelYear3", "fuelType3", "intakeType3", "power3", "torque3"))
				.collect(Collectors.toList()));
		assertEquals(2,carService.findAllMock().size());
	}
}