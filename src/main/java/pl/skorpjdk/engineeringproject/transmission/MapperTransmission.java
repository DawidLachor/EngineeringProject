package pl.skorpjdk.engineeringproject.transmission;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperTransmission implements Mapper<Transmission, TransmissionDto> {
    @Override
    public TransmissionDto toDto(Transmission entity) {
        TransmissionDto transmissionDto = new TransmissionDto();
        transmissionDto.setId(entity.getId());
        transmissionDto.setType(entity.getType());
        transmissionDto.setNumberOfGears(entity.getNumberOfGears());
        return transmissionDto;
    }

    @Override
    public Transmission toEntity(TransmissionDto dto) {
        Transmission transmission = new Transmission();
        transmission.setId(dto.getId());
        transmission.setNumberOfGears(dto.getNumberOfGears());
        transmission.setType(dto.getType());
        return transmission;
    }
}
