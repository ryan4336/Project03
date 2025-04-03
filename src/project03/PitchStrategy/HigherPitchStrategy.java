package project03.PitchStrategy;
/**
 * A concrete implementation of the PitchStrategy interface that modifies the pitch of a note 
 * by raising it by two semitones.
 */
public class HigherPitchStrategy implements PitchStrategy {
	/**
     * Modifies the pitch of a given note by increasing it by two semitones.
     * 
     * @param note The original note to be modified.
     * @return The modified note, raised by two semitones.
     */
	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}

}
