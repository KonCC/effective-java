package service;

import domain.*;
import repository.AdventureRepository;
import repository.BadgeRepository;
import util.SleepUtil;
import util.TimeUtil;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class BadgeService {

    private final BadgeRepository badgeRepository = new BadgeRepository();
    private final AdventureRepository adventureRepository = new AdventureRepository();
    public static Set<BadgeType> MockUserBadgeSet = new HashSet<>();

    /**
     * 조건에 맞는 뱃지를 저장 및 반환한다.
     */
    public Set<BadgeType> getNewlyRegisteredBadge(User user, Landmark landmark) {
        Set<BadgeType> newlyRegisteredBadge = new HashSet<>();
        Set<BadgeType> userBadgeSet = getUserBadgeSet(user);

        if (landmark.getName() == LandmarkType.공학관A) {
            if (!userBadgeSet.contains(BadgeType.COLLEGE_OF_ENGINEERING_A)) {
                long count = adventureRepository.countByUserAndLandmark(user, landmark);
                if (count == 10) {
                    newlyRegisteredBadge.add(BadgeType.COLLEGE_OF_ENGINEERING_A);
                    badgeRepository.save(Badge.createBadge(user, BadgeType.COLLEGE_OF_ENGINEERING_A));
                }
            }
        }
        else if (landmark.getName() == LandmarkType.공학관B) {
            if (!userBadgeSet.contains(BadgeType.COLLEGE_OF_ENGINEERING_B)) {
                LocalTime now = TimeUtil.now();
                if (now.isAfter(LocalTime.of(18, 0)) && now.isBefore(LocalTime.of(20, 0))) {
                    long count = adventureRepository.countByUserAndLandmark(user, landmark);
                    if (count == 10) {
                        newlyRegisteredBadge.add(BadgeType.COLLEGE_OF_ENGINEERING_B);
                        badgeRepository.save(Badge.createBadge(user, BadgeType.COLLEGE_OF_ENGINEERING_B));
                    }
                }
            }
        }
        else if (landmark.getName() == LandmarkType.공학관C) {
            if (!userBadgeSet.contains(BadgeType.COLLEGE_OF_ENGINEERING_C)) {
                long count = adventureRepository.countByUserAndLandmark(user, landmark);
                if (count == 20) {
                    newlyRegisteredBadge.add(BadgeType.COLLEGE_OF_ENGINEERING_C);
                    badgeRepository.save(Badge.createBadge(user, BadgeType.COLLEGE_OF_ENGINEERING_C));
                }
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
