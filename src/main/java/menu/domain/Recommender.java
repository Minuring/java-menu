package menu.domain;

import java.util.List;
import menu.error.exception.CoachesCountException;
import menu.error.exception.DuplicatedCoachException;

public class Recommender {

    private static final int MIN_COACHES = 2;
    private static final int MAX_COACHES = 5;

    private final List<Coach> coaches;

    public Recommender(List<Coach> coaches) {
        validateSize(coaches);
        validateDuplicate(coaches);
        this.coaches = coaches;
    }

    private void validateDuplicate(List<Coach> coaches) {
        int size = coaches.size();
        long distinctSize = coaches.stream().distinct().count();
        if (size != distinctSize) {
            throw new DuplicatedCoachException();
        }
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < MIN_COACHES || coaches.size() > MAX_COACHES) {
            throw new CoachesCountException();
        }
    }
}
