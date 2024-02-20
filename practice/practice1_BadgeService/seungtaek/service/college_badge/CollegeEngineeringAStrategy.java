package service.college_badge;


import domain.BadgeType;
import domain.Landmark;
import domain.LandmarkType;
import domain.User;
import repository.AdventureRepository;

class CollegeEngineeringAStrategy implements BadgeStrategy {
    private final AdventureRepository adventureRepository = new AdventureRepository();

    @Override
    public boolean isSupported(Landmark landmark, User user) {
        if (landmark.getName() != LandmarkType.공학관A) {
            return false;
        }
        long count = adventureRepository.countByUserAndLandmark(user, landmark);
        return count == 10;
    }

    @Override
    public BadgeType getBadgeType() {
        return BadgeType.COLLEGE_OF_ENGINEERING_A;
    }
}
