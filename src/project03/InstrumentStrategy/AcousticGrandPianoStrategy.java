package project03.InstrumentStrategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
/**
 * Implements an instrument strategy that sets the Acoustic Grand Piano 
 * as the instrument for a specified MIDI channel.
 */
public class AcousticGrandPianoStrategy implements InstrumentStrategy{
	/**
     * Applies the Acoustic Grand Piano instrument to the given MIDI track and channel.
     * 
     * @param track   The MIDI track to apply the instrument to.
     * @param channel The MIDI channel to set the instrument on.
     * @throws InvalidMidiDataException If an error occurs while setting the MIDI message.
     */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
        try {
            ((ShortMessage) message).setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
            track.add(new MidiEvent(message, 0));
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
		
	}

}
