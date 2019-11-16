package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/*
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
*/

@TeleOp
public class Amelias_TeleOp_V1 extends LinearOpMode {
    // private Gyroscope imu;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor armMotor;
    private Servo servo1;
    private Servo servo2;
    //private Servo servo3;
    //private Servo servo4;
    /* private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest; */

    @Override
    public void runOpMode() {
        // imu = hardwareMap.get(Gyroscope.class, "imu");
        leftMotor = hardwareMap.get(DcMotor.class, "LeftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "RightMotor");
        armMotor = hardwareMap.get(DcMotor.class, "ArmMotor");
        servo1 = hardwareMap.get(Servo.class, "Servo1");
        servo2 = hardwareMap.get(Servo.class, "Servo2");
        //servo3 = hardwareMap.get(Servo.class, "Servo3");
        //servo4 = hardwareMap.get(Servo.class, "Servo4");
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
            boolean a = this.gamepad1.a;
            boolean b = this.gamepad1.b;

            tgtPowerArm = this.gamepad1.right_stick_y;
            //tgtPowerLeft = this.gamepad1.left_stick_y;
            //tgtPowerRight = this.gamepad1.left_stick_y;

            tgtPowerLeft = 0.5;
            tgtPowerRight = 0.5;

            armMotor.setPower(tgtPowerArm);
            leftMotor.setPower(tgtPowerLeft);
            rightMotor.setPower(tgtPowerRight);

            if (a) {
                servo1.setPosition(180);
                servo2.setPosition(180);
                //servo.setPosition(0.5);
                //servo4.setPosition(0.5);
            }

            if (b) {
                servo1.setPosition(85);
                servo2.setPosition(85);
                //servo3.setPosition(0);
                //servo4.setPosition(0);
            }

            Turn();

            telemetry.addData("Target Power", tgtPowerArm);
            telemetry.addData("Target Power", tgtPowerLeft);
            telemetry.addData("Target Power", tgtPowerRight);
            telemetry.addData("Motor Power", armMotor.getPower());
            telemetry.addData("Motor Power", leftMotor.getPower());
            telemetry.addData("Motor Power", rightMotor.getPower());
            telemetry.addData("Servo1 Position", servo1.getPosition());
            telemetry.addData("Servo2 Position", servo2.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
            waitForStart();
        }
    }
    public void Turn() {
        double leftPower = 0;
        double rightPower = 0;
        // instead of double, how about int? Int can use negative powers as well... double can't have negative powers.

        if (this.gamepad1.left_stick_y > 0) {
            //leftPower = this.gamepad1.left_stick_y+0.5*this.gamepad1.left_stick_x;
            //rightPower = -0.5*this.gamepad1.left_stick_y-0.5*this.gamepad1.left_stick_x;

            //leftPower = 0;
            //rightPower = 0.5;

            leftPower = 0;
            rightPower = 1;

            telemetry.addData("I'm Turning Left!", "leftPower");
        } else if (this.gamepad1.left_stick_y < 0) {
            //leftPower = 0.5*this.gamepad1.left_stick_y-0.5*this.gamepad1.left_stick_x;
            //rightPower = -0.5* this.gamepad1.left_stick_y+0.5*this.gamepad1.left_stick_x;

            //leftPower = 0.5;
            //rightPower = 0;

            leftPower = 1;
            rightPower = 0;

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);
        }
    }
}