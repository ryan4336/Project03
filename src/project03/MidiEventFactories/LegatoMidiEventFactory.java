package project03.MidiEventFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * A factory for creating MIDI events with a legato style.
 * Legato notes have a slight overlap to ensure smooth transitions between notes.
 */
public class LegatoMidiEventFactory implements MidiEventFactory{
	/**
     * Protected constructor to prevent direct instantiation.
     */
	protected LegatoMidiEventFactory() {
		
	}
	/**
     * Creates a Note On MIDI event.
     * 
     * @param tick The tick at which the note starts.
     * @param note The MIDI note number.
     * @param velocity The velocity of the note.
     * @param channel The MIDI channel.
     * @return A MidiEvent representing the Note On.
     * @throws InvalidMidiDataException If the MIDI message is invalid.
     */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(message, tick);
	}
	/**
     * Creates a Note Off MIDI event with a slight delay for legato effect.
     * 
     * @param tick The tick at which the note should end.
     * @param note The MIDI note number.
     * @param channel The MIDI channel.
     * @return A MidiEvent representing the Note Off.
     * @throws InvalidMidiDataException If the MIDI message is invalid.
     */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(message, tick + 80);
	}
	
	

}
