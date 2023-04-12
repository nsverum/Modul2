import java.util.Random;

public enum Gender {
    MALE, FEMALE;

    public static Gender randomGender() {
        Random random = new Random();
        int genderIndex = random.nextInt(Gender.values().length);
        return Gender.values()[genderIndex];
    }
}