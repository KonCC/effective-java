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
    public static BadgeLandmarkMatcher badgeLandmarkMatcher=new BadgeLandmarkMatcherMapImpl();
    /**
     * 조건에 맞는 뱃지를 저장 및 반환한다.
     */
    public Set<BadgeType> getNewlyRegisteredBadge(User user, Landmark landmark) {
        Set<BadgeType> newlyRegisteredBadge = new HashSet<>();
        Set<BadgeType> userBadgeSet = getUserBadgeSet(user);

        if(!badgeLandmarkMatcher.haveBadge(userBadgeSet,landmark)
                &&badgeLandmarkMatcher.canGetBadge(landmark)){
            long count = adventureRepository.countByUserAndLandmark(user, landmark);
            BadgeType badgeType=badgeLandmarkMatcher.GetMatchBadge(count,landmark);
            if(badgeType!=null)
                newlyRegisteredBadge.add(badgeType);
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
