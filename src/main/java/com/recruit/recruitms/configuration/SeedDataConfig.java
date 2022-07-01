package com.recruit.recruitms.configuration;

import com.recruit.recruitms.entity.*;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            //USER
            List<User> users = List.of(
                    new User(
                            "admin",
                            "admin@mail.com",
                            "admin",
                            passwordEncoder.encode("admin123"),
                            Enum.Role.ADMIN,
                            LocalDate.of(2000,Month.AUGUST,10),
                            Enum.Gender.MALE
                    ),
                    new User(
                            "Employer A",
                            "employer01@mail.com",
                            "e01",
                            passwordEncoder.encode("111111"),
                            Enum.Role.EMPLOYER,
                            LocalDate.of(2000,Month.JULY,7),
                            Enum.Gender.MALE
                    ),
                    new User(
                            "Staff A",
                            "staff01@mail.com",
                            "s01",
                            passwordEncoder.encode("111111"),
                            Enum.Role.STAFF,
                            LocalDate.of(1980,Month.JANUARY,29),
                            Enum.Gender.FEMALE
                    ),
                    new User(
                            "Chew Jing Qiao",
                            "chew0000@mail.com",
                            "cjq",
                            passwordEncoder.encode("111111"),
                            Enum.Role.CANDIDATE,
                            LocalDate.of(2000,Month.JUNE,26),
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
                    new Tag("Cyber Security", Enum.TagType.Vacancy,0L)
                );
            if(tagRepository.findAll().isEmpty()) tagRepository.saveAll(tags);

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

            //OTHER
            Organization organization = new Organization(
                "Company A",
                "A company that doing mobiles application and publish to the app store.",
                "1, Jalan XX, Taman YY, 86000, Kluang, Johor",
                countryRepository.findByCode("MY").get(),
                "companyA@mail.com",
                "0112344567",
                "www.abcompany.com",
                userRepository.findByUsername("e01").get(),
                Enum.ObjectState.ACTIVE
            );

            if(organizationRepository.findAll().isEmpty()) organizationRepository.save(organization);
        };


    }
}
