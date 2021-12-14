package pl.skorpjdk.engineeringproject.announcement;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperAnnouncement implements Mapper<Announcement, AnnouncementDto> {
    @Override
    public AnnouncementDto toDto(Announcement entity) {
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setId(entity.getId());
        announcementDto.setCreated(entity.getCreated());
        announcementDto.setDescription(entity.getDescription());
        announcementDto.setLocation(entity.getLocation());
        announcementDto.setPrice(entity.getPrice());
        announcementDto.setTitle(entity.getTitle());
        announcementDto.setType(entity.getType());
        return announcementDto;
    }

    @Override
    public Announcement toEntity(AnnouncementDto dto) {
        Announcement announcement = new Announcement();
        announcement.setId(dto.getId());
        announcement.setCreated(dto.getCreated());
        announcement.setDescription(dto.getDescription());
        announcement.setLocation(dto.getLocation());
        announcement.setPrice(dto.getPrice());
        announcement.setTitle(dto.getTitle());
        announcement.setType(dto.getType());
        return announcement;
    }
}
