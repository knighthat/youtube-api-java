package me.knighthat.innertube;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Utils {

    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDate EPOCH = LocalDate.ofEpochDay(0);

    public static long getTimeStamp() {
        return ChronoUnit.DAYS.between( EPOCH, TODAY ) - 1;
    }
}
