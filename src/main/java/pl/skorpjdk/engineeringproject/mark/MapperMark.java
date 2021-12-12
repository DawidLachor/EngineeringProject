package pl.skorpjdk.engineeringproject.mark;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperMark implements Mapper<Mark, MarkDto> {
    @Override
    public MarkDto toDto(Mark entity) {
        return new MarkDto(entity.getId(), entity.getName());
    }

    @Override
    public Mark toEntity(MarkDto dto) {
        Mark mark = new Mark();
        mark.setId(dto.getId());
        mark.setName(dto.getName());
        return mark;
    }
}
