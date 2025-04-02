package project03.MidiData;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MidiCsvParser {
    public static List<MidiEventData> parseCsv(String filePath) {
        List<MidiEventData> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                int startEndTick = Integer.parseInt(parts[0].trim());
                int noteOnOff = 0;
                
                String eventType = parts[1].trim();
                if(eventType.equals("Note_on_c")) {
                	noteOnOff = 1;
                }
                
                int channel = Integer.parseInt(parts[2].trim());
                int note = Integer.parseInt(parts[3].trim());
                int velocity = Integer.parseInt(parts[4].trim());
                int instrument = Integer.parseInt(parts[5].trim());
                
                events.add(new MidiEventData(startEndTick, velocity, note, channel, noteOnOff, instrument));
           
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
		return events;
    }
}