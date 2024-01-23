import domain.BadgeType;
import domain.Landmark;
import domain.LandmarkType;
import domain.User;
import repository.AdventureRepository;
import service.BadgeService;
import util.TimeUtil;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Test {

    private final User testUser = new User();
    private final BadgeService badgeService = new BadgeService();

    // 공학관 A에 10번 방문하면 뱃지를 받는다.
    public boolean test1() {
        // given
        BadgeService.MockUserBadgeSet = new HashSet<>();
        AdventureRepository.MockReturnValue = 10;

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관A));

        // then
        if (result.size() != 1) return false;
        if (!result.contains(BadgeType.COLLEGE_OF_ENGINEERING_A)) return false;

        return true;
    }

    // 공학관 A를 10번 이하로 방문하면 뱃지를 받지 못한다.
    public boolean test2() {
        // given
        BadgeService.MockUserBadgeSet = new HashSet<>();
        AdventureRepository.MockReturnValue = 9;

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관A));

        // then
        if (result.size() != 0) return false;

        return true;
    }

    // 공학관 A를 10번 방문했어도 COLLEGE_OF_ENGINEERING_A를 이미 가지고 있다면 뱃지를 획득하지 못한다.
    public boolean test3() {
        // given
        BadgeService.MockUserBadgeSet = Set.of(BadgeType.COLLEGE_OF_ENGINEERING_A);
        AdventureRepository.MockReturnValue = 9;

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관A));

        // then
        if (result.size() != 0) return false;

        return true;
    }

    // 공학관 B에 10번 방문 + 마지막 방문이 18시 ~ 20시 사이면 뱃지를 받는다.
    public boolean test4() {
        // given
        BadgeService.MockUserBadgeSet = new HashSet<>();
        AdventureRepository.MockReturnValue = 10;
        TimeUtil.MockNow = LocalTime.of(19, 0);

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관B));

        // then
        if (result.size() != 1) return false;
        if (!result.contains(BadgeType.COLLEGE_OF_ENGINEERING_B)) return false;

        return true;
    }

    // 공학관 B를 10번 이하로 방문하면 뱃지를 받지 못한다.
    public boolean test5() {
        // given
        BadgeService.MockUserBadgeSet = new HashSet<>();
        AdventureRepository.MockReturnValue = 9;
        TimeUtil.MockNow = LocalTime.of(19, 0);

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관B));

        // then
        if (result.size() != 0) return false;

        return true;
    }

    // 공학관 B를 10번 방문했더라도 마지막 방문이 18 ~ 20시가 아니라면 뱃지를 받지 못한다.
    public boolean test6() {
        // given
        BadgeService.MockUserBadgeSet = new HashSet<>();
        AdventureRepository.MockReturnValue = 10;
        TimeUtil.MockNow = LocalTime.of(0, 0);

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관B));

        // then
        if (result.size() != 0) return false;

        return true;
    }

    // 공학관 B 뱃지 조건을 만족하더라도 COLLEGE_OF_ENGINEERING_B를 이미 가지고 있다면 뱃지를 획득하지 못한다.
    public boolean test7() {
        // given
        BadgeService.MockUserBadgeSet = Set.of(BadgeType.COLLEGE_OF_ENGINEERING_B);
        AdventureRepository.MockReturnValue = 10;
        TimeUtil.MockNow = LocalTime.of(19, 0);

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관B));

        // then
        if (result.size() != 0) return false;

        return true;
    }

    // 공학관 C에 20번 방문하면 뱃지를 받는다.
    public boolean test8() {
        // given
        BadgeService.MockUserBadgeSet = new HashSet<>();
        AdventureRepository.MockReturnValue = 20;

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관C));

        // then
        if (result.size() != 1) return false;
        if (!result.contains(BadgeType.COLLEGE_OF_ENGINEERING_C)) return false;

        return true;
    }

    // 공학관 C를 20번 이하로 방문하면 뱃지를 받지 못한다.
    public boolean test9() {
        // given
        BadgeService.MockUserBadgeSet = new HashSet<>();
        AdventureRepository.MockReturnValue = 19;

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관C));

        // then
        if (result.size() != 0) return false;

        return true;
    }

    // 공학관 C를 20번 방문했어도 COLLEGE_OF_ENGINEERING_C를 이미 가지고 있다면 뱃지를 획득하지 못한다.
    public boolean test10() {
        // given
        BadgeService.MockUserBadgeSet = Set.of(BadgeType.COLLEGE_OF_ENGINEERING_C);
        AdventureRepository.MockReturnValue = 9;

        // when
        Set<BadgeType> result = badgeService.getNewlyRegisteredBadge(testUser, new Landmark(LandmarkType.공학관C));

        // then
        if (result.size() != 0) return false;

        return true;
    }
}
