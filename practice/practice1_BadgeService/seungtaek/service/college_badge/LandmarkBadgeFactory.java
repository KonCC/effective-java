package service.college_badge;

import domain.BadgeType;
import domain.Landmark;
import domain.User;

import java.util.List;
import java.util.Optional;

public class LandmarkBadgeFactory {

    private final List<BadgeStrategy> badgeStrategies
            = List.of(new CollegeEngineeringAStrategy(),
            new CollegeEngineeringBStrategy(),
            new CollegeEngineeringCStrategy());

    public Optional<BadgeType> getBadgeType(Landmark landmark, User user) {
        return badgeStrategies.stream()
                .filter(strategy -> strategy.isSupported(landmark, user))
                .map(BadgeStrategy::getBadgeType)
                .findFirst();
    }

}
