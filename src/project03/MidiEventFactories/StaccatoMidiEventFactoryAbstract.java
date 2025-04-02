package project03.MidiEventFactories;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
