package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDrivenDevelopment {
    MoodAnalyser moodAnalyser;
    @BeforeEach
        void setUp(){
        moodAnalyser = new MoodAnalyser();
    }
    @Test
    void badMoodAnalyzerTest(){
        String moodMessage = "У меня плохое настроение";

        String result = moodAnalyser.analyseMood(moodMessage);

        assertEquals("bad mood",result);
    }
    @Test
    void goodMoodAnalyzerTest(){
        String moodMessage = "У меня хорошее настроение";

        String result = moodAnalyser.analyseMood(moodMessage);

        assertEquals("good mood",result);
    }
    @Test
    void soSoMoodAnalyzerTest(){
        String moodMessage = "У меня не очень настроение";

        String result = moodAnalyser.analyseMood(moodMessage);

        assertEquals("so-so mood",result);
    }
    @Test
    void noMoodAnalyzerTest(){
        String moodMessage = "У меня хз какое настроение";

        String result = moodAnalyser.analyseMood(moodMessage);

        assertEquals("Don't worry, be happy",result);
    }

}