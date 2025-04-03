package project03.MidiEventFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * A concrete implementation of the MidiEventFactory interface that creates standard MIDI events 
 * for "Note On" and "Note Off" actions. The StandardMidiEventFactory produces typical MIDI events 
 * without modifications for note duration, pitch, or other special effects.
 */
public class StandardMidiEventFactory implements MidiEventFactory{
	protected StandardMidiEventFactory() {
		
	}
	/**
     * Creates a "Note On" MIDI event with the given parameters.
     * 
     * @param tick The tick value indicating when the note should start.
     * @param note The note value representing the pitch of the note.
     * @param velocity The velocity (or volume) of the note.
     * @param channel The MIDI channel for the note.
     * @return A MidiEvent representing a "Note On" message with the given parameters.
     * @throws InvalidMidiDataException If the provided data for the MIDI message is invalid.
     */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(message, tick);
	}
	/**
     * Creates a "Note Off" MIDI event with the given parameters.
     * 
     * @param tick The tick value indicating when the note should stop.
     * @param note The note value representing the pitch of the note.
     * @param channel The MIDI channel for the note.
     * @return A MidiEvent representing a "Note Off" message with the given parameters.
     * @throws InvalidMidiDataException If the provided data for the MIDI message is invalid.
     */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(message, tick);
	}

}
