package project03.MidiEventFactories;
/**
 * A concrete implementation of the MidiEventFactoryAbstract interface for creating
 * LegatoMidiEventFactory instances.
 * This factory abstract is responsible for providing a Legato MIDI event factory.
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	/**
     * Creates and returns a new instance of LegatoMidiEventFactory.
     * 
     * @return A new LegatoMidiEventFactory instance.
     */
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
