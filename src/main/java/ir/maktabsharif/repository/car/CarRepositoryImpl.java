package ir.maktabsharif.repository.car;

import ir.maktabsharif.model.Car;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class CarRepositoryImpl extends BaseRepositoryImpl<Car,Integer> implements CarRepository {

    public CarRepositoryImpl() {
        super(Car.class);
    }
}
