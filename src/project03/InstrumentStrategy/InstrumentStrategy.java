package project03.InstrumentStrategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;
/**
 * This interface defines a strategy for applying a specific MIDI instrument 
 * to a given track and channel.
 */
public interface InstrumentStrategy {
	/**
     * Applies an instrument to the specified MIDI track and channel.
     *
     * @param track   The MIDI track to which the instrument is applied.
     * @param channel The MIDI channel on which the instrument is set.
     * @throws InvalidMidiDataException If the MIDI message cannot be created.
     */
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;
}
