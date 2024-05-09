package dev.leetcode;

import org.javatuples.Triplet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class DailyChallengeTest {
  DailyChallenge challenge = new DailyChallenge();

  @Test
  @DisplayName("3075. Maximize Happiness of Selected Children")
  public void testMaximumHappinessSum() {
    List<Triplet<Long, List<Integer>, Integer>> tests =
        List.of(
            Triplet.with(4L, List.of(1, 2, 3), 2),
            Triplet.with(
                2517853814L,
                List.of(
                    2135218, 73431904, 92495076, 77528042, 82824634, 3036629, 28375907, 65220365,
                    40948869, 58914871, 57169530, 89783499, 19582915, 19676695, 11932465, 21770144,
                    49740276, 22303751, 80746555, 97391584, 95775653, 43396943, 47271136, 43935930,
                    59643137, 64183008, 8892641, 39587569, 85086654, 5663585, 82925096, 24868817,
                    95900395, 48155864, 74447380, 7618448, 63299623, 91141186, 33347112, 81951555,
                    52867615, 92184410, 7024265, 85525916, 29846922, 59532692, 47267934, 6514603,
                    1137830, 97807470),
                41),
            Triplet.with(1L, List.of(1, 1, 1, 1), 2),
            Triplet.with(5L, List.of(2, 3, 4, 5), 1));

    tests.forEach(
        test ->
            assertEquals(
                test.getValue0(),
                challenge.maximumHappinessSum(
                    test.getValue1().stream().mapToInt(val -> val).toArray(), test.getValue2())));
  }
}
