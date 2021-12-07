package pl.skorpjdk.engineeringproject.typeEngine;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperTypeEngine implements Mapper<TypeEngine, TypeEngineDto> {


    public TypeEngineDto toDto(TypeEngine typeEngine){
        return new TypeEngineDto(typeEngine.getId(), typeEngine.getName());
    }

    public  TypeEngine toEntity(TypeEngineDto typeEngineDto){
        TypeEngine typeEngine = new TypeEngine();
        typeEngine.setId(typeEngineDto.getId());
        typeEngine.setName(typeEngineDto.getName());
        return typeEngine;
    }
}
