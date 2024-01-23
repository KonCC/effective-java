package domain;

public enum BadgeType {

    COLLEGE_OF_ENGINEERING_A("공대 A동 10회 이상 탐험"),
    COLLEGE_OF_ENGINEERING_B("공대 B동 10회 이상 탐험 + 마지막 방문이 18시~20시 사이"),
    COLLEGE_OF_ENGINEERING_C("공대 C동 20회 이상 탐험"),
    COLLEGE_OF_NEW_ENGINEERING("신공학관 15회 이상 탐험"),


    // 아래는 신경 안쓰셔도 됩니다. (뱃지 타입이 여러개 존재한다는 것만 알면됨)
    COLLEGE_OF_LIBERAL_ARTS("문과대학 1회 이상 탐험"),
    COLLEGE_OF_SCIENCES("이과대학 1회 이상 탐험"),
    COLLEGE_OF_ARCHITECTURE("건축대학 1회 이상 탐험"),
    COLLEGE_OF_ENGINEERING("공과대학 1회 이상 탐험"),
    COLLEGE_OF_SOCIAL_SCIENCES("사회과학대학 1회 이상 탐험"),
    COLLEGE_OF_BUSINESS_ADMINISTRATION("경영대학 1회 이상 탐험"),
    COLLEGE_OF_REAL_ESTATE("부동산과학원 1회 이상 탐험"),
    COLLEGE_OF_INSTITUTE_TECHNOLOGY("융합과학기술원 1회 이상 탐험"),
    COLLEGE_OF_BIOLOGICAL_SCIENCES("생명과학대학 1회 이상 탐험"),
    COLLEGE_OF_VETERINARY_MEDICINE("수의과대학 1회 이상 탐험"),
    COLLEGE_OF_ART_AND_DESIGN("예술디자인대학 1회 이상 탐험"),
    COLLEGE_OF_EDUCATION("사범대학 1회 이상 탐험"),
    ;

    private final String description;

    BadgeType(String description) {
        this.description = description;
    }
}
