package service;

import domain.*;
import util.TimeUtil;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BadgeLandmarkMatcherImpl implements BadgeLandmarkMatcher {

    public BadgeLandmarkMatcherImpl(){
    }
    @Override
    public boolean haveBadge(Set<BadgeType> userBadgeSet, Landmark landmark) {

        if (landmark.getName() == LandmarkType.공학관A) {
            if (!userBadgeSet.contains(BadgeType.COLLEGE_OF_ENGINEERING_A)) {
                return false;
            }
            return true;
        }
        else if (landmark.getName() == LandmarkType.공학관B) {
            if (!userBadgeSet.contains(BadgeType.COLLEGE_OF_ENGINEERING_B)) {
               return false;
            }
            return true;
        }
        else if (landmark.getName() == LandmarkType.공학관C) {
            if (!userBadgeSet.contains(BadgeType.COLLEGE_OF_ENGINEERING_C)) {
                return false;
            }
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
        if (landmark.getName() == LandmarkType.공학관A) {
            if (count == 10) {
                return BadgeType.COLLEGE_OF_ENGINEERING_A;
            }
        }
        else if (landmark.getName() == LandmarkType.공학관B) {
            if (count == 10) {
                    return BadgeType.COLLEGE_OF_ENGINEERING_B;
            }
        }
        else if (landmark.getName() == LandmarkType.공학관C) {
            if (count == 20) {
                return BadgeType.COLLEGE_OF_ENGINEERING_C;
            }

        }
        return null;
    }




}
