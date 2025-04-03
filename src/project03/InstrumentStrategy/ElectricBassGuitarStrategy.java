package project03.InstrumentStrategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
/**
 * This class represents an instrument strategy that assigns an Electric Bass Guitar 
 * to a specified MIDI channel.
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy{
	/**
     * Applies the Electric Bass Guitar instrument to the given MIDI track and channel.
     *
     * @param track   The MIDI track to which the instrument is applied.
     * @param channel The MIDI channel on which the instrument is set.
     * @throws InvalidMidiDataException If the MIDI message cannot be created.
     */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        try {
            ((ShortMessage) message).setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
            track.add(new MidiEvent(message, 0));
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
	
	}
	
}
