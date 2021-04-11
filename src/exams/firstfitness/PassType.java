package exams.firstfitness;

import java.time.LocalTime;

public enum PassType {
    SINGLE(LocalTime.parse("08:00:00"), LocalTime.parse("22:00:00"), new ZoneType[] {ZoneType.GYM, ZoneType.SWIMMING_POOL}),
    DAY(LocalTime.parse("08:00:00"), LocalTime.parse("16:00:00"), new ZoneType[] {ZoneType.GYM, ZoneType.GROUP_TRAINING}),
    FULL(LocalTime.parse("08:00:00"), LocalTime.parse("22:00:00"), new ZoneType[] {ZoneType.GYM, ZoneType.SWIMMING_POOL, ZoneType.GROUP_TRAINING});

    private LocalTime startTime;
    private LocalTime endTime;
    private ZoneType[] zoneType;

    PassType(LocalTime startTime, LocalTime endTime, ZoneType[] zoneType) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.zoneType = ZoneType.values();
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public ZoneType[] getZoneType() {
        return zoneType;
    }
}
