package pl.skorpjdk.engineeringproject.equipment;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperEquipment implements Mapper<Equipment, EquipmentDto> {
    @Override
    public EquipmentDto toDto(Equipment entity) {
        EquipmentDto equipmentDto = new EquipmentDto();
        equipmentDto.setId(entity.getId());
        equipmentDto.setName(entity.getName());
        return equipmentDto;
    }

    @Override
    public Equipment toEntity(EquipmentDto dto) {
        Equipment equipment = new Equipment();
        equipment.setId(dto.getId());
        equipment.setName(dto.getName());
        return equipment;
    }
}
