package domain;

public class Badge {

    private Long id; // PK
    private User user; // FK
    private BadgeType badgeType;

    private Badge(User user, BadgeType badgeType) {
        this.user = user;
        this.badgeType = badgeType;
    }

    public static Badge createBadge(User user, BadgeType badgeType) {
        return new Badge(user, badgeType);
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BadgeType getBadgeType() {
        return badgeType;
    }
}
