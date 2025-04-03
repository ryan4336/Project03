package project03.MidiEventFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
/**
 * A factory interface for creating MIDI note events.
 * This interface defines methods for creating MIDI "Note On" and "Note Off" events.
 */
public interface MidiEventFactory {
	/**
     * Creates a MIDI "Note On" event with the specified parameters.
     * 
     * @param tick The tick time at which the note starts.
     * @param note The MIDI note number.
     * @param velocity The velocity of the note.
     * @param channel The MIDI channel.
     * @return A MidiEvent representing the "Note On" event.
     * @throws InvalidMidiDataException If there is an error in setting the MIDI message.
     */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	/**
     * Creates a MIDI "Note Off" event with the specified parameters.
     * 
     * @param tick The tick time at which the note ends.
     * @param note The MIDI note number.
     * @param channel The MIDI channel.
     * @return A MidiEvent representing the "Note Off" event.
     * @throws InvalidMidiDataException If there is an error in setting the MIDI message.
     */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
	
}
