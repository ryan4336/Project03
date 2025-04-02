package project03.MidiEventFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public class LegatoMidiEventFactory implements MidiEventFactory{
	protected LegatoMidiEventFactory() {
		
	}

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		
		return null;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		
		return null;
	}

}
