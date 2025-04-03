package project03.PitchStrategy;
/**
 * Interface representing a strategy for modifying the pitch of a MIDI note.
 * Implementations of this interface should define specific ways to modify a note's pitch.
 */
public interface PitchStrategy {
	/**
     * Modifies the pitch of a given note.
     * 
     * @param note The original MIDI note to be modified.
     * @return The modified MIDI note after applying the pitch change.
     */
	int modifyPitch(int note);
}
