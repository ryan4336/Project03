package project03.InstrumentStrategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
/**
 * This class implements the InstrumentStrategy to set the MIDI instrument to a trumpet.
 */
public class TrumpetStrategy implements InstrumentStrategy{
	/**
     * Applies the trumpet instrument to the specified MIDI track and channel.
     *
     * @param track   The MIDI track to which the instrument is applied.
     * @param channel The MIDI channel on which the instrument is set.
     * @throws InvalidMidiDataException If the MIDI message cannot be created.
     */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        try {
            ((ShortMessage) message).setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
            track.add(new MidiEvent(message, 0));
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
		
	}

}
