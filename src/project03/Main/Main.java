package project03.Main;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import project03.MidiData.MidiCsvParser;
import project03.MidiData.MidiEventData;
import project03.MidiEventFactories.*;
import project03.PitchStrategy.*;
import project03.InstrumentStrategy.*;
/**
 * Main class to demonstrate the playback of MIDI events using different strategies for instrument selection and pitch modification.
 * It parses MIDI data from a CSV file, applies chosen strategies, and plays the sequence of MIDI events using a Sequencer.
 */
public class Main {
	/**
     * Main method to set up and play MIDI events.
     * 
     * @param args Command-line arguments.
     * @throws InvalidMidiDataException If there is an error while creating MIDI events.
     */
	public static void main(String[] args) {
		System.out.println("Currently Playing: 'bad guy' by Billie Eilish");
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
		System.out.println("Finished!");
	}

}
