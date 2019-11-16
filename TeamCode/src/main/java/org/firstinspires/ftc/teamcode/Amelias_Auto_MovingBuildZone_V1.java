package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Amelias_Auto_MovingBuildZone_V1 extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor armMotor;

    @Override
    public void runOpMode() {
        leftMotor = hardwareMap.get(DcMotor.class, "LeftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "RightMotor");
        armMotor = hardwareMap.get(DcMotor.class, "ArmMotor");

        // Setting the REVERSE direction on right motor
        // change this to leftMotor if it moves backward
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        double DRIVE_POWER = 1.0;

        waitForStart();

        DragBoardFromCenterToBuildingZone();
        Stop();

    }

    public void DragBoardFromCenterToBuildingZone() {
        double DRIVE_POWER = 1.0;
        double DRIVE_POWER_05 = 0.5;

        //Drive forward to the building zone board
        DriveForwardDuration(DRIVE_POWER_05, 500);
        //Move the arm up (positive power)
        MoveArm(DRIVE_POWER, 250);
        //Move the arm down (negative power)
        MoveArm(-DRIVE_POWER, 250);
        //Pull the building zone board back (not all the way)
        DriveBackwardsDuration(DRIVE_POWER, 750);
        //Move the arm up (positive power)
        MoveArm(DRIVE_POWER, 250);
        //Turn right 90 degrees
        TurnRightDuration(DRIVE_POWER, 250);
        //Move forward
        DriveForwardDuration(DRIVE_POWER, 1000);
        //Turn left 90 degrees
        TurnLeftDuration(DRIVE_POWER, 250);
        //Move forward
        DriveForwardDuration(DRIVE_POWER, 2500);
        //Turn left 90 degrees
        TurnLeftDuration(DRIVE_POWER, 250);
        //Move forward
        DriveForwardDuration(DRIVE_POWER, 1000);
        //Turn left 90 degrees
        TurnLeftDuration(DRIVE_POWER, 250);
        //Move backwards
        DriveBackwardsDuration(-DRIVE_POWER, 100);
        //Move the arm down (negative power)
        MoveArm(DRIVE_POWER, 250);
        //Push the building zone board to the triangular parking area
        DriveForwardDuration(DRIVE_POWER, 1000);

    }

    public void DriveForwardDuration(double power, long duration) {
        DriveForward(power);
        sleep(duration);
        Stop();
    }

    public void DriveForward(double power) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }

    public void DriveBackwardsDuration(double power, long duration) {
        DriveBackwards(power);
        sleep(duration);
        Stop();
    }

    public void DriveBackwards(double power) {
        leftMotor.setPower(-power);
        rightMotor.setPower(-power);
    }

    public void TurnRightDuration(double power, long duration) {
        DriveRight(power);
        sleep(duration);
        Stop();
    }

    public void DriveRight(double power) {
        leftMotor.setPower(power);
        rightMotor.setPower(-power);
    }

    public void TurnLeftDuration(double power, long duration) {
        DriveLeft(power);
        sleep(duration);
        Stop();
    }

    public void DriveLeft(double power) {
        leftMotor.setPower(-power);
        rightMotor.setPower(power);
    }

    public void Stop() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public void MoveArm(double power, long duration) {
        DriveForward(power);
        sleep(duration);
        Stop();
    }

    public void MoveArm(double power) {
        armMotor.setPower(power);

    }
}

