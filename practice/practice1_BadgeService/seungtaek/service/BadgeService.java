package service;

import domain.Badge;
import domain.BadgeType;
import domain.Landmark;
import domain.User;
import repository.AdventureRepository;
import repository.BadgeRepository;
import service.college_badge.LandmarkBadgeFactory;
import util.SleepUtil;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BadgeService {

    private final BadgeRepository badgeRepository = new BadgeRepository();
    public static Set<BadgeType> MockUserBadgeSet = new HashSet<>();
    private final LandmarkBadgeFactory landmarkBadgeFactory = new LandmarkBadgeFactory();

    /**
     * 조건에 맞는 뱃지를 저장 및 반환한다.
     */
    public Set<BadgeType> getNewlyRegisteredBadge(User user, Landmark landmark) {
        Set<BadgeType> newlyRegisteredBadge = new HashSet<>();
        Set<BadgeType> userBadgeSet = getUserBadgeSet(user);

        Optional<BadgeType> optionalBadgeType = landmarkBadgeFactory.getBadgeType(landmark, user);
        if (optionalBadgeType.isPresent()) {
            BadgeType badgeType = optionalBadgeType.get();
            if (!userBadgeSet.contains(badgeType)) {
                newlyRegisteredBadge.add(badgeType);
                badgeRepository.save(Badge.createBadge(user, badgeType));
            }
        }
        return newlyRegisteredBadge;
    }

    /**
     * 유저가 현재 가진 뱃지 목록을 가져온다. (DB에서 가져온다고 가정)
     */
    private Set<BadgeType> getUserBadgeSet(User user) {
        SleepUtil.sleep(100);
        return MockUserBadgeSet;
    }
}
