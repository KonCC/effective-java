package service;

import domain.BadgeType;
import domain.Landmark;
import domain.LandmarkType;
import util.TimeUtil;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BadgeLandmarkMatcherMapImpl implements BadgeLandmarkMatcher {

    private Map<LandmarkType, BadgeType> badgeTypeMap=new HashMap<>();

    private Map<LandmarkType, Long> badgeTypeConditionMap=new HashMap<>();
    public BadgeLandmarkMatcherMapImpl(){

        badgeTypeMap.put(LandmarkType.공학관A,BadgeType.COLLEGE_OF_ENGINEERING_A);
        badgeTypeMap.put(LandmarkType.공학관B,BadgeType.COLLEGE_OF_ENGINEERING_B);
        badgeTypeMap.put(LandmarkType.공학관C,BadgeType.COLLEGE_OF_ENGINEERING_C);

        badgeTypeConditionMap.put(LandmarkType.공학관A,10L);
        badgeTypeConditionMap.put(LandmarkType.공학관B,10L);
        badgeTypeConditionMap.put(LandmarkType.공학관C,20L);
    }
    @Override
    public boolean haveBadge(Set<BadgeType> userBadgeSet, Landmark landmark) {
        if(userBadgeSet.contains(badgeTypeMap.get(landmark.getName()))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canGetBadge(Landmark landmark){
        if (landmark.getName() == LandmarkType.공학관B) {
            LocalTime now = TimeUtil.now();
            if (!(now.isAfter(LocalTime.of(18, 0)) && now.isBefore(LocalTime.of(20, 0)))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public BadgeType GetMatchBadge(long count, Landmark landmark) {
        if(badgeTypeConditionMap.get(landmark.getName())==count){
            return badgeTypeMap.get(landmark.getName());
        }
        return null;
    }




}
