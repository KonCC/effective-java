package service.college_badge;

import domain.BadgeType;
import domain.Landmark;
import domain.User;

public interface BadgeStrategy {

    boolean isSupported(Landmark landmark, User user);

    BadgeType getBadgeType();
}
