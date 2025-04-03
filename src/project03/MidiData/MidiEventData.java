package project03.MidiData;
/**
 * This class represents MIDI event data, storing information about individual MIDI events,
 * such as timing, note, velocity, channel, and instrument.
 */
public class MidiEventData {
	
	private int startEndTick, velocity, note, channel, noteOnOff, instrument;
	/**
     * Constructs a MidiEventData object with the specified properties.
     *
     * @param startEndTick The tick at which the event occurs.
     * @param velocity The velocity of the note.
     * @param note The pitch of the note.
     * @param channel The MIDI channel of the event.
     * @param noteOnOff Indicates whether the event is a Note On (1) or Note Off (0).
     * @param instrument The instrument associated with the event.
     */
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int noteOnOff, int instrument) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.noteOnOff = noteOnOff;
		this.instrument = instrument;
	}
	/**
     * Gets the tick at which the event occurs.
     * 
     * @return The start or end tick of the event.
     */
	public int getStartEndTick() {
		return startEndTick;
	}
	/**
     * Sets the tick at which the event occurs.
     * 
     * @param startEndTick The start or end tick of the event.
     */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}
	/**
     * Gets the velocity of the note.
     * 
     * @return The velocity of the note.
     */
	public int getVelocity() {
		return velocity;
	}
	/**
     * Sets the velocity of the note.
     * 
     * @param velocity The velocity of the note.
     */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	/**
     * Gets the pitch of the note.
     * 
     * @return The note pitch.
     */
	public int getNote() {
		return note;
	}
	/**
     * Sets the pitch of the note.
     * 
     * @param note The note pitch.
     */
	public void setNote(int note) {
		this.note = note;
	}
	/**
     * Gets the MIDI channel of the event.
     * 
     * @return The MIDI channel.
     */
	public int getChannel() {
		return channel;
	}
	/**
     * Sets the MIDI channel of the event.
     * 
     * @param channel The MIDI channel.
     */
	public void setChannel(int channel) {
		this.channel = channel;
	}
	/**
     * Gets whether the event is a Note On (1) or Note Off (0).
     * 
     * @return 1 for Note On, 0 for Note Off.
     */
	public int getNoteOnOff() {
		return noteOnOff;
	}
	/**
     * Sets whether the event is a Note On (1) or Note Off (0).
     * 
     * @param noteOnOff 1 for Note On, 0 for Note Off.
     */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}
	/**
     * Gets the instrument associated with the event.
     * 
     * @return The instrument number.
     */
	public int getInstrument() {
		return instrument;
	}
	/**
     * Sets the instrument associated with the event.
     * 
     * @param instrument The instrument number.
     */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	/**
     * Returns a string representation of the MidiEventData object.
     * 
     * @return A formatted string with MIDI event details.
     */
	@Override
	public String toString() {
		return "MidiEventData [startEndTick=" + startEndTick + ", velocity=" + velocity + ", note=" + note
				+ ", channel=" + channel + ", noteOnOff=" + noteOnOff + ", instrument=" + instrument + "]";
	}
	
	
	
	
}
