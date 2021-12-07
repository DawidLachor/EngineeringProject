package pl.skorpjdk.engineeringproject.bodyType;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperBodyType implements Mapper<BodyType, BodyTypeDto> {
    @Override
    public BodyTypeDto toDto(BodyType entity) {
        return new BodyTypeDto(entity.getId(), entity.getName());
    }

    @Override
    public BodyType toEntity(BodyTypeDto dto) {
        BodyType bodyType = new BodyType();
        bodyType.setId(dto.getId());
        bodyType.setName(dto.getName());
        return bodyType;
    }
}
