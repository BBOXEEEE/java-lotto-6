package lotto.model;

import lotto.view.OutputView;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_00),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int winnings;

    LottoRank(int matchCount, boolean matchBonus, int winningAmount) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winnings = winningAmount;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == matchBonus)
                .findAny().orElse(MISS);
    }
}
