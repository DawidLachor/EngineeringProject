package pl.skorpjdk.engineeringproject.engine;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperEngine implements Mapper<Engine, EngineDto> {
    @Override
    public EngineDto toDto(Engine entity) {
        EngineDto engineDto = new EngineDto();
        engineDto.setId(engineDto.getId());
        engineDto.setPower(entity.getPower());
        engineDto.setCapacity(entity.getCapacity());
        return engineDto;
    }

    @Override
    public Engine toEntity(EngineDto dto) {
        Engine engine = new Engine();
        engine.setId(dto.getId());
        engine.setPower(dto.getPower());
        engine.setCapacity(dto.getCapacity());
        return engine;
    }
}
