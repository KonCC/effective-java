package service.college_badge;


import domain.BadgeType;
import domain.Landmark;
import domain.LandmarkType;
import domain.User;
import repository.AdventureRepository;
import util.TimeUtil;

import java.time.LocalTime;

class CollegeEngineeringBStrategy implements BadgeStrategy {
    private final AdventureRepository adventureRepository = new AdventureRepository();
    private static final LocalTime START_TIME = LocalTime.of(18, 0);
    private static final LocalTime END_TIME = LocalTime.of(20, 0);

    @Override
    public boolean isSupported(Landmark landmark, User user) {
        if (landmark.getName() != LandmarkType.공학관B) {
            return false;
        }
        LocalTime now = TimeUtil.now();
        return isTimeBetween(now, START_TIME, END_TIME) &&
                adventureRepository.countByUserAndLandmark(user, landmark) == 10;
    }

    private boolean isTimeBetween(LocalTime now, LocalTime startTime, LocalTime endTime) {
        return now.isAfter(startTime) && now.isBefore(endTime);
    }

    @Override
    public BadgeType getBadgeType() {
        return BadgeType.COLLEGE_OF_ENGINEERING_B;
    }
}
