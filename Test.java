/**
 * Created by horus on 9/1/16.
 */

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;

import java.io.IOException;

public class Test {

    public static void main (String[] args) {
        Configuration configuration = new Configuration();

        // Set path to acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to dictionary.
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        // Set language model.
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        try {
            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            // Start recognition process pruning previously cached data.
            recognizer.startRecognition(true);
            SpeechResult result = recognizer.getResult();
            for (WordResult r : result.getWords())
                    System.out.print(r + " ");
            System.out.println();
            // Pause recognition process. It can be resumed then with startRecognition(false).
            recognizer.stopRecognition();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
