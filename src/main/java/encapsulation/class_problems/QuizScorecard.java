class Scorecard {
    private boolean[] results;
    private int count;

    Scorecard(int n) {
        results = new boolean[n];
    }

    void recordAnswer(boolean x) {
        if (count < results.length)
            results[count++] = x;
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++)
            if (results[i]) score++;
        return score;
    }
}

public class QuizScorecard {
    public static void main(String[] args) {
        Scorecard s = new Scorecard(4);
        s.recordAnswer(true);
        s.recordAnswer(true);
        s.recordAnswer(false);
        s.recordAnswer(true);
        System.out.println(s.getScore());
    }
}