package com.recruit.recruitms.configuration;

import com.recruit.recruitms.entity.*;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Configuration
public class SeedDataConfig {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final CountryRepository countryRepository;
    private final OrganizationRepository organizationRepository;
    private final VacancyRepository vacancyRepository;
    private final ResumeRepository resumeRepository;


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

            //COUNTRY
            List<Country> countries = new ArrayList<>();
            // Get ISO countries, create Country object and
            // store in the collection.
            String[] isoCountries = Locale.getISOCountries();
            for (String country : isoCountries) {
                Locale locale = new Locale("en", country);
                String iso = locale.getISO3Country();
                String code = locale.getCountry();
                String name = locale.getDisplayCountry();

                if (!"".equals(iso) && !"".equals(code) && !"".equals(name)) {
                    countries.add(new Country(iso, code, name));
                }
            }
            if(countryRepository.findAll().isEmpty())  countryRepository.saveAll(countries);

            List<User> users = List.of(
                    new User(
                            "admin",
                            "admin@mail.com",
                            "admin",
                            passwordEncoder.encode("admin123"),
                            Enum.Role.ADMIN,
                            LocalDate.of(2000,Month.AUGUST,10),
                            Enum.Gender.MALE
                    )
            );

            users.forEach(x->x.setObjectState(Enum.ObjectState.ACTIVE));
            if(userRepository.findAll().isEmpty()) userRepository.saveAll(users);

            //TAG
            List<Tag> tags = List.of(
                    new Tag("Software Engineer", Enum.TagType.Vacancy, 0L),
                    new Tag("Internship", Enum.TagType.Vacancy,0L),
                    new Tag("Fresh Graduate", Enum.TagType.Vacancy,0L),
                    new Tag("Master", Enum.TagType.Vacancy,0L),
                    new Tag("Degree", Enum.TagType.Vacancy,0L),
                    new Tag("Foundation", Enum.TagType.Vacancy,0L),
                    new Tag("Cyber Security", Enum.TagType.Vacancy,0L),
                    new Tag("C#", Enum.TagType.Vacancy, 0L),
                    new Tag("Java", Enum.TagType.Vacancy, 0L),
                    new Tag("Spring Boot", Enum.TagType.Vacancy, 0L),
                    new Tag("Angular", Enum.TagType.Vacancy, 0L),
                    new Tag("HTML", Enum.TagType.Vacancy, 0L),
                    new Tag("CSS", Enum.TagType.Vacancy, 0L),
                    new Tag("JavaScript", Enum.TagType.Vacancy, 0L),
                    new Tag("ASP.Net", Enum.TagType.Vacancy, 0L)
                    );
            if(tagRepository.findAll().isEmpty()) tagRepository.saveAll(tags);

//            List<User> users = List.of(
//                    new User(
//                            "admin",
//                            "admin@mail.com",
//                            "admin",
//                            passwordEncoder.encode("admin123"),
//                            Enum.Role.ADMIN,
//                            LocalDate.of(2000,Month.AUGUST,10),
//                            Enum.Gender.MALE
//                    ),
//                    new User(
//                            "Employer Sorotech",
//                            "pinyuan.ng@sorotech-my.com",
//                            "e01",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.EMPLOYER,
//                            LocalDate.of(2000,Month.MAY,7),
//                            Enum.Gender.MALE
//                    ),
//                    new User(
//                            "Employer B",
//                            "employer02@mail.com",
//                            "e02",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.EMPLOYER,
//                            LocalDate.of(1988,Month.NOVEMBER,17),
//                            Enum.Gender.MALE
//                    ),
//                    new User(
//                            "Employer C",
//                            "employer03@mail.com",
//                            "e03",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.EMPLOYER,
//                            LocalDate.of(1968,Month.JUNE,27),
//                            Enum.Gender.MALE
//                    ),
//                    new User(
//                            "Chew Jing Qiao",
//                            "chew0000@mail.com",
//                            "cjq",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.CANDIDATE,
//                            LocalDate.of(2000,Month.JUNE,26),
//                            Enum.Gender.MALE
//                    ),
//                    new User(
//                            "Chong Wen Yao",
//                            "cwy0000@mail.com",
//                            "cwy",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.CANDIDATE,
//                            LocalDate.of(1995,Month.FEBRUARY,11),
//                            Enum.Gender.MALE
//                    ),
//                    new User(
//                            "Shanie",
//                            "shanie0000@mail.com",
//                            "shanie",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.CANDIDATE,
//                            LocalDate.of(2002,Month.OCTOBER,24),
//                            Enum.Gender.FEMALE
//                    ),
//                    new User(
//                            "Candidate A",
//                            "candidate01@mail.com",
//                            "c01",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.CANDIDATE,
//                            LocalDate.of(1998,Month.OCTOBER,24),
//                            Enum.Gender.FEMALE
//                    ),
//                    new User(
//                            "Candidate B",
//                            "candidate02@mail.com",
//                            "c02",
//                            passwordEncoder.encode("111111"),
//                            Enum.Role.CANDIDATE,
//                            LocalDate.of(1988,Month.OCTOBER,24),
//                            Enum.Gender.MALE
//                    )
//            );
//            users.forEach(x->x.setObjectState(Enum.ObjectState.ACTIVE));
//            if(userRepository.findAll().isEmpty()) userRepository.saveAll(users);

//            //TAG
//            List<Tag> tags = List.of(
//                    new Tag("Software Engineer", Enum.TagType.Vacancy, 0L),
//                    new Tag("Internship", Enum.TagType.Vacancy,0L),
//                    new Tag("Fresh Graduate", Enum.TagType.Vacancy,0L),
//                    new Tag("Master", Enum.TagType.Vacancy,0L),
//                    new Tag("Degree", Enum.TagType.Vacancy,0L),
//                    new Tag("Foundation", Enum.TagType.Vacancy,0L),
//                    new Tag("Cyber Security", Enum.TagType.Vacancy,0L)
//                );
//            if(tagRepository.findAll().isEmpty()) tagRepository.saveAll(tags);

//            //OTHER
//            List<Organization> organizationList = List.of(
//                    new Organization(
//                        "Company B",
//                        "A company that doing mobiles application and publish to the app store.",
//                        "1, Jalan XX, Taman YY, 86000, Kluang, Johor",
//                        countryRepository.findByCode("MY").get(),
//                        "companyA@mail.com",
//                        "0112344567",
//                        "www.abcompany.com",
//                        userRepository.findByUsername("e02").get(),
//                        Enum.ObjectState.ACTIVE
//                    ),
//                    new Organization(
//                            "Soft Rock Technologies Sdn Bhd",
//                            "A company that provided Smart Factory 4.0 Solution, including Manufacturing Execution Systems (MES) and so on.",
//                            "1A-2-1 One Precinct, Lengkok Mayang Pasir, Bayan Baru, 11950, Pulau Pinang",
//                            countryRepository.findByCode("MY").get(),
//                            "info@sorotech-my.com",
//                            "0123842439",
//                            "https://sorotech-my.com/",
//                            userRepository.findByUsername("e01").get(),
//                            Enum.ObjectState.ACTIVE
//                    ),
//                    new Organization(
//                            "StaffKing",
//                            "Our mission is to provide employment services of the highest quality to our valued clients and we strive to conduct our business to help our clients achieve maximum productivity with the right talents. StaffKing focuses on providing excellent employment services to both large and small businesses across various industries. ",
//                            "6 Ubi Road, #05-08 Wintech Centre, Singapore 408726",
//                            countryRepository.findByCode("SG").get(),
//                            "companyA@mail.com",
//                            "6588928103",
//                            "https://www.staffking.com.sg/home",
//                            userRepository.findByUsername("e03").get(),
//                            Enum.ObjectState.ACTIVE
//                    )
//            );

//            if(organizationRepository.findAll().isEmpty()) organizationRepository.saveAll(organizationList);

//            Vacancy vacancy = new Vacancy(
//                    "Vacancy A",
//                    "A web development vacancy",
//                    tags,
//                    countryRepository.findByCode("MY").get(),
//                    organizationRepository.findByName("Company A").get(),
//                    30,
//                    3000f,
//                    5000f,
//                    "First come First serve",
//                    Enum.ObjectState.ACTIVE
//            );

//            if(vacancyRepository.findAll().isEmpty()) vacancyRepository.save(vacancy);

//            Resume resume = new Resume(
//                    "photo2_admin_202207061210.jpg",
//                    userRepository.findByUsername("npy").get(),
//                    tags,
//                    countryRepository.findByCode("MY").get(),
//                    2,
//                    4000f,
//                    "Gradute soon",
//                    "CV_npy_202207061153.pdf",
//                    Enum.ObjectState.ACTIVE
//            );
//            if(resumeRepository.findAll().isEmpty()) resumeRepository.save(resume);

        };



    }
}
