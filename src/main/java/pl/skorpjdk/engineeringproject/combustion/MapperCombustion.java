package pl.skorpjdk.engineeringproject.combustion;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperCombustion implements Mapper<Combustion, CombustionDto> {
    @Override
    public CombustionDto toDto(Combustion entity) {
        CombustionDto result = new CombustionDto();
        result.setId(entity.getId());
        result.setCity(entity.getCity());
        result.setMixed(entity.getMixed());
        result.setOutOfTower(entity.getOutOfTower());
        return result;
    }

    @Override
    public Combustion toEntity(CombustionDto dto) {
        Combustion result = new Combustion();
        result.setId(dto.getId());
        result.setCity(dto.getCity());
        result.setMixed(dto.getMixed());
        result.setOutOfTower(dto.getOutOfTower());
        return result;
    }
}
