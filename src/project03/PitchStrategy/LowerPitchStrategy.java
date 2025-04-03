package project03.PitchStrategy;
/**
 * A concrete implementation of the PitchStrategy interface that modifies the pitch of a note 
 * by lowering it by two semitones.
 */
public class LowerPitchStrategy implements PitchStrategy{
	/**
     * Modifies the pitch of a given note by decreasing it by two semitones.
     * 
     * @param note The original note to be modified.
     * @return The modified note, lowered by two semitones.
     */
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}

}
