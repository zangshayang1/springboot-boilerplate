package parking;

public final class ClockMock implements Clock {
	private long currTime;

	@Override
	public long now() {
		return currTime;
	}

	public void setCurrTime(long currTime) {
		this.currTime = currTime;
	}
}