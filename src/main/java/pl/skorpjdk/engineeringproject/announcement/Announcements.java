package pl.skorpjdk.engineeringproject.announcement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Announcements {
    private Long bodyType;
    private Long gas;
    private Long mark;
    private Long model;
    private Long generation;
    private Long priceFrom;
    private Long priceTo;
    private Long mileageFrom;
    private Long mileageTo;
    private Long yearFrom;
    private Long yearTo;
    private String location;
    private Long powerFrom;
    private Long powerTo;
    private Long capacityFrom;
    private Long capacityTo;
    private Long transmission;
    private Long seats;
    private Long doors;
    private String imageUrl;
}
