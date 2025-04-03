package project03.MidiEventFactories;
/**
 * A concrete implementation of the MidiEventFactoryAbstract interface that creates a 
 * StaccatoMidiEventFactory. This factory produces MIDI events with shorter durations and a gap
 * between "Note Off" and the next "Note On" event to produce a staccato effect.
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	/**
     * Creates a StaccatoMidiEventFactory to produce staccato MIDI events.
     * 
     * @return A StaccatoMidiEventFactory instance that can create staccato-style MIDI events.
     */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
