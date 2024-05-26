package io.ysb.fizzbuzz.studentattendance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentAttendanceRecordIITest {

    @Test
    void shouldIncludeAllDays() {
        StudentAttendanceRecordII balancedBraces = new StudentAttendanceRecordII();

        assertEquals(8, balancedBraces.checkRecord(2));
    }

    @Test
    void shouldExcludeTooBigAbsenceDays() {
        StudentAttendanceRecordII balancedBraces = new StudentAttendanceRecordII();

        assertEquals(3, balancedBraces.checkRecord(1));
    }

    @Test
    void shouldExcludeConsecutiveLateDays() {
        StudentAttendanceRecordII balancedBraces = new StudentAttendanceRecordII();

        assertEquals(183236316, balancedBraces.checkRecord(10101));
    }
}
