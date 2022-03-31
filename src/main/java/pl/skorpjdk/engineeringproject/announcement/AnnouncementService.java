package pl.skorpjdk.engineeringproject.announcement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.skorpjdk.engineeringproject.account.Account;
import pl.skorpjdk.engineeringproject.account.AccountService;
import pl.skorpjdk.engineeringproject.bodyType.BodyType;
import pl.skorpjdk.engineeringproject.bodyType.BodyTypeService;
import pl.skorpjdk.engineeringproject.car.Car;
import pl.skorpjdk.engineeringproject.car.CarService;
import pl.skorpjdk.engineeringproject.generation.Generation;
import pl.skorpjdk.engineeringproject.generation.GenerationService;
import pl.skorpjdk.engineeringproject.image.CarImage;
import pl.skorpjdk.engineeringproject.image.CarImageRepository;
import pl.skorpjdk.engineeringproject.mark.Mark;
import pl.skorpjdk.engineeringproject.mark.MarkService;
import pl.skorpjdk.engineeringproject.model.Model;
import pl.skorpjdk.engineeringproject.model.ModelService;
import pl.skorpjdk.engineeringproject.transmission.Transmission;
import pl.skorpjdk.engineeringproject.transmission.TransmissionService;
import pl.skorpjdk.engineeringproject.typeEngine.TypeEngine;
import pl.skorpjdk.engineeringproject.typeEngine.TypeEngineService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AccountService accountService;
    private final CarService carService;
    private final BodyTypeService bodyTypeService;
    private final MarkService markService;
    private final ModelService modelService;
    private final TransmissionService transmissionService;
    private final TypeEngineService typeEngineService;
    private final EntityManager entityManager;
    private final GenerationService generationService;
    private final CarImageRepository carImageRepository;
    private final StringBuilder queryFrom = new StringBuilder("from Announcement as ann\n" +
            "         inner join Car c on c = ann.car\n" +
            "         inner join TypeEngine te on c.typeEngine = te\n" +
            "         inner join Mark m on c.mark = m\n" +
            "         inner join Model m2 on c.model = m2\n" +
            "         inner join BodyType bt on bt = c.bodyTypes\n" +
            "         inner join Transmission t on t = c.transmission\n" +
            "         inner join Generation g on c.generation = g\n");
    private final StringBuilder queryWhere = new StringBuilder(" WHERE ann.active = true and ann.delete = false ");

    public List<AnnouncementDto> getAnnouncements(Announcements announcements) {

        StringBuilder query = new StringBuilder("Select NEW pl.skorpjdk.engineeringproject.announcement.AnnouncementDto(ann.id,ann.title,m.name,m2.name,c.productionDate,c.mileage,c.capacity,c.power,te.name,ann.location,ann.price)\n");
        query.append(queryFrom);
        query.append(queryWhere);
        buildQuery(announcements, query);

        TypedQuery<AnnouncementDto> query1 = entityManager.createQuery(query.toString(), AnnouncementDto.class);
        List<AnnouncementDto> resultList = query1.getResultList();

        for (AnnouncementDto announcement: resultList){
            Announcement byId = announcementRepository.findById(announcement.getId()).get();
            CarImage carImage = carImageRepository.findByAnnouncement(byId).get().get(0);
            announcement.setImageUrl(carImage.getUrl());
        }
        return resultList;
    }

    public List<AnnouncementDto> getAllAnnouncements() {

        TypedQuery<AnnouncementDto> query1 = entityManager.createQuery("Select NEW pl.skorpjdk.engineeringproject.announcement.AnnouncementDto(ann.id,ann.title,m.name,m2.name,c.productionDate,c.mileage,c.capacity,c.power,te.name,ann.location,ann.price)\n" + queryFrom + queryWhere, AnnouncementDto.class);
        return addImages(query1);
    }

    private void buildQuery(Announcements announcements, StringBuilder query) {
        if (announcements.getBodyType() != null) {
            query.append("AND bt.id = " + announcements.getBodyType() + " ");
        }
        if (announcements.getGas() != null) {
            query.append("AND te.id = " + announcements.getGas() + " ");
        }
        if (announcements.getMark() != null) {
            query.append("AND m.id = " + announcements.getMark() + " ");
        }
        if (announcements.getModel() != null) {
            query.append("AND m2.id = " + announcements.getModel() + " ");
        }
        if (announcements.getGeneration() != null) {
            query.append("AND g.id = " + announcements.getGeneration() + " ");
        }
        if (announcements.getPriceFrom() != null) {
            query.append("AND ann.price >= " + announcements.getPriceFrom() + " ");
        }
        if (announcements.getPriceTo() != null) {
            query.append("AND ann.price <= " + announcements.getPriceTo() + " ");
        }
        if (announcements.getMileageFrom() != null) {
            query.append("AND c.mileage >= " + announcements.getMileageFrom() + " ");
        }
        if (announcements.getMileageTo() != null) {
            query.append("AND c.mileage <= " + announcements.getMileageTo() + " ");
        }
        if (announcements.getYearFrom() != null) {
            query.append("AND c.mileage >= " + announcements.getYearFrom() + "-01-01 ");
        }
        if (announcements.getYearTo() != null) {
            query.append("AND c.mileage <= " + announcements.getYearTo() + "-12-31 ");
        }
        if (announcements.getLocation() != null && !announcements.getLocation().equals("")) {
            query.append("AND ann.location LIKE '" + announcements.getLocation() + "' ");
        }
        if (announcements.getPowerFrom() != null) {
            query.append("AND c.power >= " + announcements.getPowerFrom() + " ");
        }
        if (announcements.getPowerTo() != null) {
            query.append("AND c.power <= " + announcements.getPowerTo() + " ");
        }
        if (announcements.getCapacityFrom() != null) {
            query.append("AND c.capacity >= " + announcements.getCapacityFrom() + " ");
        }
        if (announcements.getCapacityTo() != null) {
            query.append("AND c.capacity <= " + announcements.getCapacityTo() + " ");
        }
        if (announcements.getTransmission() != null) {
            query.append("AND t.id = " + announcements.getTransmission() + " ");
        }
        if (announcements.getSeats() != null) {
            query.append("AND c.numberOfSeats = " + announcements.getSeats() + " ");
        }
        if (announcements.getDoors() != null) {
            query.append("AND c.numberOfDoor = " + announcements.getDoors() + " ");
        }
    }

    public OneAnnouncement getAnnouncement(Long id) {
        StringBuilder query = new StringBuilder("Select NEW pl.skorpjdk.engineeringproject.announcement." +
                "OneAnnouncement(ann.title,ann.price," +
                "m.name,m2.name,c.productionDate,c.mileage,c.capacity,c.power,te.name," +
                "t.type,c.neverCrashed,bt.name,c.numberOfDoor,c.numberOfSeats,c.color," +
                "c.registration,c.firstRegistration,c.vin,ann.description,ann.location,ann.phone)\n");
        query.append(queryFrom);
        query.append("WHERE ann.id = ").append(id);
        TypedQuery<OneAnnouncement> query1 = entityManager.createQuery(query.toString(), OneAnnouncement.class);
        return query1.getResultList().get(0);
    }

    public Long saveAnnouncements(AnnouncementSave announcementSave) {
        Car car = getCar(announcementSave);
        Car saveCar = carService.saveCar(car);
        System.out.println("CAR: " + saveCar.getId());
        Announcement announcement = getAnnouncement(announcementSave, saveCar);
        Announcement save = announcementRepository.save(announcement);
        System.out.println("Announcement: " + save.getId());
        return save.getId();
    }

    private Announcement getAnnouncement(AnnouncementSave announcementSave, Car car) {
        Announcement announcement = new Announcement();
        announcement.setActive(true);
        announcement.setCreated(LocalDateTime.now());
        announcement.setDelete(false);
        announcement.setDescription(announcementSave.getDescribe());
        announcement.setLocation(announcementSave.getLocation());
        announcement.setPrice(announcementSave.getPrice());
        announcement.setTitle(announcementSave.getTitle());
        announcement.setCar(car);
        announcement.setAccount(accountService.getCurrentAccount());
        announcement.setPhone(announcement.getPhone());
        return announcement;
    }

    private Announcement getAnnouncement(AnnouncementEdit announcementSave, Car car) {
        Announcement announcement = new Announcement();
        announcement.setActive(true);
        announcement.setCreated(LocalDateTime.now());
        announcement.setDelete(false);
        announcement.setDescription(announcementSave.getDescribe());
        announcement.setLocation(announcementSave.getLocation());
        announcement.setPrice(announcementSave.getPrice());
        announcement.setTitle(announcementSave.getTitle());
        announcement.setCar(car);
        announcement.setAccount(accountService.getCurrentAccount());
        announcement.setPhone(announcement.getPhone());
        return announcement;
    }

    private Car getCar(AnnouncementSave announcementSave) {
        Car car = new Car();
        car.setColor(announcementSave.getColor());
        car.setMileage(announcementSave.getMileage());
        car.setNeverCrashed(announcementSave.getCrash());
        car.setNumberOfDoor(announcementSave.getDoors());
        car.setNumberOfSeats(announcementSave.getSeats());
        LocalDate production = LocalDate.parse(announcementSave.getYear_of_production());
        car.setProductionDate(production);
        LocalDate registration = LocalDate.parse(announcementSave.getFirst_registration());
        car.setFirstRegistration(registration);
        car.setRegistration(announcementSave.getRegistration_number());
        car.setRegisteredFrom(announcementSave.getCountry_of_production());
        car.setVin(announcementSave.getVin());
        car.setPower(announcementSave.getPower());
        car.setCapacity(announcementSave.getCapacity());
        BodyType bodyType = bodyTypeService.getBodyType(announcementSave.getBodyType());
        car.setBodyTypes(bodyType);
        Mark mark = markService.getMark(announcementSave.getBrand());
        car.setMark(mark);
        Model model = modelService.getModel(announcementSave.getModel());
        car.setModel(model);
        Transmission transmission = transmissionService.getTransmission(announcementSave.getTransmission());
        car.setTransmission(transmission);
        TypeEngine typeEngine = typeEngineService.getTypeEngine(announcementSave.getGas());
        car.setTypeEngine(typeEngine);
        Generation generation = generationService.getGeneration(announcementSave.getGeneration());
        car.setGeneration(generation);

        return car;
    }

    private Car getCar(AnnouncementEdit announcementSave) {
        Car car = new Car();
        car.setColor(announcementSave.getColor());
        car.setMileage(announcementSave.getMileage());
        car.setNeverCrashed(announcementSave.getCrash());
        car.setNumberOfDoor(announcementSave.getDoors());
        car.setNumberOfSeats(announcementSave.getSeats());
        LocalDate production = LocalDate.parse(announcementSave.getYear_of_production());
        car.setProductionDate(production);
        LocalDate registration = LocalDate.parse(announcementSave.getFirst_registration());
        car.setFirstRegistration(registration);
        car.setRegistration(announcementSave.getRegistration_number());
        car.setRegisteredFrom(announcementSave.getCountry_of_production());
        car.setVin(announcementSave.getVin());
        car.setPower(announcementSave.getPower());
        car.setCapacity(announcementSave.getCapacity());
        BodyType bodyType = bodyTypeService.getBodyType(announcementSave.getBodyType());
        car.setBodyTypes(bodyType);
        Mark mark = markService.getMark(announcementSave.getBrand());
        car.setMark(mark);
        Model model = modelService.getModel(announcementSave.getModel());
        car.setModel(model);
        Transmission transmission = transmissionService.getTransmission(announcementSave.getTransmission());
        car.setTransmission(transmission);
        TypeEngine typeEngine = typeEngineService.getTypeEngine(announcementSave.getGas());
        car.setTypeEngine(typeEngine);
        Generation generation = generationService.getGeneration(announcementSave.getGeneration());
        car.setGeneration(generation);

        return car;
    }

    public Announcement getAnnouncementEntity(Long id) {
        Optional<Announcement> byId = announcementRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new IllegalArgumentException("The Announcement with such id doesn't exist");
        }
    }

    public List<AnnouncementDto> getAllMyAnnouncements() {
        Account currentAccount = accountService.getCurrentAccount();
        String queryWhere = "inner join Account a on a.id = ann.account\n" +
                "WHERE ann.delete = false and a.id =" + currentAccount.getId();
        TypedQuery<AnnouncementDto> query1 = entityManager.createQuery("Select NEW pl.skorpjdk.engineeringproject.announcement.AnnouncementDto(ann.id,ann.title,m.name,m2.name,c.productionDate,c.mileage,c.capacity,c.power,te.name,ann.location,ann.price)\n" + queryFrom + queryWhere, AnnouncementDto.class);
        return addImages(query1);
    }

    private List<AnnouncementDto> addImages(TypedQuery<AnnouncementDto> query1) {
        List<AnnouncementDto> resultList = query1.getResultList();
        for (AnnouncementDto announcement: resultList){
            Announcement byId = getAnnouncementEntity(announcement.getId());
            CarImage carImage = carImageRepository.findByAnnouncement(byId).get().get(0);
            announcement.setImageUrl(carImage.getUrl());
        }
        return resultList;
    }

    public void deleteMyAnnouncements(Long id) {
        announcementRepository.findById(id).ifPresent(announcement -> {
                    announcement.setDelete(true);
                    announcementRepository.save(announcement);
                }
        );
    }

    public AnnouncementEdit editGetMyAnnouncements(Long id) {
        Announcement announcement = announcementRepository.findById(id).get();
        Car car = announcement.getCar();
        BodyType bodyTypes = car.getBodyTypes();
        Mark mark = car.getMark();
        Model model = car.getModel();
        Generation generation = car.getGeneration();
        TypeEngine typeEngine = car.getTypeEngine();
        Transmission transmission = car.getTransmission();

        AnnouncementEdit build = AnnouncementEdit.builder()
                .id(announcement.getId())
                .idCar(car.getId())
                .bodyType(bodyTypes.getId())
                .brand(mark.getId())
                .model(model.getId())
                .generation(generation.getId())
                .capacity(car.getCapacity())
                .color(car.getColor())
                .country_of_production(car.getRegisteredFrom())
                .crash(car.getNeverCrashed())
                .describe(announcement.getDescription())
                .doors(car.getNumberOfDoor())
                .first_registration(car.getFirstRegistration().toString())
                .gas(typeEngine.getId())
                .location(announcement.getLocation())
                .mileage(car.getMileage())
                .phone(announcement.getPhone())
                .power(car.getPower())
                .price(announcement.getPrice())
                .registration_number(car.getRegistration())
                .seats(car.getNumberOfSeats())
                .title(announcement.getTitle())
                .transmission(transmission.getId())
                .vin(car.getVin())
                .year_of_production(car.getProductionDate().toString())
                .build();
        return build;
    }

    public void editMyAnnouncements(AnnouncementEdit announcement) {
        Car car = getCar(announcement);
        Car carEntity = carService.getCar(announcement.getIdCar());
        car.setId(carEntity.getId());
        Car saveCar = carService.saveCar(car);
        System.out.println("CAR: " + saveCar.getId());
        Announcement announcementDTO = getAnnouncement(announcement, saveCar);
        announcementDTO.setId(announcement.getId());
        announcementRepository.save(announcementDTO);
    }
}


