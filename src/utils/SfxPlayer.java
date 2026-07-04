package utils;

import javax.sound.sampled.*;
import java.io.File;

public class SfxPlayer {
    // Adicionamos o parâmetro 'volumeDb' (ex: -10.0f para ficar mais baixo)
    public SfxPlayer(String fileName, float volumeDb) {
        new Thread(() -> {
            try {
                File file = new File("res/sfx/" + fileName);
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();

                clip.open(audio);

                // --- CONTROLE DE VOLUME ---
                // Verifica se o controle de volume master é suportado pelo sistema
                if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                    // Garante que o valor passado não ultrapassa os limites do sistema
                    float gain = Math.max(gainControl.getMinimum(), Math.min(volumeDb, gainControl.getMaximum()));
                    gainControl.setValue(gain);
                }
                // --------------------------

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });

                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}