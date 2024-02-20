package service;

import domain.BadgeType;
import domain.Landmark;
import domain.User;

import java.util.Set;

public interface BadgeLandmarkMatcher {

        boolean haveBadge(Set<BadgeType> userBadgeSet, Landmark landmark);

        boolean canGetBadge(Landmark landmark);

        BadgeType GetMatchBadge(long count,Landmark landmark);

}
