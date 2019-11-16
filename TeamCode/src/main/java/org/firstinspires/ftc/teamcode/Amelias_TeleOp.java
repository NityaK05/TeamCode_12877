package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Amelias_TeleOp extends LinearOpMode {
    /*
       private Gyroscope imu;
       private DcMotor motorTest;
       private DigitalChannel digitalTouch;
       private DistanceSensor sensorColorRange;
       private Servo servoTest;
    */
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private DcMotor armMotor;
    private Servo servo1;
    private Servo servo2;

    @Override
    public void runOpMode() {
      /*
      imu = hardwareMap.get(Gyroscope.class, "imu");
      motorTest = hardwareMap.get(DcMotor.class, "motorTest");
      digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
      sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
      servoTest = hardwareMap.get(Servo.class, "servoTest");
      */

        //armMotor = hardwareMap.get(DcMotor.class, "ArmMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "" + "LeftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "RightMotor");
        armMotor = hardwareMap.get(DcMotor.class, "ArmMotor");

        // servo1=servo1+2 and servo 2=servo3+servo4 //
        servo1 = hardwareMap.get(Servo.class, "Servo1");
        servo2 = hardwareMap.get(Servo.class, "Servo2");

        telemetry.addData("Status", "Running Amelia's RC");
        telemetry.update();

        // run until the end of the match (driver presses STOP)
        double motorPower = 0;
        double armPower =0;

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        while (opModeIsActive()) {
            motorPower = 0.5 * this.gamepad1.left_stick_y;
            armPower = 0; //this.gamepad1.right_stick_y;

            leftMotor.setPower(motorPower);
            rightMotor.setPower(motorPower);
            armMotor.setPower(armPower);

            Turn();

            telemetry.addData("Left Motor Power", leftMotor.getPower());
            telemetry.addData("Right Motor Power", rightMotor.getPower());
            telemetry.addData("Arm Motor Power", armMotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }

    public void Turn() {
        double leftPower = 0;
        double rightPower = 0;

        if (this.gamepad1.left_stick_x < 0) {
            leftPower = 0.5;
            rightPower = 1;
            telemetry.addData("I'm turning left...", "leftPower");
        } else if (this.gamepad1.left_stick_x > 0) {
            leftPower = 1;
            rightPower = 0.5;
            telemetry.addData("I'm turning right...", "rightPower");
        }

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }
}
