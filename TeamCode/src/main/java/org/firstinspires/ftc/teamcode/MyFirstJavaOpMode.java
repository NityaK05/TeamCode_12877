package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class MyFirstJavaOpMode extends LinearOpMode {
    // private Gyroscope imu;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor armMotor;
    /* private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest; */

    @Override
    public void runOpMode() {
        // imu = hardwareMap.get(Gyroscope.class, "imu");
        leftMotor = hardwareMap.get(DcMotor.class, "LeftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "RightMotor");
        armMotor = hardwareMap.get(DcMotor.class, "ArmMotor");
        /* digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest"); */

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPowerArm = 1;
        double tgtPowerLeft = 1;
        double tgtPowerRight = -1;
        while (opModeIsActive()) {
            tgtPowerArm = 1* this.gamepad1.right_stick_y;
            tgtPowerLeft = 1* this.gamepad1.left_stick_y;
            tgtPowerRight = -1* this.gamepad1.left_stick_y;
            armMotor.setPower(tgtPowerArm);
            leftMotor.setPower(tgtPowerLeft);
            rightMotor.setPower(tgtPowerRight);
            Turn();
            telemetry.addData("Target Power", tgtPowerArm);
            telemetry.addData("Target Power", tgtPowerLeft);
            telemetry.addData("Target Power", tgtPowerRight);
            telemetry.addData("Motor Power", armMotor.getPower());
            telemetry.addData("Motor Power", leftMotor.getPower());
            telemetry.addData("Motor Power", rightMotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }

    public void Turn(){
        double leftPower = 0;
        double rightPower = 0;

        if(this.gamepad1.left_stick_y>0) {
            leftPower = 0;
            rightPower = 1 * this.gamepad1.left_stick_y;
            telemetry.addData("I'm Turning Left!", "leftPower");
        }
        else {
            leftPower = 1* this.gamepad1.left_stick_y;
            rightPower = 0;
            telemetry.addData("I'm Turning Right!", "rightPower");
        }

        leftMotor.setPower (leftPower);
        rightMotor.setPower(rightPower);
    }
}
