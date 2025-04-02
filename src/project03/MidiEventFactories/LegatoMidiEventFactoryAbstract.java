package project03.MidiEventFactories;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
