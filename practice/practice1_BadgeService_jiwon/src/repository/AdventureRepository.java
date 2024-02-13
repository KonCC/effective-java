package repository;

import domain.Landmark;
import domain.User;
import util.SleepUtil;

public class AdventureRepository {

    public static long MockReturnValue = 1;

    /*
     * 유저가 특정 랜드마크에 대해 몇번 방문을 했는지 반환한다.(DB 조회)
     */
    public long countByUserAndLandmark(User user, Landmark landmark) {
        SleepUtil.sleep(500);
        return MockReturnValue;
    }
}
