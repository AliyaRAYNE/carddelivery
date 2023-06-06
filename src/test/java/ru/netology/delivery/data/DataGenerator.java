package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;
public class DataGenerator {
    private DataGenerator() {
    }
    private static Faker faker;
    public static String generateDate(int shift) {
        return java.time.LocalDate.now()
                .plusDays(shift).format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public static String generateCity(String locale) {
        var cities = new String[]{"Уфа", "Киров", "Йошкар-Ола", "Саранск", "Нижний Новгород",
                "Оренбург", "Пенза", "Пермь", "Самара", "Саратов", "Казань", "Ижевск", "Ульяновск", "Чебоксары", "Курган",
                "Екатеринбург", "Тюмень", "Ханты-мансийск", "Челябиннск", "Салехард"
        };
        return cities[new Random().nextInt(cities.length)];
    }
    public static String generateName(String locale) {
        faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }
    public static String generatePhone(String locale) {
        faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }
    public static class Registration {
        private Registration() {
        }
        public static UserInfo generateUser(String locale) {
            String city = generateCity(locale);
            String name = generateName(locale);
            String phone = generatePhone(locale);
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}