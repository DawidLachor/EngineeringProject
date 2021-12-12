package pl.skorpjdk.engineeringproject.model;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperModel implements Mapper<Model, ModelDto> {
    @Override
    public ModelDto toDto(Model entity) {
        return new ModelDto(entity.getId(), entity.getName());
    }

    @Override
    public Model toEntity(ModelDto dto) {
        Model model = new Model();
        model.setId(dto.getId());
        model.setName(dto.getName());
        return model;
    }
}
