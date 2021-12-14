package pl.skorpjdk.engineeringproject.car;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperCar implements Mapper<Car, CarDto> {

    @Override
    public CarDto toDto(Car entity) {
        CarDto result = new CarDto();
        result.setId(entity.getId());
        result.setColor(entity.getColor());
        result.setMileage(entity.getMileage());
        result.setNeverCrashed(entity.getNeverCrashed());
        result.setRegistration(entity.getRegistration());
        result.setNumberOfDoor(entity.getNumberOfDoor());
        result.setRegistration(entity.getRegistration());
        result.setProductionDate(entity.getProductionDate());
        result.setNumberOfSeats(entity.getNumberOfSeats());
        result.setRegisteredInPoland(entity.getRegisteredInPoland());
        return result;
    }

    @Override
    public Car toEntity(CarDto entity) {
        Car result = new Car();
        result.setId(entity.getId());
        result.setColor(entity.getColor());
        result.setMileage(entity.getMileage());
        result.setNeverCrashed(entity.getNeverCrashed());
        result.setRegistration(entity.getRegistration());
        result.setNumberOfDoor(entity.getNumberOfDoor());
        result.setRegistration(entity.getRegistration());
        result.setProductionDate(entity.getProductionDate());
        result.setNumberOfSeats(entity.getNumberOfSeats());
        result.setRegisteredInPoland(entity.getRegisteredInPoland());
        return result;
    }
}
