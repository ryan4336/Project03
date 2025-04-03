package project03.MidiEventFactories;
/**
 * An abstract factory interface for creating different types of MIDI event factories.
 * This interface allows for the creation of specific MIDI event factories, which can then 
 * be used to generate different types of MIDI events (such as "Note On" and "Note Off").
 */
public interface MidiEventFactoryAbstract {
	/**
     * Creates a specific MIDI event factory.
     * 
     * @return An instance of a MidiEventFactory that is responsible for creating MIDI events.
     */
	MidiEventFactory createFactory();
}
