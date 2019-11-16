package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Autonomous Mode")

//when start pressed, start timer for 30 seconds, stop when ends

public class Amelias_Auto_Left_V2 extends LinearOpMode {
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private DcMotor armMotor;
    private Servo servo1;
    private Servo servo2;
    // private Servo servo3; private Servo servo4;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        armMotor = hardwareMap.get(DcMotor.class, "ArmMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "" + "LeftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "RightMotor");
        //servo 1 =servo1+2 and servo 2 = servo3+servo4
        servo1 = hardwareMap.get(Servo.class, "Servo1");
        servo2 = hardwareMap.get(Servo.class, "Servo2");
        //  servo3 = hardwareMap.get(Servo.class, "Servo3");
        //  servo4 = hardwareMap.get(Servo.class, "Servo4");
        telemetry.addData("Status", "Running Amelia's RC");
        telemetry.update();
        waitForStart();
        double tgtPowerArm = 1;
        double tgtPowerLeft = 1;
        double tgtPowerRight = -1;
        telemetry.addData ( "Target Power", tgtPowerArm);
        telemetry.addData ( "Motor Power", armMotor.getPower());
        telemetry.addData ( "Target Power", tgtPowerLeft);
        telemetry.addData ( "Target Power", tgtPowerRight);
        telemetry.addData ( "Motor Power", leftMotor.getPower());
        telemetry.addData ( "Motor Power", rightMotor.getPower());
        telemetry.addData ("Servo Position", servo1.getPosition());
        telemetry.addData ("Servo Position", servo2.getPosition() );
        //   telemetry.addData ("Servo Position", servo3.getPosition());
        //  telemetry.addData ("Servo Position", servo4.getPosition() );
        telemetry.addData("Status", "Running");
        telemetry.update();
        //this is what the robot will do in autonomous


        //armraise(1,0.3);
        //wait(1000);
        //grabtest();
        // for above, where will the grab go to???
        moveStraight(0.3, 1);
        armraise(1, 0.5);
        grabtest();
        wait(1000);
        moveStraight(-1, 0.4);
        wait(1000000000);

/*
        moveStraight(1, 0.8);
        grab(1,1);
        moveStraight(-1,1);
        turn(1,1);
        moveStraight(1,1);
        release(1,1);
        moveStraight(-1,1);
        wait(10000000);

  */  }
    public void moveStraight(double power, double timeInSeconds){
        leftMotor.setPower(-power);
        rightMotor.setPower(power);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < timeInSeconds)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void turnright(double power, double timeInSeconds){
        leftMotor.setPower(power);
        rightMotor.setPower(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < timeInSeconds)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void turnleft(double power, double timeInSeconds){
        leftMotor.setPower(power);
        rightMotor.setPower(power);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < timeInSeconds)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    //add more functions, like arm movement
    //add stuff inside like grab parenthesis

    public void grab(double power, double timeInSeconds) {
        servo1.setPosition(180);
        servo2.setPosition(180);
        //  servo3.setPosition(0);
        //  servo4.setPosition(0);
        while (opModeIsActive() && (runtime.seconds() < timeInSeconds)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void grabtest() {
        servo1.setPosition(180);
        servo2.setPosition(180);
        //  servo3.setPosition(0);
        // servo4.setPosition(0);
        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
        telemetry.update();
    }




    public void release(double power, double timeInSeconds) {
        servo1.setPosition(85);
        servo2.setPosition(85);
        // servo3.setPosition(0);
        //  servo4.setPosition(0);
        while (opModeIsActive() && (runtime.seconds() < timeInSeconds)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }
    public void releasetest() {
        servo1.setPosition(85);
        servo2.setPosition(85);
        //   servo3.setPosition(0);
        //  servo4.setPosition(0);
        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
        telemetry.update();

    }

    public void armraise(double power, double timeInSeconds) {
        armMotor.setPower(power);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < timeInSeconds)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }
}

