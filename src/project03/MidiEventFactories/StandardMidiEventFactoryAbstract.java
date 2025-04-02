package project03.MidiEventFactories;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}
