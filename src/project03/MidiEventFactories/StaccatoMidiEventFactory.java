package project03.MidiEventFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * A factory class that creates MIDI events for staccato notes, where the note durations
 * are shorter and a gap is introduced between the "Note Off" and the next "Note On" event.
 * This factory adjusts the timing of note events to produce a staccato effect.
 */
public class StaccatoMidiEventFactory implements MidiEventFactory{
	/**
     * Protected constructor to prevent direct instantiation.
     */
	protected StaccatoMidiEventFactory() {
			
		}
	/**
     * Creates a "Note On" MIDI event with the specified tick, note, velocity, and channel.
     * 
     * @param tick The tick (or timing) at which the note should start.
     * @param note The MIDI note number.
     * @param velocity The velocity of the note (how hard the note is struck).
     * @param channel The MIDI channel for the note event.
     * @return A MidiEvent representing the "Note On" event at the specified tick.
     * @throws InvalidMidiDataException If the message data is invalid.
     */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(message, tick);
	}
	/**
     * Creates a "Note Off" MIDI event with the specified tick, note, and channel.
     * The tick for the "Note Off" event is adjusted to create a staccato effect, 
     * by shortening the note duration.
     * 
     * @param tick The tick (or timing) at which the note should stop.
     * @param note The MIDI note number.
     * @param channel The MIDI channel for the note event.
     * @return A MidiEvent representing the "Note Off" event at the specified tick minus 120 ticks.
     * @throws InvalidMidiDataException If the message data is invalid.
     */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(message, tick - 120);
	}

}
