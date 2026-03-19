package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's League of Legends rank in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRank(String)}
 * <p>
 * Rank format: "TIER" (e.g., "GOLD", "SILVER", "CHALLENGER")
 */
public class Rank {

    public static final String MESSAGE_CONSTRAINTS = "Rank should be a valid League of Legends rank. "
            + "Valid ranks are: IRON, BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, MASTER, GRANDMASTER, CHALLENGER.";

    /**
     * Represents the set of supported League of Legends rank tiers.
     * Ordered from lowest to highest rank.
     */
    public enum RankType {
        IRON(0), BRONZE(1), SILVER(2), GOLD(3), PLATINUM(4),
        DIAMOND(5), MASTER(6), GRANDMASTER(7), CHALLENGER(8);

        private final int tierValue;

        RankType(int tierValue) {
            this.tierValue = tierValue;
        }

        public int getTierValue() {
            return tierValue;
        }
    }

    public final RankType value;

    /**
     * Constructs a {@code Rank} with the specified tier.
     *
     * @param rank A valid League of Legends rank tier.
     */
    public Rank(String rank) {
        requireNonNull(rank);
        String trimmedRank = rank.trim().toUpperCase();
        checkArgument(isValidRank(trimmedRank), MESSAGE_CONSTRAINTS);
        value = RankType.valueOf(trimmedRank);
    }

    /**
     * Returns true if a given string is a valid rank tier.
     */
    public static boolean isValidRank(String test) {
        try {
            RankType.valueOf(test);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Rank)) {
            return false;
        }

        Rank otherRank = (Rank) other;
        return value.equals(otherRank.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
