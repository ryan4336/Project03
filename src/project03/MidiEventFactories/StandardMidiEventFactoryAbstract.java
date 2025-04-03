package project03.MidiEventFactories;
/**
 * A concrete implementation of the MidiEventFactoryAbstract interface that creates instances of 
 * StandardMidiEventFactory. This factory provides a way to generate standard MIDI events for note 
 * actions (Note On and Note Off) without any special modifications.
 */
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	/**
     * Creates and returns a new instance of StandardMidiEventFactory.
     * 
     * @return A new StandardMidiEventFactory instance that can be used to create standard MIDI events.
     */
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}
