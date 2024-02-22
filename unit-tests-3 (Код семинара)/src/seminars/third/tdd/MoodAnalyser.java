package seminars.third.tdd;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if (message.contains("плохое")) {
            return "bad mood";
        } else if (message.contains("хорошее")) {
            return "good mood";
        } else if (message.contains("не очень")) {
            return "so-so mood";
        } else return "Don't worry, be happy";
    }
}