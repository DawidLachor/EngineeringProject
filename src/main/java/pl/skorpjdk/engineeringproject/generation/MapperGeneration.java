package pl.skorpjdk.engineeringproject.generation;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperGeneration implements Mapper<Generation, GenerationDto> {
    @Override
    public GenerationDto toDto(Generation entity) {
        GenerationDto generationDto = new GenerationDto();
        generationDto.setId(entity.getId());
        generationDto.setName(entity.getName());
        generationDto.setStartProduction(entity.getStartProduction());
        generationDto.setEndProduction(entity.getEndProduction());
        return generationDto;
    }

    @Override
    public Generation toEntity(GenerationDto dto) {
        Generation generation = new Generation();
        generation.setId(dto.getId());
        generation.setName(dto.getName());
        generation.setStartProduction(dto.getStartProduction());
        generation.setEndProduction(dto.getEndProduction());
        return generation;
    }
}
