package com.recruit.recruitms.configuration;

import com.recruit.recruitms.entity.Country;
import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.repository.CountryRepository;
import com.recruit.recruitms.repository.TagRepository;
import com.recruit.recruitms.repository.UserRepository;
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


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            //USER
            User admin = new User(
                    "admin",
                    "admin@mail.com",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    Enum.Role.ADMIN,
                    LocalDate.of(2000,Month.AUGUST,10),
                    Enum.Gender.MALE
            );
            admin.setObjectState(Enum.ObjectState.ACTIVE);
            if(userRepository.findAll().isEmpty()) userRepository.save(admin);

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
        };
    }
}
