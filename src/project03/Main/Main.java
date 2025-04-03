package project03.Main;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import project03.MidiData.MidiCsvParser;
import project03.MidiData.MidiEventData;
import project03.MidiEventFactories.*;
import project03.PitchStrategy.*;
import project03.InstrumentStrategy.*;

public class Main {

	public static void main(String[] args) throws InvalidMidiDataException {
		
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("src/project03/Files/mystery_song.csv");
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            //MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract (); 
            // MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract ();
            MidiEventFactory factory = factoryAbstract.createFactory();
            
            // Choose an instrument strategy (e.g., Trumpet, Bass Guitar, Piano)
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);
            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);
            
            
            // Choose a pitch strategy (e.g., HigherPitch, LowerPitch)
            PitchStrategy pitchStrategy = new HigherPitchStrategy();
            
            for (MidiEventData event : midiEvents) {
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                
                if (event.getNoteOnOff() == 1) {
                    track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
                }
            }

            // Playing the sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();
            
            long trackLength = sequence.getTickLength(); 
            long currentTick = sequencer.getTickPosition();
            
            while (sequencer.isRunning() && currentTick < trackLength)  {
                Thread.sleep(100);
            }
            
            Thread.sleep(500);
            sequencer.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
